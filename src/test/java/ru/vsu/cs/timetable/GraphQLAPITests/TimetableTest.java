package ru.vsu.cs.timetable.GraphQLAPITests;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.vsu.cs.timetable.Helpers.GraphQLAPITest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimetableTest extends GraphQLAPITest {

    private List<String> keys = new ArrayList<>();
    private Map<String, Object> timetable = new HashMap<>();


    public TimetableTest() {
        super("localhost", 8888);

        this.keys.add("id");
        this.keys.add("course");
        this.keys.add("week");
        this.keys.add("semester");

        this.timetable.put("course", 1);
        this.timetable.put("year", 2021);
        this.timetable.put("week", 1);
        this.timetable.put("semester", 1);
    }


    @Test
    @Order(1)
    public void saveTimetableTest() {
        this.saveEntityTest("saveTimetable", timetable, "timetable", this.keys);
    }

    @Test
    @Order(2)
    public void getTimetablesTest() {

        this.getEntityTest("allTimetables", this.keys);
    }

    @Test
    @Order(3)
    public void updateTimetableTest() {
        this.timetable.put("id", 1);

        this.saveEntityTest("saveTimetable", timetable, "timetable", this.keys);
    }

    @Test
    @Order(4)
    public void getTimetableById() {
        this.getEntityByParamTest("timetableById", "id", 1, this.keys);
    }

    @Test
    @Order(5)
    public void deleteTimetableById() {
        this.deleteEntityTest("deleteTimetable", "id", 1, this.keys);
    }
}
