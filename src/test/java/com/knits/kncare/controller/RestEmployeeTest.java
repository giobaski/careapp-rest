package com.knits.kncare.controller;

import com.knits.kncare.dto.pages.EmployeeDtoPage;
import com.knits.kncare.dto.search.EmployeeSearchDto;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestEmployeeTest {


    private final EmployeeSearchDto employeeSearchDto = new EmployeeSearchDto();
    private final String emsSearchUrl = "http://localhost:9000/employees/search";

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        assertNotNull(restTemplate);
    }

    @Test
    public void test_postForEntity() {
        ResponseEntity<EmployeeDtoPage> entity = restTemplate.postForEntity(emsSearchUrl, employeeSearchDto, EmployeeDtoPage.class);

        assertNotNull(entity);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertNotNull(entity.getBody());
    }

    @Test
    public void test_postForObject() {
        EmployeeDtoPage employeeDtoPage = restTemplate.postForObject(emsSearchUrl, employeeSearchDto, EmployeeDtoPage.class);

        assertNotNull(employeeDtoPage);
        assertNotNull(employeeDtoPage.getContent());
    }




//    @Test
//    public void givenUrl_whenSuccessOnPostResponse_thenCorrect() {
//
//        String requestBody = "{\n" +
//                "  \"title\": \"manager\"";
//
//        Response response = given()
//                .header("Content-type", "application/json")
//                .and()
//                .body(requestBody)
//                .when()
//                .post("/api/v1/employees")
//                .then()
//                .extract().response();
//
//        response.then().statusCode(200).assertThat().body("title",
//                equalTo("manager"));
//    }
}