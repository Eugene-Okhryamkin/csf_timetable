package ru.vsu.cs.timetable.services;

import ru.vsu.cs.timetable.models.Subject;
import ru.vsu.cs.timetable.repositories.SubjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject getSubjectById(Long id) {
        return this.subjectRepository.findById(id);
    }

    public List<Subject> getAllSubjects() {
        return this.subjectRepository.listAll();
    }

    public Subject deleteSubjectById(Long id) {
        Subject subject = this.subjectRepository.findById(id);
        this.subjectRepository.deleteById(id);

        return subject;
    }

    public void saveSubject(Subject subject) {
        this.subjectRepository.persist(subject);
    }
}
