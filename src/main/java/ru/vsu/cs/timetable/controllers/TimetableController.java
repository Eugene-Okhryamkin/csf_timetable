package ru.vsu.cs.timetable.controllers;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import ru.vsu.cs.timetable.models.Timetable;
import ru.vsu.cs.timetable.services.GroupService.GroupService;
import ru.vsu.cs.timetable.services.TimetableService.TimetableService;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class TimetableController {

    @Inject
    private TimetableService timetableService;

    @Inject
    private GroupService groupService;

    @Query
    public Timetable getTimetableById(Long id) {
        return this.timetableService.getTimetableById(id);
    }

    public Timetable getTimetableByYear(int year) {
        return this.timetableService.getTimetableByYear(year);
    }

    @Query
    public List<Timetable> getAllTimetables() {
        return this.timetableService.getTimetables();
    }

    @Mutation
    public Timetable saveTimetable(Timetable timetable) {
        this.timetableService.saveTimetable(timetable);

        return timetable;
    }

    @Mutation
    public Timetable deleteTimetable(Long id) {
        return this.timetableService.deleteTimetableById(id);
    }


}
