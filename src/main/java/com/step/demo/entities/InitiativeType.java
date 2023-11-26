package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

@Entity
@Table(name = "initiative_types")
@SQLDelete(sql = "UPDATE initiative_types SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedInitiativeTypesFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedInitiativeTypesFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allInitiativeTypesFilter", defaultCondition = "1=1")
@Filter(name = "allInitiativeTypesFilter", condition = "1=1")
public class InitiativeType {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "sorting_list")
    private int sortingList;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private boolean deleted;


}
