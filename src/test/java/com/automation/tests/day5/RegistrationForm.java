package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.findElement(By.name("firstname")).sendKeys("John");
        BrowserUtils.wait(1);
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        BrowserUtils.wait(1);
        driver.findElement(By.name("username")).sendKeys("jsmith");
        BrowserUtils.wait(1);
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        BrowserUtils.wait(1);
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        BrowserUtils.wait(1);
        driver.findElement(By.name("phone")).sendKeys("713-713-7133");
        BrowserUtils.wait(1);
        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click();
        BrowserUtils.wait(1);
        driver.findElement(By.name("birthday")).sendKeys("01/01/1980");
        BrowserUtils.wait(1);
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);


    }
}
