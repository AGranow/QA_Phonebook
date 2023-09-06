package org.ait.qa25_Granov.framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class HelperBase {

    WebDriver driver;


    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By locator) {
        try {
            driver.findElements(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        if (text!=null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isAlertPresent(){
        // class Alert - alert initialization witch expected condition
        Alert alert = new WebDriverWait(driver,20)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        }else {
            // switch t alert
            driver.switchTo().alert();

            alert.accept();
            return true;
        }
    }

    public void pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}