package com.demo.insuranceproductsstore.reviewservice.model.entity;

import com.demo.insuranceproductsstore.reviewservice.model.common.AuditModel;

import javax.persistence.*;

@Entity
@Table(name = "plan_comment")
public class PlanComment extends AuditModel {

    private Long id;
    private String comment;
    private Integer score;
    private Plan plan;
    private CommentStatus commentStatus;

    public PlanComment() {
    }

    public PlanComment(String comment, Integer score, Plan plan, CommentStatus commentStatus) {
        this.comment = comment;
        this.score = score;
        this.plan = plan;
        this.commentStatus = commentStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }
}
