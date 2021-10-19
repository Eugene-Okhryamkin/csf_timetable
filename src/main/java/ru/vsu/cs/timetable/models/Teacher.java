package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
public class Teacher extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "vkLink")
    private String vkLink;

    @Column(name = "tgLink")
    private String tgLink;

    @Column(name = "isAdmin")
    private boolean isAdmin;
}
