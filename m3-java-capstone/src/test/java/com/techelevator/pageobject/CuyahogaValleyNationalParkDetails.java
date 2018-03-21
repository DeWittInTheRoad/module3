package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CuyahogaValleyNationalParkDetails {

    private WebDriver webDriver;

    public CuyahogaValleyNationalParkDetails(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public CuyahogaValleyNationalParkDetails submitForm() {
        WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));
        submitButton.click();
        return new CuyahogaValleyNationalParkDetails(webDriver);
    }
}
