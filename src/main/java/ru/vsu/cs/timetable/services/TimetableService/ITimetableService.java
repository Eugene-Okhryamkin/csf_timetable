package ru.vsu.cs.timetable.services.TimetableService;

import ru.vsu.cs.timetable.models.Timetable;

import java.util.List;

public interface ITimetableService {
    Timetable getTimetableById(Long id);
    List<Timetable> getTimetables();
    void saveTimetable(Timetable timetable);
    Timetable deleteTimetableById(Long id);
    Timetable getTimetableByYear(int year);
}
