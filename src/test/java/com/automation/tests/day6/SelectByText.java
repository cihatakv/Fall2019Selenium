package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);

        selectSimpleDropdown.selectByVisibleText("Option 2");

        BrowserUtils.wait(2);

        selectSimpleDropdown.selectByVisibleText("Option 1");

        //
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2003");

        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month : months) {
            String monthName = month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(0);
        }


//        for (int i = 0; i < 2; i++) {
//            for (int j = 1; j < 31; j++) {
//                String s = String.valueOf(j);
//                selectDay.selectByVisibleText(s);
//            }
//        }
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByVisibleText("District Of Columbia");

        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = stateSelect.getOptions();

        for (WebElement stateOption : states) {
            System.out.println(stateOption.getText());
        }

        BrowserUtils.wait(3);
        driver.quit();

    }
}
