package org.example.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    WebDriver driver;


    public Inventory(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open left menu to display options.")
    public void openLeftMenu(){
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        loginButton.click();
    }


    @Step("Order items by {0} using filter.")
    public void orderItemsUsingFilterBy(String order){
        WebElement filter = driver.findElement(By.cssSelector(".product_sort_container"));
        Select dropdown = new Select(filter);
        dropdown.selectByVisibleText(order);
    }

    @Step("Obtain items in the list order.")
    public List<String> obtainItemsOrder(){
        List<String> itemOrder = new ArrayList<>();
        List<WebElement> itemNames = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (WebElement element : itemNames) {
            itemOrder.add(element.getText());
        }
        return itemOrder;
    }


}
