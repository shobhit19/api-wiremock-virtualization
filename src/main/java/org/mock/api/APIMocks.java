package org.mock.api;


import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class APIMocks {

    public static void getDummyUser(){

        stubFor(get(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type","application/json")
                        .withBody("{\n" +
                                "\"name\":\"shobhit\"\n" +
                                "}")));
    }

    public static void getDummyUserWithQueryParams(){

        stubFor(get(urlEqualTo("/api/customers"))
                .withQueryParam("param",equalTo("value"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type","application/json")
                        .withBody("{\n" +
                                "\"name\":\"shobhit query param\"\n" +
                                "}")));
    }

    public static void createDummyUser(){
        stubFor(post(urlEqualTo("/api/users"))
                .withHeader("Content-Type", WireMock.equalTo("application/json"))
                .withRequestBody(equalToJson("{\n" +
                        "\"name\":\"shobhit\"\n" +
                        "}"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type","application/json")
                .withBody("{\n" +
                        "\"message\":\"user is created\"\n" +
                        "}")));
    }
}
