package com.step.demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Attribute implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(20) default #FFFFFF")
    private String backGroundColor;
    @Column(nullable = false)
    private Double score;
    @Column(nullable = false)
    private Boolean isCanDecrease;
    @Column
    private Double speedOfDecrease;
    @Column
    private Double maxReachedValue;
    @OneToMany(targetEntity = EventType.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EventType> eventTypes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "attribute_user_id_fk_key"),
            insertable = false,
            updatable = false
    )
    private User user;
    @Column(name = "user_id")
    private Long userId;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(String backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getIsCanDecrease() {
        return isCanDecrease;
    }

    public void setIsCanDecrease(Boolean canDecrease) {
        this.isCanDecrease = canDecrease;
    }

    public Double getSpeedOfDecrease() {
        return speedOfDecrease;
    }

    public void setSpeedOfDecrease(Double speedOfDecrease) {
        this.speedOfDecrease = speedOfDecrease;
    }

    public Double getMaxReachedValue() {
        return maxReachedValue;
    }

    public void setMaxReachedValue(Double maxReachedValue) {
        this.maxReachedValue = maxReachedValue;
    }

    public Attribute() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return  Objects.equals(getName(), attribute.getName()) && Objects.equals(getUserId(), attribute.getUserId()) && Objects.equals(getBackGroundColor(), attribute.getBackGroundColor()) && Objects.equals(getScore(), attribute.getScore()) && Objects.equals(getIsCanDecrease(), attribute.getIsCanDecrease()) && Objects.equals(getSpeedOfDecrease(), attribute.getSpeedOfDecrease()) && Objects.equals(getMaxReachedValue(), attribute.getMaxReachedValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUserId(), getBackGroundColor(), getScore(), getIsCanDecrease(), getSpeedOfDecrease(), getMaxReachedValue());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
