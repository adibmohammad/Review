package com.demo.insuranceproductsstore.reviewservice.repository;

import com.demo.insuranceproductsstore.reviewservice.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlanRepo extends JpaRepository<Plan, Long> {

    @Query(" from Plan pl join pl.provider pr join pl.product p where p.id = :productId and pl.disableDate is null ")
    List<Plan> getAllActivePlan(Long productId, Pageable pageable);
    Optional<Plan> getPlanByIdAndDisableDateIsNull(Long id);
}
