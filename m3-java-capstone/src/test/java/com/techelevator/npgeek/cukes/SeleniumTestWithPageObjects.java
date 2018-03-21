package com.techelevator.npgeek.cukes;

import com.techelevator.pageobject.CuyahogaValleyNationalParkDetails;
import com.techelevator.pageobject.HomePage;
import org.junit.AfterClass;
        import org.junit.Before;
        import org.junit.BeforeClass;
        import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestWithPageObjects {

        private static WebDriver webDriver;

        private HomePage homePage;

    @BeforeClass
        public static void openWebBrowserForTesting() {

                String homeDir = System.getProperty("user.home");
                /* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
                 * contains the directory path to the ChromeDriver executable. The following line assumes
                 * we have installed the ChromeDriver in a known location under our home directory */
                System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
                webDriver = new ChromeDriver();
        }

    @Before
    public void openHomePage() {
        webDriver.get("http://localhost:8080/");
        homePage = new HomePage(webDriver);
    }

        @AfterClass
        public static void closeWebBrowser() {
                webDriver.close();
        }

//    @Test
    /* Compare this test to the same test in the MortgageCalculatorIntegrationTestWithoutPageObject class.
     * Using the Page Object pattern here makes the test much more readable. */
//    public void forms_can_be_edited_and_submitted() {
//        CuyahogaValleyNationalParkDetails resultPage = homePage.clickTempSwitch();
//
//        assertEquals("$764.99", resultPage.getPaymentAmount());
//    }

}
