package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Initiative implements BaseEntity {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "author_id",
            foreignKey = @ForeignKey(name = "author_id_fk")
    )
    private User author;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiative_id", foreignKey = @ForeignKey(name = "initiative_id_fk"))
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

    @OneToMany(targetEntity = InitiativeInitiativeTypeField.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "initiative_id", foreignKey = @ForeignKey(name = "initiative_id_fk"))
    private List<InitiativeInitiativeTypeField> initiativeTypeFieldValue;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InitiativeType getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(InitiativeType initiativeType) {
        this.initiativeType = initiativeType;
    }

    public InitiativeStatus getInitiativeStatus() {
        return initiativeStatus;
    }

    public void setInitiativeStatus(InitiativeStatus initiativeStatus) {
        this.initiativeStatus = initiativeStatus;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<BrandAttributeEstimate> getBrandAttributeEstimates() {
        return brandAttributeEstimates;
    }

    public void setBrandAttributeEstimates(List<BrandAttributeEstimate> brandAttributeEstimates) {
        this.brandAttributeEstimates = brandAttributeEstimates;
    }

    public User getBrandManager() {
        return brandManager;
    }

    public void setBrandManager(User brandManager) {
        this.brandManager = brandManager;
    }

    public int getAuthorRating() {
        return authorRating;
    }

    public void setAuthorRating(int authorRating) {
        this.authorRating = authorRating;
    }

    public int getBrandManagerRating() {
        return brandManagerRating;
    }

    public void setBrandManagerRating(int brandManagerRating) {
        this.brandManagerRating = brandManagerRating;
    }

    public boolean isTakenToWork() {
        return isTakenToWork;
    }

    public void setTakenToWork(boolean takenToWork) {
        isTakenToWork = takenToWork;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<InitiativeInitiativeTypeField> getInitiativeTypeFieldValue() {
        return initiativeTypeFieldValue;
    }

    public void setInitiativeTypeFieldValue(List<InitiativeInitiativeTypeField> initiativeTypeFieldValue) {
        this.initiativeTypeFieldValue = initiativeTypeFieldValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Initiative that = (Initiative) o;
        return authorRating == that.authorRating && brandManagerRating == that.brandManagerRating && isTakenToWork == that.isTakenToWork
                && isDeleted == that.isDeleted && Objects.equals(name, that.name)
                && Objects.equals(description, that.description) && Objects.equals(initiativeType, that.initiativeType)
                && Objects.equals(initiativeStatus, that.initiativeStatus) && Objects.equals(author, that.author) &&
                Objects.equals(expiredDate, that.expiredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, initiativeType, initiativeStatus, author, authorRating, brandManagerRating, isTakenToWork, expiredDate, isDeleted);
    }
}
