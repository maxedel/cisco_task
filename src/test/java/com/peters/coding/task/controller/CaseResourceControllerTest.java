package com.peters.coding.task.controller;

import com.peters.coding.task.CiscoTaskApplication;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CiscoTaskApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles({"integration"})
class CaseResourceControllerTest {

    @Value("${local.server.port}")
    private int ports;

    @BeforeAll
    public void setUp() {
        port = ports;
        baseURI = "http://localhost";
    }

    @Test
    public void get_CaseById_returnsCase_200() {

        ValidatableResponse response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/case/1")
                .then();

        System.out.println("'get_CaseById_returnsCase_200()' response:\n" + response.extract().asString());

        response.assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("content.size()", greaterThan(1));
    }


}