package com.demo.insuranceproductsstore.reviewservice.repository;

import com.demo.insuranceproductsstore.reviewservice.model.entity.CommentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentStatusRepo extends JpaRepository<CommentStatus, Long> {

    CommentStatus getCommentStatusByCode(String code);
}
