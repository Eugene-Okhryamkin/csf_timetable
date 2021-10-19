package ru.vsu.cs.timetable.services.GroupService;

import ru.vsu.cs.timetable.models.Group;

import java.util.List;

public interface IGroupService {
    Group getGroupById(Long id);
    List<Group> getGroups();
    void saveGroup(Group group);
    Group deleteGroupById(Long id);
    List<Group> getAllGroupsByYear(int year);
}
