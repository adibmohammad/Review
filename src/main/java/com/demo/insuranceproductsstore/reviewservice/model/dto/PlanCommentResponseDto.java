package com.demo.insuranceproductsstore.reviewservice.model.dto;

import com.demo.insuranceproductsstore.reviewservice.configuration.Config;
import com.demo.insuranceproductsstore.reviewservice.model.entity.PlanComment;

public class PlanCommentResponseDto {

    private String comment;
    private Integer score;

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

    public static PlanCommentResponseDto convertToDto(PlanComment planComment) {
        return Config.modelMapper().map(planComment, PlanCommentResponseDto.class);
    }
}
