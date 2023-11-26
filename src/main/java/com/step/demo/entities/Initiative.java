package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "initiatives")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedInitiativeFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedInitiativeFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allInitiativeFilter", defaultCondition = "1=1")
@Filter(name = "allInitiativeFilter", condition = "1=1")
public class Initiative {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description", length = 512)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "initiative_type_id",
            foreignKey = @ForeignKey(name = "initiative_type_id_fk")
    )
    private InitiativeType initiativeType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "initiative_status_id",
            foreignKey = @ForeignKey(name = "initiative_status_id_fk")
    )
    private InitiativeStatus initiativeStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "author_id",
            foreignKey = @ForeignKey(name = "author_id_fk")
    )
    private User author;

    @OneToMany(fetch = FetchType.LAZY)
    private List<BrandAttributeEstimate> brandAttributeEstimates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_manager_id",
            foreignKey = @ForeignKey(name = "brand_manager_id_fk")
    )
    private User brandManager;

    @Column(name = "author_rating")
    private int authorRating;

    @Column(name = "brand_manager_rating")
    private int brandManagerRating;

    @Column(name = "is_taken_to_work")
    private boolean isTakenToWork;

    @Column(name = "expired_date")
    private Date expiredDate;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean isDeleted = false;

    @OneToMany
    private List<InitiativeInitiativeTypeField> initiativeTypeFieldValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Initiative that = (Initiative) o;
        return authorRating == that.authorRating && brandManagerRating == that.brandManagerRating && isTakenToWork == that.isTakenToWork
                && isDeleted == that.isDeleted && Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(description, that.description) && Objects.equals(initiativeType, that.initiativeType)
                && Objects.equals(initiativeStatus, that.initiativeStatus) && Objects.equals(author, that.author)
                && Objects.equals(brandAttributeEstimates, that.brandAttributeEstimates)
                && Objects.equals(brandManager, that.brandManager) && Objects.equals(expiredDate, that.expiredDate)
                && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate)
                && Objects.equals(initiativeTypeFieldValue, that.initiativeTypeFieldValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, initiativeType, initiativeStatus, author, brandAttributeEstimates, brandManager, authorRating, brandManagerRating, isTakenToWork, expiredDate, createDate, updateDate, isDeleted, initiativeTypeFieldValue);
    }
}
