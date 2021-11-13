package ru.vsu.cs.timetable.services;

import ru.vsu.cs.timetable.models.Group;
import ru.vsu.cs.timetable.models.Subject;
import ru.vsu.cs.timetable.models.Timetable;
import ru.vsu.cs.timetable.repositories.GroupRepository;
import ru.vsu.cs.timetable.repositories.SubjectRepository;
import ru.vsu.cs.timetable.repositories.TimetableRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;


@ApplicationScoped
@Transactional
public class TimetableService {

    private TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public Timetable getTimetableById(Long id) {
        return this.timetableRepository.findById(id);
    }

    public List<Timetable> getTimetables() {
        return this.timetableRepository.listAll();
    }

    public void saveOrUpdateTimetable(Timetable timetable) {
        if(timetable.getId() == null) {
            this.timetableRepository.persist(timetable);
        } else {
            this.timetableRepository.updateTimetable(timetable);
        }
    }


    public Timetable getTimetable(int year, int course, int week, int group) {
        return this.timetableRepository.findByParams(year, course, week, group);
    }

    public Timetable deleteTimetableById(Long id) {
        Timetable timetable = this.timetableRepository.findById(id);
        this.timetableRepository.deleteById(id);

        return timetable;
    }


}
