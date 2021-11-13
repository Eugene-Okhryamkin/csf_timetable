package ru.vsu.cs.timetable.controllers;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import ru.vsu.cs.timetable.models.Teacher;
import ru.vsu.cs.timetable.services.TeacherService;

import java.util.List;

@GraphQLApi
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Query
    public Teacher getTeacher(Long id) {
        return this.teacherService.getTeacherById(id);
    }

    @Query
    public List<Teacher> getAllTeachers() {
        return this.teacherService.getAllTeachers();
    }

    @Mutation
    public Teacher saveTeacher(Teacher teacher) {
        this.teacherService.saveOrUpdateTeacher(teacher);

        return teacher;
    }

    @Mutation
    public Teacher deleteTeacher(Long id) {
        return this.teacherService.deleteTeacherById(id);
    }

}
