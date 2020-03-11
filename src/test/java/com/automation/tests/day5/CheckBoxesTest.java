package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected()) {
            System.out.println("First checkBox is not selected and TEST PASSED");
        } else {
            System.out.println("First checkBox is selected and TEST FAILED");
        }


        if (checkBoxes.get(1).isSelected()) {
            System.out.println("Second checkBox is selected and TEST PASSED");
        } else {
            System.out.println("Second checkBox is not selected and TEST FAILED");
        }

        driver.quit();


    }
}
