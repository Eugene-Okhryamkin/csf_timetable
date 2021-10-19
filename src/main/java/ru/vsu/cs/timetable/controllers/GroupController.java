package ru.vsu.cs.timetable.controllers;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import ru.vsu.cs.timetable.models.Group;
import ru.vsu.cs.timetable.services.GroupService.GroupService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@GraphQLApi
public class GroupController {

    @Inject
    private GroupService groupService;

    @Query
    public List<Group> getAllGroups() {
        return this.groupService.getGroups();
    }

    @Query
    public Group getGroupById(Long id) {
        return this.groupService.getGroupById(id);
    }

    @Mutation
    public Group saveGroup(Group group) {
        this.groupService.saveGroup(group);
        return group;
    }

    @Mutation
    public Group deleteGroup(Long id) {
        return this.groupService.deleteGroupById(id);
    }
}
