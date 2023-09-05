package org.ait.qa25_Granov;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }

//    click on Login link a:nth-child(4)
        clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
//    enter email [placeholder='Email']
        fillLoginRegistrationForm("max_email_probe@gmail.com", "Aa1234567$");

//        click on Login button
        click(By.xpath("//button[.='Login']"));
//        assert Sign out button present
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));

    }


}
