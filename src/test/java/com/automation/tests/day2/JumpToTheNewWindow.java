package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        String windowsHandle = driver.getWindowHandle();
        System.out.println("windowsHandle = " + windowsHandle);
        System.out.println("BEFORE SWITCH driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Set<String> windowhandles = driver.getWindowHandles();

//        System.out.println("windowhandles = " + windowhandles);

        for (String windowId : windowhandles) {
            if (!windowId.equals(windowsHandle))
                driver.switchTo().window(windowId);
        }

        System.out.println("AFTER SWITCH driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle))
                break;
        }
    }
}
