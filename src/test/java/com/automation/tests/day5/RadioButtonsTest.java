package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // driver.manage().window().maximize();

        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));

        if (blackButton.isDisplayed() && blackButton.isEnabled()) {
            blackButton.click();
        }

        if (blackButton.isSelected()) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }


        driver.quit();
    }
}
