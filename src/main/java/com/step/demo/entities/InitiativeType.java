package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "initiative_types")
@SQLDelete(sql = "UPDATE initiative_types SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedInitiativeTypesFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedInitiativeTypesFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allInitiativeTypesFilter", defaultCondition = "1=1")
@Filter(name = "allInitiativeTypesFilter", condition = "1=1")
public class InitiativeType implements BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "sorting_list")
    private int sortingList;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @OneToMany(targetEntity = InitiativeTypeField.class, mappedBy = "initiativeType", fetch = FetchType.LAZY)
//    @JoinColumn(name = "initiative_type_id", foreignKey = @ForeignKey(name = "initiative_type_id_fk"))
    private List<InitiativeTypeField> initiativeTypeFieldList;

    @OneToMany(targetEntity = TargetAudience.class, mappedBy = "initiativeType", fetch = FetchType.LAZY)
//    @JoinColumn(name = "initiative_type_id", foreignKey = @ForeignKey(name = "initiative_type_id_fk"))
    private List<TargetAudience> targetAudienceList;

    @OneToMany(targetEntity = BrandAttribute.class, mappedBy = "initiativeType", fetch = FetchType.LAZY)
//    @JoinColumn(name = "initiative_type_id", foreignKey = @ForeignKey(name = "initiative_type_id_fk"))
    private List<BrandAttribute> brandAttributeList;

    @OneToMany(targetEntity = Initiative.class, mappedBy = "initiativeType", fetch = FetchType.LAZY)
//    @JoinColumn(name = "initiative_type_id", foreignKey = @ForeignKey(name = "initiative_type_id_fk"))
    private List<Initiative> initiativeList;

    public long getId() {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<InitiativeTypeField> getInitiativeTypeFieldList() {
        return initiativeTypeFieldList;
    }

    public void setInitiativeTypeFieldList(List<InitiativeTypeField> initiativeTypeFieldList) {
        this.initiativeTypeFieldList = initiativeTypeFieldList;
    }

    public List<TargetAudience> getTargetAudienceList() {
        return targetAudienceList;
    }

    public void setTargetAudienceList(List<TargetAudience> targetAudienceList) {
        this.targetAudienceList = targetAudienceList;
    }

    public List<BrandAttribute> getBrandAttributeList() {
        return brandAttributeList;
    }

    public void setBrandAttributeList(List<BrandAttribute> brandAttributeList) {
        this.brandAttributeList = brandAttributeList;
    }

    public List<Initiative> getInitiativeList() {
        return initiativeList;
    }

    public void setInitiativeList(List<Initiative> initiativeList) {
        this.initiativeList = initiativeList;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        InitiativeType that = (InitiativeType) o;
//        return id == that.id && sortingList == that.sortingList && deleted == that.deleted && Objects.equals(name, that.name) && Objects.equals(initiativeTypeFieldList, that.initiativeTypeFieldList) && Objects.equals(targetAudienceList, that.targetAudienceList) && Objects.equals(brandAttributeList, that.brandAttributeList) && Objects.equals(initiativeList, that.initiativeList);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, sortingList, name, deleted, initiativeTypeFieldList, targetAudienceList, brandAttributeList, initiativeList);
//    }
}
