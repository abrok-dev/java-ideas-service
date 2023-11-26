package com.step.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "target_audience")

public class TargetAudience {

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

    @LastModifiedDate
    private Date updateDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;
}
