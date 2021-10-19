package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
@Getter
@Setter
@ToString
public class Timetable extends BaseModel {
    @Column(name = "year")
    private int year;

    @Column(name = "course")
    private int course;

    @Column(name = "semester")
    private int semester;

    @Column(name = "week")
    private int week;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
