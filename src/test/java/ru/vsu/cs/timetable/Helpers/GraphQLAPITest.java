package ru.vsu.cs.timetable.Helpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import ru.vsu.cs.timetable.Helpers.GraphQLAPIParser;
import ru.vsu.cs.timetable.models.Group;

import javax.crypto.Mac;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

//API for Test GraphQLAPI
public class GraphQLAPITest {
    private String host = "localhost";
    private int port = 80;
    private String URL = String.format("http://%s:%d", this.host, this.port);
    private String contentType = "application/json";

    //default
    public GraphQLAPITest(String host, int port) {
        this.host = host;
        this.port = port;
        this.URL = String.format("http://%s:%d/graphql", host, port);
    }

    public GraphQLAPITest(String URL) {
        this.URL = URL;
    }

    public void saveEntityTest(String mutationName, Map<String, Object> entityKeys, String graphqlInputType, List<String> returnedKeys) {
        final Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(GraphQLAPIParser.mutationTest(mutationName,graphqlInputType,entityKeys, returnedKeys))
                .when()
                .post("/graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .response();

        final Object object = response.jsonPath().get(String.format("data.%s", mutationName));
        System.out.println(object.toString());
        assert(object != null && GraphQLAPIParser.containsKey(object, returnedKeys));

    }

    public void getEntityTest(String queryName, List<String> returnedValues) {
        final Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(GraphQLAPIParser.queryTest(queryName, returnedValues))
                .when()
                .post("/graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .response();

        final List<LinkedHashMap<String, Object>> objects = response.jsonPath().getList(String.format("data.%s", queryName));
        assert(!objects.isEmpty() && GraphQLAPIParser.containsKey(objects, returnedValues));

    };

    public void getEntityByParamTest(String queryName, String param, Object paramValue ,List<String> returnedValues) {
        final Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(GraphQLAPIParser.queryTest(queryName, param, paramValue, returnedValues))
                .when()
                .post("/graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .response();

        final Object object = response.jsonPath().get(String.format("data.%s", queryName));
        assert(object != null && GraphQLAPIParser.containsKey(object, returnedValues));
    }

    public void deleteEntityTest(String mutationName, String param, Object paramValue, List<String> returnedValues) {
        final Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(GraphQLAPIParser.mutationDeleteTest(mutationName, param, paramValue, returnedValues))
                .when()
                .post("/graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .response();

        final Object object = response.jsonPath().get(String.format("data.%s", mutationName));
        assert(object != null && GraphQLAPIParser.containsKey(object, returnedValues));

    };
}
