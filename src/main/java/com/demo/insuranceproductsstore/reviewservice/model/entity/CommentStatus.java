package com.demo.insuranceproductsstore.reviewservice.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comment_status")
public class CommentStatus {

    private Long id;
    private String name;
    private String code;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
