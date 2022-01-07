package com.demo.insuranceproductsstore.reviewservice.service.impl;

import com.demo.insuranceproductsstore.reviewservice.exception.CommentAccessDeniedException;
import com.demo.insuranceproductsstore.reviewservice.exception.RecordNotFoundException;
import com.demo.insuranceproductsstore.reviewservice.exception.RegisterCommentException;
import com.demo.insuranceproductsstore.reviewservice.model.dto.*;
import com.demo.insuranceproductsstore.reviewservice.model.entity.Plan;
import com.demo.insuranceproductsstore.reviewservice.model.entity.PlanComment;
import com.demo.insuranceproductsstore.reviewservice.model.entity.Product;
import com.demo.insuranceproductsstore.reviewservice.model.enums.CommentStatusEnum;
import com.demo.insuranceproductsstore.reviewservice.model.enums.UserStatusEnum;
import com.demo.insuranceproductsstore.reviewservice.repository.*;
import com.demo.insuranceproductsstore.reviewservice.service.api.ReviewService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ProductRepo productRepo;
    private final PlanRepo planRepo;
    private final PlanCommentRepo planCommentRepo;
    private final UserRepo userRepo;
    private final CommentStatusRepo commentStatusRepo;

    public ReviewServiceImpl(ProductRepo productRepo, PlanRepo planRepo, PlanCommentRepo planCommentRepo, UserRepo userRepo, CommentStatusRepo commentStatusRepo) {
        this.productRepo = productRepo;
        this.planRepo = planRepo;
        this.planCommentRepo = planCommentRepo;
        this.userRepo = userRepo;
        this.commentStatusRepo = commentStatusRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProductList() {
        List<Product> productList = productRepo.findAllByDisableDateIsNull();

        if (productList == null || productList.isEmpty()) {
            throw new RecordNotFoundException("Record Not Found");
        }

        return productList.stream().map(ProductResponseDto::convertToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanResponseDto> getPlanList(Long productId, int page, int size) {
        List<Plan> planList = planRepo.getAllActivePlan(productId, PageRequest.of(page, size));

        if (planList == null || planList.isEmpty()) {
            throw new RecordNotFoundException("Record Not Found By Product Id : " + productId);
        }

        List<PlanResponseDto> planDtoList = planList.stream().map(PlanResponseDto::convertToDto).collect(Collectors.toList());

        for (PlanResponseDto item : planDtoList) {
            List<PlanComment> planCommentList = planCommentRepo.getPlanCommentsByPlanIdAndCommentStatusCode(item.getId(), CommentStatusEnum.CONFIRM.getType(), PageRequest.of(0, 3));
            if (planCommentList != null || !planCommentList.isEmpty()) {
                item.setPlanCommentDtoList(planCommentList.stream().map(PlanCommentResponseDto::convertToDto).collect(Collectors.toList()));
                item.setCountComment(planCommentRepo.countPlanCommentsByPlanIdAndAndCommentStatusCode(item.getId(), CommentStatusEnum.CONFIRM.getType()));
                item.setAverageScore(planCommentRepo.averageScore(item.getId(), CommentStatusEnum.CONFIRM.getType()));
            }
        }

        return planDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanCommentResponseDto> getNotApproveCommentList(Long planId, String username, int page, int size) {

        if (username == null || username.trim().equals("") || username.equals(UserStatusEnum.UNKNOWN.getType())) {
            throw new CommentAccessDeniedException("This User Does Not Have Access To Comment Approval");
        }
        userRepo.getUserByUsernameAndAndUserStatusCode(username, UserStatusEnum.ADMIN.getType())
                .orElseThrow(() -> new CommentAccessDeniedException("This User Does Not Have Access To Comment Approval"));

        List<PlanComment> planCommentList = planCommentRepo.getPlanCommentsByPlanIdAndCommentStatusCode(planId, CommentStatusEnum.NOT_CONFIRM.getType(), PageRequest.of(page, size));
        return planCommentList.stream().map(PlanCommentResponseDto::convertToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String registerComment(PlanCommentRequestDto request) {

        Plan plan = getPlan(request.getPlanId());
        if (!plan.getPermitCommentFlag()) {
            throw new RegisterCommentException("Register Comment For This Plan Is Disabled");
        } else if (!plan.getGlobalComment()) {
            userRepo.getUserByUsername(request.getUsername())
                    .orElseThrow(() -> new RegisterCommentException("Register Comment For Active User Only"));
        }
        planCommentRepo.save(new PlanComment(request.getComment()
                , request.getScore()
                , plan
                , commentStatusRepo.getCommentStatusByCode(CommentStatusEnum.NOT_CONFIRM.getType())));
        return "Your Comment Has Been Registered";
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String updateGlobalCommentOnPlan(PlanRequestDto request) {

        checkUser(request.getUsername());
        Plan plan = getPlan(request.getPlanId());
        plan.setGlobalComment(request.isGlobalComment());
        planRepo.save(plan);
        return "Updated";
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String updatePermitCommentFlagOnPlan(PlanRequestDto request) {

        checkUser(request.getUsername());
        Plan plan = getPlan(request.getPlanId());
        plan.setPermitCommentFlag(request.isPermitCommentFlag());
        planRepo.save(plan);
        return "Updated";
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String updateDisableDateOnPlan(PlanRequestDto request) {
        checkUser(request.getUsername());
        Plan plan = getPlan(request.getPlanId());
        if (request.isDisableDate()) {
            plan.setDisableDate(new Date());
        } else {
            plan.setDisableDate(null);
        }
        planRepo.save(plan);
        return "Updated";
    }

    private void checkUser(String username) {

        userRepo.getUserByUsernameAndAndUserStatusCode(username, UserStatusEnum.ADMIN.getType())
                .orElseThrow(() -> new CommentAccessDeniedException("This User Does Not Have Access To Comment Approval"));
    }

    private Plan getPlan(Long id) {
        return planRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("Record Not Found By Id : " + id));
    }
}
