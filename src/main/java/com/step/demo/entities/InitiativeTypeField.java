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
@Table(name = "initiative_type_fields")
@SQLDelete(sql = "UPDATE initiative_type_fields SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedInitiativeTypeFieldsFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedInitiativeTypeFieldsFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allInitiativeTypeFieldsFilter", defaultCondition = "1=1")
@Filter(name = "allInitiativeTypeFieldsFilter", condition = "1=1")
public class InitiativeTypeField implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "sorting_list")
    private Integer sortingList;

    @Column(name = "name", length = 1000)
    private String name;

    @Column(name = "hint", length = 1000)
    private String hint;

    @Column(name = "required", nullable = false)
    private boolean required = Boolean.FALSE;

    @Column(name = "step")
    private int step;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_type_id",
            foreignKey = @ForeignKey(name = "initiative_type_id_fk")
    )
    private InitiativeType initiativeType;

    @OneToMany(targetEntity = InitiativeInitiativeTypeField.class, fetch = FetchType.LAZY)
    private List<InitiativeInitiativeTypeField> initiativeTypeFieldList;
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSortingList() {
        return sortingList;
    }

    public void setSortingList(Integer sortingList) {
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public InitiativeType getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(InitiativeType initiativeType) {
        this.initiativeType = initiativeType;
    }

    public List<InitiativeInitiativeTypeField> getInitiativeTypeFieldList() {
        return initiativeTypeFieldList;
    }

    public void setInitiativeTypeFieldList(List<InitiativeInitiativeTypeField> initiativeTypeFieldList) {
        this.initiativeTypeFieldList = initiativeTypeFieldList;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        InitiativeTypeField that = (InitiativeTypeField) o;
//        return isRequired() == that.isRequired() && getStep() == that.getStep() && isDeleted() == that.isDeleted() && Objects.equals(getId(), that.getId()) && Objects.equals(getSortingList(), that.getSortingList()) && Objects.equals(getName(), that.getName()) && Objects.equals(getHint(), that.getHint()) && Objects.equals(getInitiativeType(), that.getInitiativeType()) && Objects.equals(getInitiativeTypeFieldList(), that.getInitiativeTypeFieldList()) && Objects.equals(getCreatedDate(), that.getCreatedDate()) && Objects.equals(getUpdateDate(), that.getUpdateDate());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getSortingList(), getName(), getHint(), isRequired(), getStep(), getInitiativeType(), getInitiativeTypeFieldList(), getCreatedDate(), getUpdateDate(), isDeleted());
//    }
}
