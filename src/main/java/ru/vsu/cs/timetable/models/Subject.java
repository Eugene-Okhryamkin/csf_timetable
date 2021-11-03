package ru.vsu.cs.timetable.models;

import io.smallrye.graphql.api.Scalar;
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

}
