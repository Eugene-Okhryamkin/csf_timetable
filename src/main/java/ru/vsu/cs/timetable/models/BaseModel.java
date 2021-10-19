package ru.vsu.cs.timetable.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.microprofile.graphql.Name;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
