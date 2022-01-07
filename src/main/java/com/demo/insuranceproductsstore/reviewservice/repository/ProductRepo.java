package com.demo.insuranceproductsstore.reviewservice.repository;

import com.demo.insuranceproductsstore.reviewservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findAllByDisableDateIsNull();
}
