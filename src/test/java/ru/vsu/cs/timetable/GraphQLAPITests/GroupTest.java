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
public class GroupTest extends GraphQLAPITest {

    public GroupTest() {
        super("localhost", 8888);
    }

    @Test
    @Order(1)
    public void saveGroupTest() {
        Map<String, Object> group = new HashMap<>();
        group.put("directionName", "\\\"Программная инженерия\\\"");
        group.put("course", 1);
        group.put("year", 2021);
        group.put("groupName", 5.1);

        List<String> keys = new ArrayList<>();
        keys.add("id");
        keys.add("groupName");

        this.saveEntityTest("saveGroup", group, "group", keys);

    }

    @Test
    @Order(2)
    public void getGroupsTest() {
        List<String> keys = new ArrayList<>();
        keys.add("directionName");
        keys.add("id");
        keys.add("course");
        keys.add("groupName");
        keys.add("year");

        this.getEntityTest("allGroups", keys);
    }
//
    @Test
    @Order(3)
    public void updateGroupTest() {
        Map<String, Object> mockGroup = new HashMap<>();
        mockGroup.put("id", 1);
        mockGroup.put("directionName", "\\\"Программная инженерия\\\"");
        mockGroup.put("course", 1);
        mockGroup.put("year", 2021);
        mockGroup.put("groupName", 6.1);

        List<String> keys = new ArrayList<>();
        keys.add("groupName");

        this.saveEntityTest("saveGroup", mockGroup, "group", keys);
    }

    @Test
    @Order(4)
    public void getGroupById() {
        List<String> keys = new ArrayList<>();
        keys.add("directionName");
        keys.add("id");
        keys.add("course");
        keys.add("groupName");
        keys.add("year");

        this.getEntityByParamTest("groupById", "id", 1, keys);
    }

    @Test
    @Order(5)
    public void deleteGroupTest() {
        List<String> keys = new ArrayList<>();
        keys.add("directionName");
        keys.add("id");
        keys.add("course");
        keys.add("groupName");
        keys.add("year");

        this.deleteEntityTest("deleteGroup", "id", 1, keys);
    }

}
