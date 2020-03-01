package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        // to start selenium script we need:
        // setup webdriver object (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium, everything starts from webDriver interface

        Thread.sleep(3000);
        driver.get("https://www.google.com");

        String title = driver.getTitle();

        System.out.println("title = " + title);
        Thread.sleep(3000);
        driver.close();


    }
}
