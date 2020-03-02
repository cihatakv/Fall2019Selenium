
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
        Thread.sleep(1000);
        driver.manage().window().maximize();
        String expectedTitle = "Google";

        String title = driver.getTitle();

        if (title.equals(expectedTitle)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        driver.navigate().to("https://www.amazon.com");
        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        //comeback to google
        driver.navigate().back();
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(), "Google");

        driver.navigate().forward();
        Thread.sleep(3000);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //checking if page title is equals to Google
        //.getTitle() - returns page title
        //must be at the end
        driver.close();//to close browser
        //browser cannot close itself
    }

    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     *
     * @param arg1
     * @param arg2
     */
    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

    }
}
