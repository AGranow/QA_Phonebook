package org.ait.qa25_Granov;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        app.getContact().addContact();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContact();

        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContact();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
