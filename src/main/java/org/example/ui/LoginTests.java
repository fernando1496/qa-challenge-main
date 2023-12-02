package org.example.ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends Base{

    @Test()
    @Description("Test Description: Log in using valid credentials and log out.")
    private void LogInWithValidCredentials(){
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(commonCommands.isElementVisibleByText("Sauce Labs Backpack"));
        inventory.openLeftMenu();
        commonCommands.clickElementByText("Logout");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }

    @Test()
    @Description("Test Description: Log in using locked user.")
    private void LogInUsingLockedUser(){
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertTrue(commonCommands.isElementVisibleByText("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test()
    @Description("Test Description: Log in using invalid user.")
    private void LogInWithInvalidCredentials(){
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("bad_pass");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertTrue(commonCommands.isElementVisibleByText("Epic sadface: Username and password do not match any user in this service"));
    }
}
