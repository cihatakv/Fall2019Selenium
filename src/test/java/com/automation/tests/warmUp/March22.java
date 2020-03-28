package com.automation.tests.warmUp;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class March22 {
    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/tables";

    @Test
    public void verifyLastNameSort() {
        List<String> expected = Arrays.asList("Bach", "Conway", "Doe", "Smith");
        driver.findElement(By.xpath("//table[1]//th[1]")).click();
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        boolean isSorted = true;
        for (int i = 0; i < expected.size(); i++) {
            if (!lastNames.get(i).getText().equals(expected.get(i))) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted);
    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

}
