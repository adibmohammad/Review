package com.demo.insuranceproductsstore.reviewservice.model.dto;

import javax.validation.constraints.NotBlank;

public class PlanRequestDto {

    private Long planId;
    @NotBlank(message = " Please Enter User Name ")
    private String username;
    private boolean globalComment;
    private boolean permitCommentFlag;
    private boolean disableDate;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isGlobalComment() {
        return globalComment;
    }

    public void setGlobalComment(boolean globalComment) {
        this.globalComment = globalComment;
    }

    public boolean isPermitCommentFlag() {
        return permitCommentFlag;
    }

    public void setPermitCommentFlag(boolean permitCommentFlag) {
        this.permitCommentFlag = permitCommentFlag;
    }

    public boolean isDisableDate() {
        return disableDate;
    }

    public void setDisableDate(boolean disableDate) {
        this.disableDate = disableDate;
    }
}
