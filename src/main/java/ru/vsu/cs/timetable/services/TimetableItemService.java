package ru.vsu.cs.timetable.services;

import ru.vsu.cs.timetable.models.TimetableItem;
import ru.vsu.cs.timetable.repositories.TimetableItemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class TimetableItemService {

    private final TimetableItemRepository timetableItemRepository;

    public TimetableItemService(TimetableItemRepository timetableItemRepository) {
        this.timetableItemRepository = timetableItemRepository;
    }

    public List<TimetableItem> getAllTimetableItems() {
        return this.timetableItemRepository.listAll();
    }

    public List<TimetableItem> getAllTimetableItemsByTimetable(Long timetableId) {
        return this.timetableItemRepository.findTimetableItems(timetableId);
    }

    public void saveTimetableItem(TimetableItem timetableItem) {
        this.timetableItemRepository.persist(timetableItem);
    }

    public TimetableItem deleteTimetableItem(Long timetableItemId) {
        TimetableItem timetableItem = this.timetableItemRepository.findById(timetableItemId);
        this.timetableItemRepository.deleteById(timetableItemId);

        return timetableItem;
    }

}
