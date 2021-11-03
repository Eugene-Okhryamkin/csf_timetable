package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "timetableItem")
@Getter
@Setter
@ToString
public class TimetableItem extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "lesson_order")
    private int lessonOrder;

    @Column(name = "time_interval")
    private String timeInterval;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @CollectionTable(
            name = "timetable",
            joinColumns = @JoinColumn(name = "id")
    )
    private Long timetableId;
}
