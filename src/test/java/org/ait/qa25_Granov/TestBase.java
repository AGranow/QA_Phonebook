package org.ait.qa25_Granov;

import org.ait.qa25_Granov.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

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
    public void startTest(Method m, Object[] p) {
        logger.info("Start test" + m.getName() + " with data " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED : " + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED : " + result.getMethod().getMethodName() + "  Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.error("*****************************************");
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
