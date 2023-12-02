package org.example.ui;

import io.qameta.allure.Description;
import org.example.ui.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutProduct extends Base{
    HomePage homePage;

    @BeforeClass
    private void beforeClass() {
        homePage = new HomePage(driver);
    }

    @Test()
    @Description("Test Description: Open Google and perform actions.")
    private void Test() throws InterruptedException {
        homePage.typeSearch("sales");
        homePage.selectFilter("Documentation");
        homePage.clickResultsByPosition(1);

    }
}
