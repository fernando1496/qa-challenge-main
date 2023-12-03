package org.example.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Type username: '{0}'.")
    public void typeUsername(String username){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys(username);
    }

    @Step("Type password: '{0}'.")
    public void typePassword(String password){
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }

    @Step("Click on log in button.")
    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }



}
