package com.step.demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "initiative_statuses")
public class InitiativeStatus implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    public static final Long DRAFT = 1L;
    public static final Long WAITING = 2L;
    public static final Long WORKING = 3L;
    public static final Long REWORKING = 4L;
    public static final Long CONFIRMED = 5L;
    public static final Long CANCELED = 6L;

    @Column(name = "name")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToMany(targetEntity = Initiative.class, mappedBy = "initiativeStatus", fetch = FetchType.LAZY)
//    @JoinColumn(name = "initiative_status_id", foreignKey = @ForeignKey(name = "initiative_status_id_fk"))
    private List<Initiative> initiativeList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InitiativeStatus that = (InitiativeStatus) o;
        return Objects.equals(name, that.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Initiative> getInitiativeList() {
        return initiativeList;
    }

    public void setInitiativeList(List<Initiative> initiativeList) {
        this.initiativeList = initiativeList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
