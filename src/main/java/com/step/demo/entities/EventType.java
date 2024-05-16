package com.step.demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class EventType implements BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Double increaseValue;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "attribute_id",
            foreignKey = @ForeignKey(name = "attribute_id_event_type_fk"),
            updatable = false,
            insertable = false
    )
    private Attribute attribute;
    @Column(name = "attribute_id")
    private Long attributeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "event_type_user_fk_id"),
            insertable = false,
            updatable = false
    )
    private User user;
    @Column(name = "user_id")
    private Long userId;
    @OneToMany(targetEntity = Event.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncreaseValue() {
        return increaseValue;
    }

    public void setIncreaseValue(Double increaseValue) {
        this.increaseValue = increaseValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventType eventType = (EventType) o;
        return Objects.equals(getName(), eventType.getName()) && Objects.equals(getAttributeId(), eventType.getAttributeId()) && Objects.equals(getUserId(), eventType.getUserId()) && Objects.equals(getIncreaseValue(), eventType.getIncreaseValue()) && Objects.equals(getAttribute(), eventType.getAttribute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIncreaseValue(), getAttribute(), getUserId());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }
}
