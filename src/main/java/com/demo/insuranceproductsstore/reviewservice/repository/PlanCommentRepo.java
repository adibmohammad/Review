package com.demo.insuranceproductsstore.reviewservice.repository;

import com.demo.insuranceproductsstore.reviewservice.model.entity.PlanComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanCommentRepo extends JpaRepository<PlanComment, Long> {

    Long countPlanCommentsByPlanIdAndAndCommentStatusCode(Long planId, String statusCode);
    List<PlanComment> getPlanCommentsByPlanIdAndCommentStatusCode(Long planId, String statusCode, Pageable pageable);

    @Query(" select avg(t.score) from PlanComment t where t.plan.id = :planId and t.commentStatus.code = :statusCode ")
    Long averageScore(Long planId, String statusCode);
}
