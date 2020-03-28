package com.automation.tests.myTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        driver.quit();

        if (driver == null)
            System.out.println("driver null");
        else
            System.out.println("driver not null");

    }
}
