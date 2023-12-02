package org.example.ui.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonCommands {
    WebDriver driver;


    public CommonCommands(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementVisibleByText(String text){
        String xpathLocator = String.format("//*[text()='%s']",text);
        WebElement webElement = driver.findElement(By.xpath(xpathLocator));
        return webElement.isDisplayed();
    }

    public void clickElementByText(String text){
        WebDriverWait wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathLocator = String.format("//*[text()='%s']",text);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
        webElement.click();
    }
}
