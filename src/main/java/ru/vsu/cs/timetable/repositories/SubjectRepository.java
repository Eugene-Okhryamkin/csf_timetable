package ru.vsu.cs.timetable.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ru.vsu.cs.timetable.models.Subject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SubjectRepository implements PanacheRepository<Subject> {
}
