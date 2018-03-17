//package com.techelevator.npgeek.cukes;
//import static org.junit.Assert.*;
//
//        import java.util.List;
//
//        import org.junit.AfterClass;
//        import org.junit.Before;
//        import org.junit.BeforeClass;
//        import org.junit.Test;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.chrome.ChromeDriver;
//        import org.openqa.selenium.firefox.FirefoxDriver;
//        import org.openqa.selenium.safari.SafariDriver;
//        import org.openqa.selenium.support.ui.Select;
//
//public class SeleniumTestWithPageObjects {
//
//        private static WebDriver webDriver;
////        private AllParks allParks;
//
//        @BeforeClass
//        public static void openWebBrowserForTesting() {
//
//                String homeDir = System.getProperty("user.home");
//                /* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
//                 * contains the directory path to the ChromeDriver executable. The following line assumes
//                 * we have installed the ChromeDriver in a known location under our home directory */
//                System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
//                webDriver = new ChromeDriver();
//        }
//
//        @Before
//        public void openHomePage() {
//                webDriver.get("http://localhost:8080/m3-java-selenium-lecture/");
////                allParks = new allParks(webDriver);
////        }
////
////        @AfterClass
////        public static void closeWebBrowser() {
////                webDriver.close();
////        }
//}
