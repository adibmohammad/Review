package com.demo.insuranceproductsstore.reviewservice.model.entity;

import com.demo.insuranceproductsstore.reviewservice.model.common.AuditModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plan")
public class Plan extends AuditModel {

    private Long id;
    private String planName;
    private String description;
    private Date disableDate;
    private Product product;
    private Provider provider;
    private Long price;
    private Boolean globalComment;
    private Boolean permitCommentFlag;
    private List<PlanComment> commentList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "plan_name")
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "disable_date")
    @Temporal(value = TemporalType.DATE)
    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Column(name = "price")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Column(name = "is_global_comment")
    public Boolean getGlobalComment() {
        return globalComment;
    }

    public void setGlobalComment(Boolean globalComment) {
        this.globalComment = globalComment;
    }

    @Column(name = "permit_comment")
    public Boolean getPermitCommentFlag() {
        return permitCommentFlag;
    }

    public void setPermitCommentFlag(Boolean permitCommentFlag) {
        this.permitCommentFlag = permitCommentFlag;
    }

    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    public List<PlanComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<PlanComment> commentList) {
        this.commentList = commentList;
    }
}
