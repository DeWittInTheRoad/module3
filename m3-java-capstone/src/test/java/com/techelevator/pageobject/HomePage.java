package com.techelevator.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public favoriterks clickWeightCalculatorLink() {
        WebElement weightCalculatorLink = webDriver.findElement(By.linkText("Alien Weight"));
        weightCalculatorLink.click();
        return new AlienWeightCalculatorInputPage(webDriver)
    }
}



