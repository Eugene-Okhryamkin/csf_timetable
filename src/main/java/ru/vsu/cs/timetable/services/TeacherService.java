package ru.vsu.cs.timetable.services;

import ru.vsu.cs.timetable.models.Group;
import ru.vsu.cs.timetable.models.Teacher;
import ru.vsu.cs.timetable.repositories.TeacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
@Transactional
public class TeacherService  {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherById(Long id) {
        return this.teacherRepository.findById(id);
    }

    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.listAll();
    }

    public void saveOrUpdateTeacher(Teacher teacher) {
        if(teacher.getId() == null) {
            this.teacherRepository.persist(teacher);
        } else {
            this.teacherRepository.updateTeacher(teacher);
        }
    }


    public Teacher deleteTeacherById(Long id) {
        Teacher teacher = this.teacherRepository.findById(id);
        this.teacherRepository.deleteById(id);

        return teacher;
    }
}
