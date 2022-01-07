package com.demo.insuranceproductsstore.reviewservice.rest.controller;

import com.demo.insuranceproductsstore.reviewservice.model.dto.PlanCommentRequestDto;
import com.demo.insuranceproductsstore.reviewservice.model.dto.PlanRequestDto;
import com.demo.insuranceproductsstore.reviewservice.service.api.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/" + ReviewController.PATH)
public class ReviewController {

    public static final String PATH = "products";

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping
    public ResponseEntity getProductList() {
        return new ResponseEntity(reviewService.getProductList(), HttpStatus.OK);
    }

    @GetMapping(value = "/plans/{productId}")
    public ResponseEntity getPlanList(@PathVariable Long productId, @RequestParam int page, @RequestParam int size) {
        return new ResponseEntity(reviewService.getPlanList(productId, page, size), HttpStatus.OK);
    }

    @GetMapping(value = "/plans/{planId}/{username}/comment")
    public ResponseEntity getNotApproveCommentList(@PathVariable Long planId, @PathVariable String username, @RequestParam int page, @RequestParam int size) {
        return new ResponseEntity(reviewService.getNotApproveCommentList(planId, username, page, size), HttpStatus.OK);
    }

    @PostMapping(value = "/registerComment")
    public ResponseEntity registerComment(@RequestBody @Valid PlanCommentRequestDto request) {
        return new ResponseEntity(reviewService.registerComment(request), HttpStatus.OK);
    }

    @PutMapping("/updateGlobalComment")
    public ResponseEntity updateGlobalCommentOnPlan(@RequestBody @Valid PlanRequestDto request) {
        return new ResponseEntity(reviewService.updateGlobalCommentOnPlan(request), HttpStatus.OK);
    }

    @PutMapping("/updatePermitComment")
    public ResponseEntity updatePermitCommentFlagOnPlan(@RequestBody @Valid PlanRequestDto request) {
        return new ResponseEntity(reviewService.updatePermitCommentFlagOnPlan(request), HttpStatus.OK);
    }

    @PutMapping("/updateDisableDate")
    public ResponseEntity updateDisableDateOnPlan(@RequestBody @Valid PlanRequestDto request) {
        return new ResponseEntity(reviewService.updateDisableDateOnPlan(request), HttpStatus.OK);
    }
}
