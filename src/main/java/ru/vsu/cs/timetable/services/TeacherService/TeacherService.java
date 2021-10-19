package ru.vsu.cs.timetable.services.TeacherService;

import ru.vsu.cs.timetable.models.Teacher;
import ru.vsu.cs.timetable.repositories.TeacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class TeacherService implements ITeacherService {

    @Inject
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacherById(Long id) {
        return this.teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.listAll();
    }



    @Override
    public void saveTeacher(Teacher teacher) {
        this.teacherRepository.persist(teacher);
    }

    @Override
    public Teacher deleteTeacherById(Long id) {
        Teacher teacher = this.teacherRepository.findById(id);
        this.teacherRepository.deleteById(id);

        return teacher;
    }
}
