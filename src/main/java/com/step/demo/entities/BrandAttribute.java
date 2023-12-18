package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "brand_attributes")
@SQLDelete(sql = "UPDATE brand_attributes SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedBrandAttributeFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedBrandAttributeFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allBrandAttributeFilter", defaultCondition = "1=1")
@Filter(name = "allBrandAttributeFilter", condition = "1=1")
@EntityListeners(AuditingEntityListener.class)
public class BrandAttribute implements BaseEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "sorting_list", columnDefinition = "INTEGER default 500")
    private int sortingList;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "hint", length = 1000)
    private String hint;
    @Column(name = "activity", nullable = false)
    private boolean activity;
    @Column(name = "has_question", nullable = false)
    private boolean hasQuestion;

    @ManyToOne(targetEntity = InitiativeType.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "initiative_type_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "initiative_type_id_fk")
    )
    private InitiativeType initiativeType;

    @OneToMany(targetEntity = BrandAttributeQuestion.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BrandAttributeQuestion> brandAttributeQuestions;

    @OneToMany(targetEntity = BrandAttributeEstimate.class, fetch = FetchType.LAZY)
    private List<BrandAttributeEstimate> brandAttributeEstimates;

    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    public int getSortingList() {
        return sortingList;
    }

    public void setSortingList(int sortingList) {
        this.sortingList = sortingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public boolean isHasQuestion() {
        return hasQuestion;
    }

    public void setHasQuestion(boolean hasQuestion) {
        this.hasQuestion = hasQuestion;
    }

    public InitiativeType getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(InitiativeType initiativeType) {
        this.initiativeType = initiativeType;
    }

    public List<BrandAttributeQuestion> getBrandAttributeQuestions() {
        return brandAttributeQuestions;
    }

    public void setBrandAttributeQuestions(List<BrandAttributeQuestion> brandAttributeQuestions) {
        this.brandAttributeQuestions = brandAttributeQuestions;
    }

    public List<BrandAttributeEstimate> getBrandAttributeEstimates() {
        return brandAttributeEstimates;
    }

    public void setBrandAttributeEstimates(List<BrandAttributeEstimate> brandAttributeEstimates) {
        this.brandAttributeEstimates = brandAttributeEstimates;
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
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
