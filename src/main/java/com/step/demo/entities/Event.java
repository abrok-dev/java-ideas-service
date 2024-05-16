package com.step.demo.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    @Column(updatable = false)
    private Date eventDate;
    @Column
    private String comment;
    @ManyToOne
    @JoinColumn(
            name = "event_type_id",
            foreignKey = @ForeignKey(name = "event_type_event_fk_key"),
            nullable = false,
            updatable = false
    )
    private EventType eventType;
    private Long eventTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Event() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(getEventDate(), event.getEventDate()) && Objects.equals(getComment(), event.getComment()) && Objects.equals(eventType, event.eventType) && Objects.equals(getEventTypeId(), event.getEventTypeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventDate(), getComment(), eventType, getEventTypeId());
    }
}
