package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.FetchProfile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "initiative_comments")
public class InitiativeComment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_role")
    private String userRole;

    @OneToOne(fetch = FetchType.LAZY)
    private Initiative initiative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "user_id_fk")
    )
    private User user;

    @CreatedDate
    @Column(name = "create_date")
    private Date createDate;

    @LastModifiedDate
    @Column(name = "updateDate")
    private Date updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InitiativeComment that = (InitiativeComment) o;
        return Objects.equals(id, that.id) && Objects.equals(userRole, that.userRole) && Objects.equals(initiative, that.initiative) && Objects.equals(user, that.user) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userRole, initiative, user, createDate, updateDate);
    }
}
