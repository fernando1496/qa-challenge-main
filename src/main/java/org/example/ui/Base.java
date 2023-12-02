package org.example.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ui.common.CommonCommands;
import org.example.ui.pages.Inventory;
import org.example.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {

    protected WebDriver driver = null;
    protected LoginPage loginPage;
    protected CommonCommands commonCommands;
    protected Inventory inventory;


    @BeforeMethod
    public void beforeEveryMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        commonCommands = new CommonCommands(driver);
        inventory = new Inventory(driver);
}


    @AfterMethod
    public void afterEveryClass() {
        driver.quit();
    }



}