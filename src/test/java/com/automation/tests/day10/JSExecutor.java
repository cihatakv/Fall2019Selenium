package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    //private WebDriver driver;
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
//        driver = DriverFactory.createADriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void scrollTest() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 250)");
        BrowserUtils.wait(3);
        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
    }

    @Test
    public void scrollToElementTest() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
    }

}
