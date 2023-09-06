package org.ait.qa25_Granov;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        login();
        addContact();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContact();
        //click on contact card -  .contact-item_card__2SOIM -css
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContact();
//      assert contact is remove
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
