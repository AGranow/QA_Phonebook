package org.ait.qa25_Granov;

import org.ait.qa25_Granov.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("max_email_probe@gmail.com")
                .setPassword("Aa1234567$"));
        app.getUser().clickOnLoginButton();
        app.getUser().isSignOutButtonPresent();
    }

    @Test
    public void loginNegativeWithoutTest() {
        app.getUser().fillLoginRegistrationForm(new User()
                .setPassword("Aa1234567$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
