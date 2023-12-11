package com.step.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "initiatives_target_audiences")
public class TargetAudienceInitiative implements BaseEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "target_audience_id",
            foreignKey = @ForeignKey(name = "target_audience_fk")
    )
    private TargetAudience targetAudience;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_id",
            foreignKey = @ForeignKey(name = "initiative_id_fk")
    )
    private Initiative initiative;

    @Column(name = "comment")
    private String comment;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TargetAudienceInitiative that = (TargetAudienceInitiative) o;
//        return Objects.equals(targetAudience, that.targetAudience) && Objects.equals(initiative, that.initiative) && Objects.equals(comment, that.comment);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(targetAudience, initiative, comment);
//    }
}
