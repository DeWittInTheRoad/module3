package com.techelevator.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public SurveyPage clickSurveyLink() {
        WebElement calculatorLink = webDriver.findElement(By.linkText("Survey"));
        calculatorLink.click();
        return new SurveyPage(webDriver);
    }

//    public CuyahogaValleyNationalParkDetails clickCuyahogaValleyNationalParkLink() {
//        WebElement calculatorLink = webDriver.findElement(By.linkText("Cuyahoga Valley National Park"));
//        calculatorLink.click();
//        return new CuyahogaValleyNationalParkDetails(webDriver);
//    }




}



