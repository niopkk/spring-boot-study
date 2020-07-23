package com.bbz.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String password;


    private int gender;//性别

    private int age;

    //    @JoinColumn(name = "school", referencedColumnName = "school_id")
    @ManyToOne
    @JoinColumn(name = "school")
    private School school;
    @ManyToOne
    @JoinColumn(name = "grade")
    private Grade grade;
}
