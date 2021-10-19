package ru.vsu.cs.timetable.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ru.vsu.cs.timetable.models.Teacher;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeacherRepository implements PanacheRepository<Teacher> {

}