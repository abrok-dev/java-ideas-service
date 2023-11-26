package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
public class BrandAttributeQuestion {

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

    @OneToMany
    private List<BrandAttributeAnswer> brandAttributeAnswers;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandAttributeQuestion that = (BrandAttributeQuestion) o;
        return sortingList == that.sortingList && deleted == that.deleted && Objects.equals(id, that.id)
                && Objects.equals(name, that.name) && Objects.equals(brandAttribute, that.brandAttribute)
                && Objects.equals(brandAttributeAnswers, that.brandAttributeAnswers) && Objects.equals(createDate, that.createDate)
                && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sortingList, name, brandAttribute, brandAttributeAnswers, createDate, updateDate, deleted);
    }
}
