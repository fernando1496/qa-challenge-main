package org.example.ui.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory {
    WebDriver driver;


    public Inventory(WebDriver driver){
        this.driver = driver;
    }

    public void isElementVisibleByText(String text){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys(username);
    }

    public void typePassword(String password){
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }


    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }



}
