package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.FetchProfile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "initiative_comments")
public class InitiativeComment implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_role")
    private String userRole;
    @Column(name = "text", length = 500)
    private String text;

    @ManyToOne(targetEntity = Initiative.class, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "initiative_id",
            foreignKey = @ForeignKey(name = "initiative_id_fk")
    )
    private Initiative initiative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "user_id_fk")
    )
    private User user;

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Initiative getInitiative() {
        return initiative;
    }

    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        InitiativeComment that = (InitiativeComment) o;
//        return Objects.equals(id, that.id) && Objects.equals(userRole, that.userRole) && Objects.equals(initiative, that.initiative) && Objects.equals(user, that.user) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, userRole, initiative, user, createDate, updateDate);
//    }
}
