package ru.vsu.cs.timetable.services.TeacherService;

import ru.vsu.cs.timetable.models.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher getTeacherById(Long id);
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);
    Teacher deleteTeacherById(Long id);
}
