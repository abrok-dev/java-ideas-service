package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Entity
@Table(name = "brand_attribute_answers")
public class BrandAttributeAnswer implements BaseEntity {

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

    public Initiative getInitiative() {
        return initiative;
    }

    @Column(name = "answer")
    private Boolean answer;

    @Column(name = "comment")
    private String comment;

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }

    public BrandAttributeQuestion getQuestion() {
        return question;
    }

    public void setQuestion(BrandAttributeQuestion question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BrandAttributeAnswer that = (BrandAttributeAnswer) o;
//        if (initiative == null || that.initiative == null || question == null || that.question == null) {
//            return false;
//        }
//        return  Objects.equals(initiative.getId(), that.initiative.getId()) && Objects.equals(question, that.question);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(answer, comment);
//    }
}
