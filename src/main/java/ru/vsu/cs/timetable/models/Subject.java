package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@ToString
public class Subject extends BaseModel {
    @Column(name = "subjectName")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


}
