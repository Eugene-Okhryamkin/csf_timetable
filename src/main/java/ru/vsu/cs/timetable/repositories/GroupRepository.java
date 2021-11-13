package ru.vsu.cs.timetable.repositories;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import ru.vsu.cs.timetable.models.Group;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {
    public List<Group> findAllGroupsByYear(int year) {
        return list("year", year);
    }
    public Group updateGroup(Group group) {
        return this.getEntityManager().merge(group);
    }
}
