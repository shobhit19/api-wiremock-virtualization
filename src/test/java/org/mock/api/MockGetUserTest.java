package org.mock.api;

import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class MockGetUserTest {


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
    public void mockUserAPITest(){
        APIMocks.getDummyUser();

        RestAssured.given()
                .get("/api/users")
                .then().log().all()
                .statusCode(200)
                .body("name",equalTo("shobhit"));


    }
}
