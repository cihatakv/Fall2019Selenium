package com.automation.tests.myTest;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

class ExpediaComAutomationTest {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");


        driver.quit();

    }
}
