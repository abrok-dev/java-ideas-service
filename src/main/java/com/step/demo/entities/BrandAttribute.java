package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
public class BrandAttribute {

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
    @Column(name = "reportable", nullable = false)
    private boolean reportable;
    @Column(name = "has_question", nullable = false)
    private boolean hasQuestion;

    @ManyToOne
    @JoinColumn(
            name = "initiative_type_id",
            foreignKey = @ForeignKey(name = "initiative_type_id_fk")
    )
    private InitiativeType initiativeType;

    @OneToMany(targetEntity = BrandAttributeQuestion.class, fetch = FetchType.EAGER)
    private List<BrandAttributeQuestion> brandAttributeQuestions;

    @OneToMany
    private List<BrandAttributeEstimate> brandAttributeEstimates;

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
        BrandAttribute that = (BrandAttribute) o;
        return id == that.id && sortingList == that.sortingList && activity == that.activity && reportable == that.reportable
                && hasQuestion == that.hasQuestion && deleted == that.deleted && Objects.equals(name, that.name)
                && Objects.equals(hint, that.hint) && Objects.equals(initiativeType, that.initiativeType)
                && Objects.equals(brandAttributeQuestions, that.brandAttributeQuestions)
                && Objects.equals(brandAttributeEstimates, that.brandAttributeEstimates)
                && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sortingList, name, hint, activity, reportable, hasQuestion, initiativeType, brandAttributeQuestions, brandAttributeEstimates, createDate, updateDate, deleted);
    }
}
