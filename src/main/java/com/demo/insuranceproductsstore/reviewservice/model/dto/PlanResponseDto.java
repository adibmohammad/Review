package com.demo.insuranceproductsstore.reviewservice.model.dto;

import com.demo.insuranceproductsstore.reviewservice.configuration.Config;
import com.demo.insuranceproductsstore.reviewservice.model.entity.Plan;

import java.util.List;

public class PlanResponseDto {

    private Long id;
    private String planName;
    private String description;
    private Long price;
    private Boolean globalComment;
    private Boolean permitCommentFlag;
    private Long countComment;
    private Long averageScore;
    List<PlanCommentResponseDto> planCommentDtoList;
    private String providerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getGlobalComment() {
        return globalComment;
    }

    public void setGlobalComment(Boolean globalComment) {
        this.globalComment = globalComment;
    }

    public Boolean getPermitCommentFlag() {
        return permitCommentFlag;
    }

    public void setPermitCommentFlag(Boolean permitCommentFlag) {
        this.permitCommentFlag = permitCommentFlag;
    }

    public Long getCountComment() {
        return countComment;
    }

    public void setCountComment(Long countComment) {
        this.countComment = countComment;
    }

    public Long getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Long averageScore) {
        this.averageScore = averageScore;
    }

    public List<PlanCommentResponseDto> getPlanCommentDtoList() {
        return planCommentDtoList;
    }

    public void setPlanCommentDtoList(List<PlanCommentResponseDto> planCommentDtoList) {
        this.planCommentDtoList = planCommentDtoList;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public static PlanResponseDto convertToDto(Plan plan){
        return Config.modelMapper().map(plan, PlanResponseDto.class);
    }
}
