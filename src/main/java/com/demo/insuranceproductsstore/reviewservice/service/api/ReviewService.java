package com.demo.insuranceproductsstore.reviewservice.service.api;

import com.demo.insuranceproductsstore.reviewservice.model.dto.*;

import java.util.List;

public interface ReviewService {
    List<ProductResponseDto> getProductList();
    List<PlanResponseDto> getPlanList(Long productId, int page, int size);
    List<PlanCommentResponseDto> getNotApproveCommentList(Long planId, String username, int page, int size);
    String registerComment(PlanCommentRequestDto request);
    String updateGlobalCommentOnPlan(PlanRequestDto request);
    String updatePermitCommentFlagOnPlan(PlanRequestDto request);
    String updateDisableDateOnPlan(PlanRequestDto request);
}
