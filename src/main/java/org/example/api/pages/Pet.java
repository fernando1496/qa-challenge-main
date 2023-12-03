package org.example.api.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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

    public Response postNewPet(String jsonPayload){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post("v2/pet");
    }

    public Response putUpdatePet(String jsonPayload){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put("v2/pet");
    }

    public Response getPetById(String id){
        return RestAssured
                .given()
                .pathParam("id", id)
                .when()
                .get("v2/pet/{id}");
    }

    public Response deletePetById(String id){
        return RestAssured
                .given()
                .header("api_key", "special-key")
                .pathParam("id", id)
                .when()
                .delete("v2/pet/{id}");
    }
}
