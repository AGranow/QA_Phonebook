package org.ait.qa25_Granov;

import org.ait.qa25_Granov.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //    precondition: if user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    //    @Test
//    public void newUserRegistrationPositiveTest() {
////    enter email [placeholder='Email']
//        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
//        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
//        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("max_email_probe@gmail.com");
//
////    enter password [placeholder='Password']
//        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
//        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
//        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Aa1234567$");
//
////    click on Registration button  //button[text()='Registration']
//        driver.findElement(By.xpath("//button[text()='Registration']")).click();
//
////    assert Sign out button displayed
//        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
//    }

    @Test
    public void existedUserNegativeTest() {
//    enter email [placeholder='Email']
        app.getUser().fillLoginRegistrationForm(new User().setEmail("max_email_probe@gmail.com").setPassword("Aa1234567$"));

//    click on Registration button  //button[text()='Registration']
        app.getUser().clickOnRegistrationButton();

//    assert alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
