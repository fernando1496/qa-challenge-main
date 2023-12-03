package org.example.api;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.ui.listeners.TestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.hasKey;

@Listeners({ TestExecutionListener.class })
@Epic("Regression Tests")
@Feature("Pets")
public class PetTests extends Base{
    String curentDir;
    @BeforeClass
    public void beforeClass(){
        curentDir = System.getProperty("user.dir");
    }

    @Test(description = "Verify pet results by status.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Pet")
    @Description("This endpoints return a list of pets filtered by status")
    public void testFindPetByStatus() throws IOException {
        Response response = pet.getPetByStatus("available");
        response.then().statusCode(200);
        response.then()
                .body("[0]", hasKey("id"))
                .body("[0]", hasKey("category"))
                .body("[0]", hasKey("name"))
                .body("[0]", hasKey("photoUrls"))
                .body("[0]", hasKey("tags"))
                .body("[0]", hasKey("status"));

    }

    @Test(description = "Verify pet pet creation endpoint.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Pet")
    @Description("This endpoints creates a new pet based on the payload data")
    public void testPostPet() throws IOException {

        String jsonFilePath =  curentDir + "/src/main/java/org/example/api/json/postPetPayload.json";
        String jsonPayload = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        Response response = pet.postNewPet(jsonPayload);
        String result = response.then()
                .statusCode(200)
                .extract().response().asString();

        // Validate JSON properties in the response using JsonPath
        int id = JsonPath.from(result).get("id");
        int categoryId = JsonPath.from(result).get("category.id");
        String categoryName = JsonPath.from(result).get("category.name");
        String name = JsonPath.from(result).get("name");
        String status = JsonPath.from(result).get("status");

        Assert.assertEquals(id, 1500);
        Assert.assertEquals(categoryId, 15);
        Assert.assertEquals(categoryName, "test_pet");
        Assert.assertEquals(name, "car");
        Assert.assertEquals(status, "available");
    }



    @Test(description = "Verify pet pet update endpoint.", dependsOnMethods = "testPostPet")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Pet")
    @Description("This endpoints update an existing pet based on the payload data")
    public void testPutPet() throws IOException {

        String jsonFilePath =  curentDir + "/src/main/java/org/example/api/json/postPetPayloadUpdated.json";
        String jsonPayload = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        Response response = pet.putUpdatePet(jsonPayload);
        String result = response.then()
                .statusCode(200)
                .extract().response().asString();

        // Validate JSON properties in the response using JsonPath
        int id = JsonPath.from(result).get("id");
        int categoryId = JsonPath.from(result).get("category.id");
        String categoryName = JsonPath.from(result).get("category.name");
        String name = JsonPath.from(result).get("name");
        String status = JsonPath.from(result).get("status");

        Assert.assertEquals(id, 1500);
        Assert.assertEquals(categoryId, 15);
        Assert.assertEquals(categoryName, "test_category");
        Assert.assertEquals(name, "cat");
        Assert.assertEquals(status, "available");
    }


    @Test(description = "Verify pet result after being updated.", dependsOnMethods =  { "testPostPet", "testPutPet" })
    @Severity(SeverityLevel.NORMAL)
    @Story("Pet")
    @Description("This endpoints return the updated status of the previously updated pet")
    public void testVerifyUpdatedPet() throws IOException {
        Response response = pet.getPetById("1500");
        String result = response.then()
                .statusCode(200)
                .extract().response().asString();

        // Validate JSON properties in the response using JsonPath
        int id = JsonPath.from(result).get("id");
        int categoryId = JsonPath.from(result).get("category.id");
        String categoryName = JsonPath.from(result).get("category.name");
        String name = JsonPath.from(result).get("name");
        String status = JsonPath.from(result).get("status");

        Assert.assertEquals(id, 1500);
        Assert.assertEquals(categoryId, 15);
        Assert.assertEquals(categoryName, "test_category");
        Assert.assertEquals(name, "cat");
        Assert.assertEquals(status, "available");

    }

    @Test(description = "Verify pet result after being updated.", dependsOnMethods =  { "testPostPet", "testPutPet", "testVerifyUpdatedPet" })
    @Severity(SeverityLevel.NORMAL)
    @Story("Pet")
    @Description("This endpoints removes the previously inserted pet")
    public void testRemovePet() throws IOException {
        Response response = pet.deletePetById("1500");
        response.then()
                .statusCode(200);
    }

}
