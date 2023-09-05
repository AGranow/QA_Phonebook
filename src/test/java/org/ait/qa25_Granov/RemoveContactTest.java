package org.ait.qa25_Granov;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {


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

        type(By.cssSelector("input:nth-child(1)"), "Max");
        type(By.cssSelector("input:nth-child(2)"), "Smith");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "maxsmit@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "London");
        type(By.cssSelector("input:nth-child(6)"), "Kok");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContact();
        //click on contact card -  .contact-item_card__2SOIM -css
        click(By.cssSelector(".contact-item_card__2SOIM"));
//        click on remove button  - //button[.=Remove]   -xpath
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContact();
//    assert contact is remove
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

    public void pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContact() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
