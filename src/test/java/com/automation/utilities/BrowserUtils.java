package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    /**
     * @param seconds
     */

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * BrowserUtils.getTextFromWebElements(columnNames) ==>
     * this method takes the text of every single webElement and puts it into collection of strings
     *
     * @param elements
     * @return
     */

    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            textValues.add(element.getText());
        }
        return textValues;
    }
}
