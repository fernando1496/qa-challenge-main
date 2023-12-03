package org.example.api;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.hasKey;

public class PetTests extends Base{

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
    //String curentDir = System.getProperty("user.dir");
    //String jsonFilePath =  curentDir + "/src/main/java/org/example/api/json/findPetByStatusPayload.json";
    //String jsonPayload = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
}
