package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));

        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
        }

        driver.findElement(By.linkText("Etsy")).click();

        BrowserUtils.wait(2);

        driver.quit();

    }
}
