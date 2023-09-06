package org.ait.qa25_Granov;

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
        fillLoginRegistrationForm(new User()
                .setEmail("max_email_probe@gmail.com")
                .setPassword("Aa1234567$"));

//        click on Login button
        clickOnLoginButton();
//        assert Sign out button present
        isSignOutButtonPresent();
    }

    @Test
    public void loginNegativeWithoutTest() {
        fillLoginRegistrationForm(new User()
                .setPassword("Aa1234567$"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }


}
