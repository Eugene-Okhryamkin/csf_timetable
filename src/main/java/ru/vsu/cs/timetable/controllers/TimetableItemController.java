package ru.vsu.cs.timetable.controllers;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import ru.vsu.cs.timetable.models.TimetableItem;
import ru.vsu.cs.timetable.services.TimetableItemService;

import java.util.List;

@GraphQLApi
public class TimetableItemController {

    private TimetableItemService timetableItemService;

    public TimetableItemController(TimetableItemService timetableItemService) {
        this.timetableItemService = timetableItemService;
    }

    @Query
    public List<TimetableItem> getAllTimetableItems() {
        return this.timetableItemService.getAllTimetableItems();
    }

    @Query
    public List<TimetableItem> getTimetableItemsByTimetable(Long timetableId) {
        return this.timetableItemService.getAllTimetableItemsByTimetable(timetableId);
    }

    @Mutation
    public TimetableItem saveTimetableItem(TimetableItem timetableItem) {
        this.timetableItemService.saveTimetableItem(timetableItem);

        return timetableItem;
    }

    @Mutation
    public TimetableItem deleteTimetableItem(Long timetableItemId) {
        return this.timetableItemService.deleteTimetableItem(timetableItemId);
    }


}
