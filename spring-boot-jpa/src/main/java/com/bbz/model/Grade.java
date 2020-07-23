package com.bbz.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "grade")
public class Grade {

    @Id
    @Column(name = "grade_id")
    private int gradeId;

    @Column(name = "grade_name")
    private String gradeName;

    @ManyToOne
    @JoinColumn(name = "school")
    private School school;

}
