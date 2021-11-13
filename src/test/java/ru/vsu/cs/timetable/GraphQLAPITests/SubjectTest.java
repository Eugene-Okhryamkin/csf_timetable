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
public class SubjectTest extends GraphQLAPITest {

    private List<String> keys = new ArrayList<>();
    private Map<String, Object> subject = new HashMap<>();

    public SubjectTest() {
        super("localhost", 8888);

        this.keys.add("subjectName");
        this.keys.add("id");

        this.subject.put("subjectName", "\\\"ООП\\\"");

    }


    @Test
    @Order(1)
    public void saveTimetableTest() {
        this.saveEntityTest("saveSubject", subject, "subject", this.keys);
    }

    @Test
    @Order(2)
    public void getTimetablesTest() {

        this.getEntityTest("allSubjects", this.keys);
    }

    @Test
    @Order(3)
    public void updateTimetableTest() {
        this.subject.put("id", 1);

        this.saveEntityTest("saveSubject", this.subject, "subject", this.keys);
    }

    @Test
    @Order(4)
    public void getTimetableById() {
        this.getEntityByParamTest("subjectById", "id", 1, this.keys);
    }

    @Test
    @Order(5)
    public void deleteTimetableById() {
        this.deleteEntityTest("deleteSubject", "id", 1, this.keys);
    }
}
