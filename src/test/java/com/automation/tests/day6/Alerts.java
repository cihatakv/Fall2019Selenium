package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(2);

        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);

        String expected = "You successfuly clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        System.out.println("actual   = " + actual);
        System.out.println("expected = " + expected);

        buttons.get(1).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss(); // to click the cancel we use dismiss()

// You clicked: Ok
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("actual2   = " + actual2);
            System.out.println("expected2 = " + expected2);
        }

        buttons.get(2).click();
        BrowserUtils.wait(2);

        driver.switchTo().alert().sendKeys("Hello, World!");
        driver.switchTo().alert().accept();

        String expected3 = "You entered: Hello, World!";
        String actual3 = driver.findElement(By.id("result")).getText();

        if (expected3.equals(actual3)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("actual3   = " + actual3);
            System.out.println("expected3 = " + expected3);
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
