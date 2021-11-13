package ru.vsu.cs.timetable.controllers;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import ru.vsu.cs.timetable.models.Timetable;
import ru.vsu.cs.timetable.services.TimetableService;

import java.sql.Time;
import java.util.List;

@GraphQLApi
public class TimetableController {

    private TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @Query
    public Timetable getTimetableById(Long id) {
        return this.timetableService.getTimetableById(id);
    }

    @Query
    public Timetable getTimetable(int year, int course, int week, int group) {
        return this.timetableService.getTimetable(year, course, week, group);
    }

    @Query
    public List<Timetable> getAllTimetables() {
        return this.timetableService.getTimetables();
    }

    @Mutation
    public Timetable saveTimetable(Timetable timetable) {
        this.timetableService.saveOrUpdateTimetable(timetable);

        return timetable;
    }


    @Mutation
    public Timetable deleteTimetable(Long id) {
        return this.timetableService.deleteTimetableById(id);
    }


}
