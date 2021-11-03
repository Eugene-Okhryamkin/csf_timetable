package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
public class Group extends BaseModel {
    @Column(name = "course")
    private int course;

    @Column(name = "groupname")
    private float groupName;

    @Column(name = "directionname")
    private String directionName;

    @Column(name = "year")
    private int year;
}
