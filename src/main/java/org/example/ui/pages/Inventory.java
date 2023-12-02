package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory {
    WebDriver driver;


    public Inventory(WebDriver driver){
        this.driver = driver;
    }


    public void openLeftMenu(){
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        loginButton.click();
    }



}
