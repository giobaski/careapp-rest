package com.knits.kncare.ems;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

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
