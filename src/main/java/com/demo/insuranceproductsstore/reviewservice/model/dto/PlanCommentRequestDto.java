package com.demo.insuranceproductsstore.reviewservice.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlanCommentRequestDto {

    @NotNull(message = " Plan Id Not Null ")
    private Long planId;
    private String username;
    @NotBlank(message = " Comment Is Not Blank")
    private String comment;
    @Min(value = 0, message = "")
    @Max(value = 5, message = "")
    private Integer score;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
