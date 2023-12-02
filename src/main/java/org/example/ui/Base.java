package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Base {

    protected WebDriver driver = null;


    @BeforeClass
    public void beforeEveryClass(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void afterEveryClass() {
        driver.quit();
    }



}