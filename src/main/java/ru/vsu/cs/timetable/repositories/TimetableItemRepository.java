package ru.vsu.cs.timetable.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ru.vsu.cs.timetable.models.TimetableItem;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TimetableItemRepository implements PanacheRepository<TimetableItem> {
    public List<TimetableItem> findTimetableItems(Long timetableId) {
        return this.list("timetableid", timetableId);
    }
}
