package com.step.demo.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "target_audience")
@EntityListeners(AuditingEntityListener.class)
public class TargetAudience implements BaseEntity {

    @Id
    private Long id;

    @Column(name = "sorting_list")
    private Integer sortingList;

    @Column(name = "name")
    private String name;

    @Column(name = "hint")
    private String hint;

    @CreatedDate
    private Date createDate;

    @OneToMany(targetEntity = TargetAudienceInitiative.class, fetch = FetchType.LAZY)
    private List<TargetAudienceInitiative> targetAudienceInitiative;

    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public Integer getSortingList() {
        return sortingList;
    }

    public void setSortingList(Integer sortingList) {
        this.sortingList = sortingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<TargetAudienceInitiative> getTargetAudienceInitiative() {
        return targetAudienceInitiative;
    }

    public void setTargetAudienceInitiative(List<TargetAudienceInitiative> targetAudienceInitiative) {
        this.targetAudienceInitiative = targetAudienceInitiative;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetAudience that = (TargetAudience) o;
        return isDeleted() == that.isDeleted() && Objects.equals(getSortingList(), that.getSortingList())
                && Objects.equals(getName(), that.getName()) && Objects.equals(getHint(), that.getHint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSortingList(), getName(), getHint(), isDeleted());
    }
}
