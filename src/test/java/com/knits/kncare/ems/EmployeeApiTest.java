package com.knits.kncare.ems;

import com.google.common.net.HttpHeaders;
import com.knits.kncare.controller.EmployeeController;
import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.EmployeePage;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import com.knits.kncare.service.EmployeeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class EmployeeApiTest {

    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:9000";
        port = 8080;
    }

    @Test
    public void givenEmployeeExists_whenEmployeeInfoIsRetrieved_then200IsReceived()
            throws ClientProtocolException, IOException {

        // Given
        HttpUriRequest request = new HttpGet( baseURI+ "/employees" );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }
}
