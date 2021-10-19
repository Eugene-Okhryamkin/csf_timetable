package ru.vsu.cs.timetable.services.GroupService;

import ru.vsu.cs.timetable.models.Group;
import ru.vsu.cs.timetable.repositories.GroupRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class GroupService implements IGroupService {

    @Inject
    private GroupRepository groupRepository;

    @Override
    public Group getGroupById(Long id) {
        return this.groupRepository.findById(id);
    }

    @Override
    public List<Group> getAllGroupsByYear(int year) {
        return this.groupRepository.findAllGroupsByYear(year);
    }

    @Override
    public List<Group> getGroups() {
        return this.groupRepository.listAll();
    }

    @Override
    public void saveGroup(Group group) {
        this.groupRepository.persist(group);
    }

    @Override
    public Group deleteGroupById(Long id) {
        Group group = this.groupRepository.findById(id);
        this.groupRepository.deleteById(id);

        return group;
    }


}
