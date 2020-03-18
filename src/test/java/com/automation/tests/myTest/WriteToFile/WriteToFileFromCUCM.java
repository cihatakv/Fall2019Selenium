package com.automation.tests.myTest.WriteToFile;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileFromCUCM {
    public static void main(String[] args) throws IOException {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://10.2.1.11");
        BrowserUtils.wait(3);

        WebElement advancedButton = driver.findElement(By.id("details-button"));
        advancedButton.click();

        BrowserUtils.wait(3);

        WebElement proceed = driver.findElement(By.id("proceed-link"));
        proceed.click();

        BrowserUtils.wait(3);

        driver.get("https://10.2.1.11/ccmadmin/showHome.do");
        BrowserUtils.wait(3);

        WebElement userName = driver.findElement(By.name("j_username"));
        userName.sendKeys("itsupporthq");
        BrowserUtils.wait(3);
        WebElement password = driver.findElement(By.name("j_password"));
        password.sendKeys("Ked@sed2020Hq");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.className("cuesLoginButton"));
        buttons.get(0).click();
        BrowserUtils.wait(3);
        WebElement devices = driver.findElement(By.id("DeviceButton"));
        devices.click();
        BrowserUtils.wait(1);

        WebElement phones = driver.findElement(By.linkText("Phone"));
        phones.click();
        BrowserUtils.wait(3);

        WebElement where = driver.findElement(By.id("searchField0"));
        Select selectSimpleDropdownWhere = new Select(where);
        selectSimpleDropdownWhere.selectByVisibleText("Device Pool");

        WebElement selectItem = driver.findElement(By.name("utilityList"));
        Select selectSimpleDropdownItem = new Select(selectItem);
        selectSimpleDropdownItem.selectByVisibleText("HQ-DP");

        driver.findElement(By.name("findButton")).click();
        BrowserUtils.wait(3);

        Select countSelect = new Select(driver.findElement(By.id("rowsPerPageControl")));
        countSelect.selectByIndex(5);

        BrowserUtils.wait(5);

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\admin\\Fall2019Selenium\\src\\test\\java\\com\\automation\\tests\\myTest\\WriteToFile\\MAC_Address_and_StaffName.txt", true)  //Set true for append mode
        );

        for (int i = 2; i < 169; i++) {
            WebElement phoneMac = driver.findElement(By.xpath("//*[@id=\"phoneFindListForm\"]/table[2]/tbody/tr[" + i + "]/td[3]/a"));
            WebElement phoneUser = driver.findElement(By.xpath("//*[@id=\"phoneFindListForm\"]/table[2]/tbody/tr[" + i + "]/td[4]"));
            String s = phoneUser.getText();
            if (s.contains("-")) {
                System.out.print(phoneMac.getText().substring(3) + " -> ");
                System.out.println(s.substring(0, s.indexOf("-")));
                writer.newLine();
                writer.write(phoneMac.getText().substring(3) + "\t");
                writer.write(s.substring(0, s.indexOf("-")));
            }
        }
        writer.close();
        driver.quit();
        /*
        FileWriter myWriter = new FileWriter("filename.txt");
        myWriter.write("Files in Java might be tricky, but it is fun enough!");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
        */
    }
}
