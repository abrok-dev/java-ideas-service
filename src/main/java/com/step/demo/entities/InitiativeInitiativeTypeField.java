package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.FetchProfile;

import java.util.Objects;

@Entity
@Table(name = "initiatives_initiative_type_fields")
public class InitiativeInitiativeTypeField implements BaseEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_id",
            foreignKey = @ForeignKey(name = "initiative_id_fk")
    )
    private Initiative initiative;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_type_field_id",
            foreignKey = @ForeignKey(name = "initiative_type_field_id_fk")
    )
    private InitiativeTypeField initiativeTypeField;

    @Column(name = "value")
    private String value;

    public Initiative getInitiative() {
        return initiative;
    }

    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }

    public InitiativeTypeField getInitiativeTypeField() {
        return initiativeTypeField;
    }

    public void setInitiativeTypeField(InitiativeTypeField initiativeTypeField) {
        this.initiativeTypeField = initiativeTypeField;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        InitiativeInitiativeTypeField that = (InitiativeInitiativeTypeField) o;
//        return Objects.equals(initiative, that.initiative) && Objects.equals(initiativeTypeField, that.initiativeTypeField) && Objects.equals(value, that.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(initiative, initiativeTypeField, value);
//    }
}
