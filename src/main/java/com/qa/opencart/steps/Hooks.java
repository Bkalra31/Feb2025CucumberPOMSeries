package com.qa.opencart.steps;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private DriverFactory df;
    private WebDriver driver;
    private Properties prop;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        df = new DriverFactory();
        prop = df.initProp();

//        String browserName = System.getProperty("browser", prop.getProperty("browser", "chrome"));
//        String browserVersion = System.getProperty("browserversion", prop.getProperty("browserversion", ""));
//        String testName = System.getProperty("testname", prop.getProperty("testname", "defaultTest"));
//
//        prop.setProperty("browser", browserName);
//        prop.setProperty("browserversion", browserVersion);
//        prop.setProperty("testname", testName);

        driver = df.initDriver(prop);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
    	 if (driver != null) {
             try {
                 // Log test status and screenshot on failure
                 if (scenario.isFailed()) {
                     // Implement screenshot logic here (e.g., Base64 screenshot)
                     System.out.println("Test FAILED: " + scenario.getName());
                 }
                 driver.quit();
             } catch (Exception e) {
                 System.err.println("Failed to quit driver: " + e.getMessage());
             } finally {
                 driver = null; // Prevent memory leaks
             }
         }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public LoginPage getLoginPage() {
        return this.loginPage;
    }



}
