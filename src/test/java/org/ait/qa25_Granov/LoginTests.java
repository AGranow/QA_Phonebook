package org.ait.qa25_Granov;

import org.ait.qa25_Granov.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

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
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutTest() {
        app.getUser().fillLoginRegistrationForm(new User()
                .setPassword("Aa1234567$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();

        app.getUser().fillLoginRegistrationFormScreencast(new User()
                .setEmail("max_email_probe@gmail.com")
                .setPassword("Aa1234567$"));
        app.getUser().clickOnLoginButton();

        app.getUser().pause(2000);
        app.getUser().stopRecording();
    }

}
