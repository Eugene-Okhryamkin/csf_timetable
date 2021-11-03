package ru.vsu.cs.timetable.services;

import ru.vsu.cs.timetable.models.Group;
import ru.vsu.cs.timetable.repositories.GroupRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group getGroupById(Long id) {
        return this.groupRepository.findById(id);
    }

    public List<Group> getAllGroupsByYear(int year) {
        return this.groupRepository.findAllGroupsByYear(year);
    }

    public List<Group> getGroups() {
        return this.groupRepository.listAll();
    }

    public void saveGroup(Group group) {
        this.groupRepository.persist(group);
    }

    public Group deleteGroupById(Long id) {
        Group group = this.groupRepository.findById(id);
        this.groupRepository.deleteById(id);

        return group;
    }


}
