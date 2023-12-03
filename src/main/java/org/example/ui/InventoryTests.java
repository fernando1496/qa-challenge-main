package org.example.ui;

import io.qameta.allure.*;
import org.example.api.listeners.TestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({ TestExecutionListener.class })
@Epic("Regression Tests")
@Feature("Inventory")
public class InventoryTests extends Base{

    @Test(description = "Verify desc item order in inventory page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Inventory")
    @Description("Items should be ordered from A to Z by default or after using filter")
    private void OrderProductByNameDesc() {
        String[] expectedOrder = {
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        };

        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        inventory.orderItemsUsingFilterBy("Name (A to Z)");
        List<String> actualOrder = inventory.obtainItemsOrder();
        Assert.assertEquals(expectedOrder.length, actualOrder.size());
        for (int i = 0; i < expectedOrder.length; i++) {
            Assert.assertEquals(actualOrder.get(i) ,expectedOrder[i]);
        }
    }

    @Test(description = "Verify asc item order in inventory page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Inventory")
    @Description("Items should be ordered from Z to A after using filter")
    private void OrderProductByNameAsc() {
        String[] expectedOrder = {
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Onesie",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Bike Light",
                "Sauce Labs Backpack"
        };

        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        inventory.orderItemsUsingFilterBy("Name (Z to A)");
        List<String> actualOrder = inventory.obtainItemsOrder();
        Assert.assertEquals(expectedOrder.length, actualOrder.size());
        for (int i = 0; i < expectedOrder.length; i++) {
            Assert.assertEquals(actualOrder.get(i) ,expectedOrder[i]);
        }
    }

    @Test(description = "Verify price asc item order in inventory page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Inventory")
    @Description("Items should be ordered from Price low to high after using filter")
    private void OrderProductByPriceAsc() {
        String[] expectedOrder = {
                "Sauce Labs Onesie",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Backpack",
                "Sauce Labs Fleece Jacket"
        };

        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        inventory.orderItemsUsingFilterBy("Price (low to high)");
        List<String> actualOrder = inventory.obtainItemsOrder();
        Assert.assertEquals(expectedOrder.length, actualOrder.size());

        for (int i = 0; i < expectedOrder.length; i++) {
            Assert.assertEquals(actualOrder.get(i) ,expectedOrder[i]);
        }
    }

    @Test(description = "Verify price desc item order in inventory page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Inventory")
    @Description("Items should be ordered from Price high to low after using filter")
    private void OrderProductByPriceDesc() {
        String[] expectedOrder = {
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Bike Light",
                "Sauce Labs Onesie"
        };

        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
        inventory.orderItemsUsingFilterBy("Price (high to low)");
        List<String> actualOrder = inventory.obtainItemsOrder();
        Assert.assertEquals(expectedOrder.length, actualOrder.size());

        for (int i = 0; i < expectedOrder.length; i++) {
            Assert.assertEquals(actualOrder.get(i) ,expectedOrder[i]);
        }
    }
}
