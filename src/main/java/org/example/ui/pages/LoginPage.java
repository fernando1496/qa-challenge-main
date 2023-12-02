package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void typeSearch(String search){
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search documents, videos, and help resources']"));
        searchInput.sendKeys(search);
        searchInput.sendKeys(Keys.RETURN);
    }

    public void selectFilter(String filter){
        WebElement filterCheckbox = driver.findElement(By.xpath(String.format("//span[text()='%1$s']",filter )));
        filterCheckbox.click();
    }


    public void clickResultsByPosition(int position){
        position = position -1;
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='coveo-list-layout CoveoResult']//div[@class='coveo-result-cell ArticleViewerLinks']/a"));
        results.get(position).click();
    }



}
