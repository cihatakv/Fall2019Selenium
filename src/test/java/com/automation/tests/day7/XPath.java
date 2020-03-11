package com.automation.tests.day7;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPath {
    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator = "//button[contains(text(), 'Login')]";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        BrowserUtils.wait(1);
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(1);
        driver.findElement(By.xpath(loginBtnLocator)).click();
        BrowserUtils.wait(1);

        BrowserUtils.wait(3);
        driver.quit();
    }
}
