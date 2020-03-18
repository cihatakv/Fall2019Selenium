package com.automation.tests.myTest;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SephoraTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.sephora.com/");
        BrowserUtils.wait(2);

        WebElement closePopUp = driver.findElement(By.className("css-1rq477f"));
        BrowserUtils.wait(2);
        closePopUp.click();
        BrowserUtils.wait(2);

        driver.quit();

    }
}
