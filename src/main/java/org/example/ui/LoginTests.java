package org.example.ui;

import io.qameta.allure.*;
import org.example.ui.listeners.TestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestExecutionListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends Base{

    @Test(description = "Login test with valid username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login feature")
    @Description("Verify user is able to see the dashboard when using valid credentials. Then log out")
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

    @Test(description = "Login test with a locked username.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Login feature")
    @Description("Verify an error message is displayed when user tries to log in with a locked user.")
    private void LogInUsingLockedUser(){
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertTrue(commonCommands.isElementVisibleByText("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test(description = "Login test with a invalid username and password.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Login feature")
    @Description("Verify error message is displayed when user tries to log in with invalid credentials.")
    private void LogInWithInvalidCredentials(){
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("bad_pass");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertTrue (commonCommands.isElementVisibleByText("Epic sadface: Username and password do not match any user in this service"));
    }
}
