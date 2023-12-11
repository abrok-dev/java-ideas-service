package com.step.demo.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "brand_attribute_estimates")
public class BrandAttributeEstimate implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_id",
            foreignKey = @ForeignKey(name = "initiative_id_fk")
    )
    private Initiative initiative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "user_id_fk")
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "brand_attribute_id",
            foreignKey = @ForeignKey(name = "brand_attribute_fk")
    )
    private BrandAttribute brandAttribute;

    @Column(name = "role")
    private String role;

    @CreatedDate
    private Date createDate;

    @Column(name = "estimate")
    private int estimate;

    @LastModifiedDate
    private Date updateDate;

    public Initiative getInitiative() {
        return initiative;
    }

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BrandAttribute getBrandAttribute() {
        return brandAttribute;
    }

    public void setBrandAttribute(BrandAttribute brandAttribute) {
        this.brandAttribute = brandAttribute;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
