package org.ait.qa25_Granov;

import org.ait.qa25_Granov.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite  //(enabled = false)
    public void tearDown() {
        app.stop();
    }


    @BeforeMethod
    public void startTest(){
        logger.info("Start test");
    }

    @AfterMethod
    public void stopTest(){
        logger.info("Stop test");
    }

}


/*
@BeforeTest
  @BeforeMethod
    @BeforeClass
      @BeforeSuite
         @BeforeGroups
         @AfterGroups
      @AfterSuite
    @AfterClass
  @AfterMethod
@AfterTest
 */
