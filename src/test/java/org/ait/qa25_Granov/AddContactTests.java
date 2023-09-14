package org.ait.qa25_Granov;

import org.ait.qa25_Granov.models.Contact;
import org.ait.qa25_Granov.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public void postCondition() {
        //TODO Не работает удаление контакта
        app.getContact().pause(5000);
        app.getContact().removeContact();
    }

    @DataProvider
    public Iterator<Object[]> newContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Cohen", "1314151616", "email@gmail", "Berlin", "ingeneur"});
        list.add(new Object[]{"Oliver", "Cohen", "1314151616", "email@gmail", "Berlin", "ingeneur"});
        list.add(new Object[]{"Oliver", "Cohen", "1314151616", "email@gmail", "Berlin", "ingeneur"});

        return list.iterator();
    }


     @DataProvider()
    public Iterator<Object[]> newContactWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/PhonebookData.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSurName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDesc(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @Test(dataProvider = "newContactWithCSVFile" , dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(Contact contact) {
        app.getContact().filContactForm(contact);
        app.getContact().clickOnSaveButton();
        app.getContact().pause(1000);
       Assert.assertEquals(Integer.toString(app.getContact().sizeOfContact()), "1");
    }
}

