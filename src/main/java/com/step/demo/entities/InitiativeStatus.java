package com.step.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "initiative_statuses")
public class InitiativeStatus {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InitiativeStatus that = (InitiativeStatus) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }
}
