package org.ait.qa25_Granov;

import org.ait.qa25_Granov.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        app.getContact().clickOnAddLink();

    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().filContactForm(new Contact()
                .setName("Karl")
                .setSurName("Smith")
                .setPhone("1234567890")
                .setEmail("maxsmit@gmail.com")
                .setAddress("London").setDesc("Kok"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        //TODO Не работает удаление контакта
        app.getContact().pause(2000);
        app.getContact().removeContact();
    }
}

