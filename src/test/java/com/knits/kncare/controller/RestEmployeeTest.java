package com.knits.kncare.controller;

import com.knits.kncare.dto.EmployeePage;
import com.knits.kncare.service.EmployeeService;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestEmployeeTest {


    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:8080";
        port = 8080;
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponse_thenCorrect() {
        get("/api/v1/employees").then().statusCode(200)
                .assertThat().body("size()", greaterThan(0));
    }


    @Test
    public void givenUrl_whenSuccessOnPostResponse_thenCorrect() {

        String requestBody = "{\n" +
                "  \"title\": \"manager\"";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/v1/employees")
                .then()
                .extract().response();

        response.then().statusCode(200).assertThat().body("title",
                equalTo("manager"));
    }
}