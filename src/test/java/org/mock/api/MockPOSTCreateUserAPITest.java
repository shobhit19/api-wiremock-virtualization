package org.mock.api;

import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class MockPOSTCreateUserAPITest {


    @BeforeTest
    public void setUp(){
        WireMockSetup.createWireMockServer();
        RestAssured.baseURI="http://localHost";
        RestAssured.port = 8089;
    }

    @AfterTest
    public void tearDown(){
        WireMockSetup.stopWireMockServer();
    }

    @Test
    public void createUserDummyTest(){
        APIMocks.createDummyUser();

        RestAssured.given().log().all()
                .contentType("application/json")
                .body("{\n" +
                        "\"name\":\"shobhit\"\n" +
                        "}")
                .when()
                .post("/api/users")
                .then()
                .assertThat().statusCode(201)
                .body("message",equalTo("user is created"));

    }
}

