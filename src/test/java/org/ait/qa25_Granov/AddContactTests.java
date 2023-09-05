package org.ait.qa25_Granov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }

        clickOnLoginLink();
        //    enter email [placeholder='Email']
        fillLoginRegistrationForm("max_email_probe@gmail.com", "Aa1234567$");

//        click on Login button
        click(By.xpath("//button[.='Login']"));
//            click on ADD link - [href ='/add'] -css
        click(By.cssSelector("[href ='/add']"));

    }

    @Test
    public void addContactPositiveTest() {
        //enter all input fields in contact form - input:nth-child(1) - scc
        type(By.cssSelector("input:nth-child(1)"), "Max");
        type(By.cssSelector("input:nth-child(2)"), "Smith");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "maxsmit@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "London");
        type(By.cssSelector("input:nth-child(6)"), "Kok");
        click(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(isContactAdded("Max"));
    }

    @AfterMethod
    public void postCondition(){
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }
}

