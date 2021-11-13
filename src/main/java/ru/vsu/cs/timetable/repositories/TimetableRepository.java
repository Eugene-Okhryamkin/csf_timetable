package ru.vsu.cs.timetable.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import ru.vsu.cs.timetable.models.Group;
import ru.vsu.cs.timetable.models.Timetable;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TimetableRepository implements PanacheRepository<Timetable> {
    public Timetable findByParams(int year, int course, int week, int group) {
        return find("year = ?1 and course = ?2 and week = ?3 and group = ?4", year, course, week, group).firstResult();
    }
    public Timetable updateTimetable(Timetable timetable) {
        return this.getEntityManager().merge(timetable);
    }
}
