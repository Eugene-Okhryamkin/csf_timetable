package ru.vsu.cs.timetable.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ru.vsu.cs.timetable.models.Timetable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimetableRepository implements PanacheRepository<Timetable> {
    public Timetable findTimetableByYear(int year) {
        return find("year", year).firstResult();
    }
}
