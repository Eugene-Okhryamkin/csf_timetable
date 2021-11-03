package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "timetable")
@Getter
@Setter
@ToString
public class Timetable extends BaseModel {
    @Column(name = "year")
    private int year;

    @Column(name = "semester")
    private int semester;

    @Column(name = "week")
    private int week;

    @Column(name = "course")
    private int course;

    @OneToMany
    @JoinColumn(name = "timetableItems")
    private List<TimetableItem> timetableItems;

}
