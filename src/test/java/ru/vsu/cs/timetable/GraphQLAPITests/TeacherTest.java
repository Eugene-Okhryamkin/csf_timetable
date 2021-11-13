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
public class TeacherTest extends GraphQLAPITest {

    private List<String> keys = new ArrayList<>();
    private Map<String, Object> teacher = new HashMap<>();

    public TeacherTest() {
        super("localhost", 8888);

        this.keys.add("email");
        this.keys.add("middlename");
        this.keys.add("name");
        this.keys.add("surname");
        this.keys.add("password");
        this.keys.add("tgLink");
        this.keys.add("vkLink");
        this.keys.add("admin");
        this.keys.add("id");

        this.teacher.put("email", "\\\"teeacherEmail@example.com\\\"");
        this.teacher.put("middlename", "\\\"Иванович\\\"");
        this.teacher.put("name", "\\\"Иван\\\"");
        this.teacher.put("surname", "\\\"Иванов\\\"");
        this.teacher.put("password", "\\\"sdfsdfsdf\\\"");
        this.teacher.put("tgLink", "\\\"t.me/somenickname\\\"");
        this.teacher.put("vkLink", "\\\"vk.com/id0\\\"");
        this.teacher.put("admin", false);

    }


    @Test
    @Order(1)
    public void saveTeacherTest() {
        this.saveEntityTest("saveTeacher", this.teacher, "teacher", this.keys);
    }

    @Test
    @Order(2)
    public void getTeachersTest() {
        this.getEntityTest("allTeachers", this.keys);
    }

    @Test
    @Order(3)
    public void updateTeachersTest() {
        this.teacher.put("id", 1);
        Object password = this.teacher.get("password");

        password = "454353245325";

        this.saveEntityTest("saveTeacher", this.teacher, "teacher", this.keys);
    }

    @Test
    @Order(4)
    public void getTeacherById() {
        this.getEntityByParamTest("teacher", "id", 1, this.keys);
    }

    @Test
    @Order(5)
    public void deleteTeacher() {
        this.deleteEntityTest("deleteTeacher", "id", 1, this.keys);
    }
}
