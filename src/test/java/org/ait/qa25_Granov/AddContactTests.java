package org.ait.qa25_Granov;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        login();
        clickOnAddLink();

    }

    @Test
    public void addContactPositiveTest() {
        filContactForm(new Contact()
                .setName("Max")
                .setSurName("Smith")
                .setPhone("1234567890")
                .setEmail("maxsmit@gmail.com")
                .setAddress("London").setDesc("Kok"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Max"));
    }

    @AfterMethod
    public void postCondition(){
        removeContact();
    }

}

