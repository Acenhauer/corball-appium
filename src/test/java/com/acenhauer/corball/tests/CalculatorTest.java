package com.acenhauer.corball.tests;

import com.acenhauer.corball.appium.MobileApp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by guillemhs on 2015-12-28.
 */
public class CalculatorTest extends MobileApp {
    @Test
    public void addShouldWork() throws InterruptedException {
        final String[] number1 = {"net.tecnotopia.SimpleCalculator:id/button1", "1"};
        final String[] operAdd = {"net.tecnotopia.SimpleCalculator:id/buttonAdd", "+"};
        final String[] number5 = {"net.tecnotopia.SimpleCalculator:id/button5", "5"};
        final String[] equals = {"net.tecnotopia.SimpleCalculator:id/buttonEquals", "="};
        final String[] result = {"net.tecnotopia.SimpleCalculator:id/display",
                "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]"};

        final List<By> locNumber1 = new ArrayList();
        final List<By> locOperAdd = new ArrayList();
        final List<By> locNumber5 = new ArrayList();
        final List<By> locEquals = new ArrayList();
        final List<By> locResult = new ArrayList();


        int deviceNum = device.equalsIgnoreCase("Android") ? 0 : 1;
        System.out.println(device + " -  " + deviceNum);

        locNumber1.add(By.id(number1[0]));
        locNumber1.add(By.name(number1[1]));
        locOperAdd.add(By.id(operAdd[0]));
        locOperAdd.add(By.name(operAdd[1]));
        locNumber5.add(By.id(number5[0]));
        locNumber5.add(By.name(number5[1]));
        locEquals.add(By.id(equals[0]));
        locEquals.add(By.name(equals[1]));
        locResult.add(By.id(result[0]));
        locResult.add(By.xpath(result[1]));
        // select the first number
        WebUtil.click(appiumDriver(), locNumber1.get(deviceNum));
        // select the operator
        WebUtil.click(appiumDriver(), locOperAdd.get(deviceNum));
        // select the second number
        WebUtil.click(appiumDriver(), locNumber5.get(deviceNum));
        // click equals to calculate the result
        WebUtil.click(appiumDriver(), locEquals.get(deviceNum));
        // verify the result
        WebElement resultElement = WebUtil.waitAndGetVisibleElement(appiumDriver(), locResult.get(deviceNum));
        assertEquals(6, Integer.parseInt(resultElement.getText()));
    }
}
