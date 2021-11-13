package ru.vsu.cs.timetable.controllers;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import ru.vsu.cs.timetable.models.Subject;
import ru.vsu.cs.timetable.services.SubjectService;

import java.util.List;

@GraphQLApi
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Query
    public Subject getSubjectById(Long id) {
        return this.subjectService.getSubjectById(id);
    }

    @Query
    public List<Subject> getAllSubjects() {
        return this.subjectService.getAllSubjects();
    }

    @Mutation
    public Subject saveSubject(Subject subject) {
        this.subjectService.saveOrUpdateSubject(subject);

        return subject;
    }


    @Mutation
    public Subject deleteSubject(Long id) {
        return this.subjectService.deleteSubjectById(id);
    }

}
