package com.automation.tests.day5;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        WebElement bodyInFrame = driver.findElement(By.tagName("body"));

        System.out.println(bodyInFrame.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        WebElement bodyInBottomFrame = driver.findElement(By.tagName("body"));

        System.out.println(bodyInBottomFrame.getText());

        driver.quit();

    }
}
