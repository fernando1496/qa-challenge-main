package org.example.api.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class Pet {

    public Response getPetByStatus(String status){
        return RestAssured
                .given()
                .queryParam("status", status)
                .when()
                 .get("v2/pet/findByStatus");
    }
}
