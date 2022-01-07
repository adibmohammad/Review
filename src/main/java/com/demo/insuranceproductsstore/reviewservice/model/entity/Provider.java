package com.demo.insuranceproductsstore.reviewservice.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "provider")
public class Provider {

    private Long id;
    private String providerCode;
    private String providerName;
    private Date disableDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "provider_code")
    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    @Column(name = "provider_name")
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Column(name = "disable_date")
    @Temporal(value = TemporalType.DATE)
    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }
}
