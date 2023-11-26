package com.step.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "brand_attribute_answers")
public class BrandAttributeAnswer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_id",
            foreignKey = @ForeignKey(name = "initiative_id_fk")
    )
    private Initiative initiative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_attribute_question_id",
            foreignKey = @ForeignKey(name = "brand_attribute_question_id_fk")
    )
    private BrandAttributeQuestion question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandAttributeAnswer that = (BrandAttributeAnswer) o;
        return Objects.equals(id, that.id) && Objects.equals(initiative, that.initiative) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initiative, question);
    }
}
