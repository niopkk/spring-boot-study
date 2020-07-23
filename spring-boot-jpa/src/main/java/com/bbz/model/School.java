package com.bbz.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "school")
public class School {
    @Id
    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "school_name")
    private String schoolName;
}
