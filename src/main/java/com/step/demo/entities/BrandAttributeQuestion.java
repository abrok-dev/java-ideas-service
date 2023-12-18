package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "brand_attribute_questions")
@SQLDelete(sql = "UPDATE brand_attribute_questions SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedBrandAttributeQuestionsFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedBrandAttributeQuestionFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allBrandAttributeQuestionFilter", defaultCondition = "1=1")
@Filter(name = "allBrandAttributeQuestionFilter", condition = "1=1")
@EntityListeners(AuditingEntityListener.class)
public class BrandAttributeQuestion implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "sorting_list", columnDefinition = "INTEGER default 500")
    private int sortingList;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_attribute_id",
            foreignKey = @ForeignKey(name = "brand_attribute_fk")
    )
    private BrandAttribute brandAttribute;

    @OneToMany(targetEntity = BrandAttributeAnswer.class, fetch = FetchType.LAZY)
    private List<BrandAttributeAnswer> brandAttributeAnswers;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

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

    public BrandAttribute getBrandAttribute() {
        return brandAttribute;
    }

    public void setBrandAttribute(BrandAttribute brandAttribute) {
        this.brandAttribute = brandAttribute;
    }

    public List<BrandAttributeAnswer> getBrandAttributeAnswers() {
        return brandAttributeAnswers;
    }

    public void setBrandAttributeAnswers(List<BrandAttributeAnswer> brandAttributeAnswers) {
        this.brandAttributeAnswers = brandAttributeAnswers;
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

    public void setId(Long id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BrandAttributeQuestion that = (BrandAttributeQuestion) o;
//        return sortingList == that.sortingList && deleted == that.deleted && Objects.equals(id, that.id)
//                && Objects.equals(name, that.name) && Objects.equals(brandAttribute, that.brandAttribute)
//                && Objects.equals(brandAttributeAnswers, that.brandAttributeAnswers) && Objects.equals(createDate, that.createDate)
//                && Objects.equals(updateDate, that.updateDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, sortingList, name, brandAttribute, brandAttributeAnswers, createDate, updateDate, deleted);
//    }
}
