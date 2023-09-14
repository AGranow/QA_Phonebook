package org.ait.qa25_Granov.utils;

import org.ait.qa25_Granov.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


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
}
