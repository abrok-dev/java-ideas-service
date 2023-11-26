package com.step.demo.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "brand_attribute_estimates")
public class BrandAttributeEstimate {

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

    @LastModifiedDate
    private Date updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandAttributeEstimate that = (BrandAttributeEstimate) o;
        return Objects.equals(id, that.id) && Objects.equals(initiative, that.initiative) && Objects.equals(user, that.user)
                && Objects.equals(brandAttribute, that.brandAttribute) && Objects.equals(role, that.role)
                && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initiative, user, brandAttribute, role, createDate, updateDate);
    }
}
