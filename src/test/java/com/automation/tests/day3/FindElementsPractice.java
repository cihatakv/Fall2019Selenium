package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullname = driver.findElement(By.name("full_name"));
        fullname.sendKeys("Mister Twister");

        Thread.sleep(200);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");
        Thread.sleep(200);
        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.submit();
        Thread.sleep(200);
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        // WebElement message = driver.findElement(By.className("subheader"));

        WebElement message = driver.findElement(By.name("signup_message"));

        String actual = message.getText();

        if (actual.equals(expected))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");

        driver.quit();

    }
}
