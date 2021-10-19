package ru.vsu.cs.timetable.services.SubjectService;

import ru.vsu.cs.timetable.models.Subject;

import java.util.List;

public interface ISubjectService {
    Subject getSubjectById(Long id);
    List<Subject> getAllSubjects();
    Subject deleteSubjectById(Long id);
    void saveSubject(Subject subject);
}
