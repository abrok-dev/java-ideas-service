package com.step.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "initiative_type_fields")
@SQLDelete(sql = "UPDATE initiative_type_fields SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedInitiativeTypeFieldsFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedInitiativeTypeFieldsFilter", condition = "deleted = :isDeleted")
@FilterDef(name = "allInitiativeTypeFieldsFilter", defaultCondition = "1=1")
@Filter(name = "allInitiativeTypeFieldsFilter", condition = "1=1")
public class InitiativeTypeField {
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

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean isDeleted;
}
