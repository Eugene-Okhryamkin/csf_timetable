package ru.vsu.cs.timetable.services.TimetableService;

import ru.vsu.cs.timetable.models.Subject;
import ru.vsu.cs.timetable.models.Timetable;
import ru.vsu.cs.timetable.repositories.SubjectRepository;
import ru.vsu.cs.timetable.repositories.TimetableRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
@Transactional
public class TimetableService implements ITimetableService {

    @Inject
    private TimetableRepository timetableRepository;

    @Inject
    private SubjectRepository subjectRepository;


    @Override
    public Timetable getTimetableById(Long id) {
        return this.timetableRepository.findById(id);
    }

    @Override
    public List<Timetable> getTimetables() {
        return this.timetableRepository.listAll();
    }

    @Override
    public void saveTimetable(Timetable timetable) {
        this.timetableRepository.persist(timetable);
    }

    @Override
    public Timetable getTimetableByYear(int year) {
        return null;
    }

//    public List<Subject> getSubjectByTimetable(Long timetableId) {
//        this.subjectRepository.
//    }

    @Override
    public Timetable deleteTimetableById(Long id) {
        Timetable timetable = this.timetableRepository.findById(id);
        this.timetableRepository.deleteById(id);

        return timetable;
    }


}
