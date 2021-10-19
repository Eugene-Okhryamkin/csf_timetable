package ru.vsu.cs.timetable.services.SubjectService;

import ru.vsu.cs.timetable.models.Subject;
import ru.vsu.cs.timetable.repositories.SubjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class SubjectService implements ISubjectService {

    @Inject
    private SubjectRepository subjectRepository;

    @Override
    public Subject getSubjectById(Long id) {
        return this.subjectRepository.findById(id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return this.subjectRepository.listAll();
    }

    @Override
    public Subject deleteSubjectById(Long id) {
        Subject subject = this.subjectRepository.findById(id);
        this.subjectRepository.deleteById(id);

        return subject;
    }

    @Override
    public void saveSubject(Subject subject) {
        this.subjectRepository.persist(subject);
    }
}
