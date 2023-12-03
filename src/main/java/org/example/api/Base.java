package org.example.api;

import io.qameta.allure.Description;
import org.example.api.pages.Pet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;

public class Base {


    protected Pet pet;
    @Description("Base configuration for Api Tests.")
    @BeforeMethod
    public void beforeEveryMethod(){
        pet = new Pet();
        RestAssured.baseURI = "https://petstore.swagger.io/";
}

    @Description("Data clean up activities.")
    @AfterMethod
    public void afterEveryClass() {
    }



}