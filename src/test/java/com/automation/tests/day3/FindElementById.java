package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws Exception {

//        WebDriver driver = DriverFactory.createADriver("chrome");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

//        WebElement username = driver.findElement(By.name("username"));
//        username.sendKeys("tomsmith");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

//        WebElement password = driver.findElement(By.name("password"));
//        password.sendKeys("SuperSecretPassword");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);


        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
        loginButton.click();
//        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(1000);


        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        Thread.sleep(1000);


        if (actual.equals(expected))
            System.out.println("LOG IN LINK - TEST PASSED");
        else
            System.out.println("LOG IN LINK - TEST FAILED");

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        logout.click();

        Thread.sleep(1000);


        String afterLogOutExpected = "You logged out of the secure area!";
        String afterLogOutActual = driver.findElement(By.id("flash")).getText();

        if (afterLogOutActual.contains(afterLogOutExpected))
            System.out.println("LOG OUT LINK - TEST PASSED");
        else
            System.out.println("LOG OUT LINK - TEST FAILED");

        Thread.sleep(2000);

        //let's enter invalid credentials

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();


        Thread.sleep(2000);

        // if there is no such element, it will give you an no such element exception error
        try {
            WebElement errorMessage = driver.findElement(By.id("flas"));
            System.out.println(errorMessage.getText());
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element Exception");
        }

        Thread.sleep(2000);


        driver.quit();


    }
}
