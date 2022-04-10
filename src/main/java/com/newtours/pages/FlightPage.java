package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {

    @FindBy(name ="reserveFlights")
    private WebElement continueBtn;

    @FindBy(name = "buyFlights")
    private WebElement secondContinueBtn;

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void submitFlightDetails(){
        wait.until(ExpectedConditions.visibilityOf(this.continueBtn));
        this.continueBtn.click();
    }

    public void goToOrderConfirmationPage(){
        wait.until(ExpectedConditions.visibilityOf(this.secondContinueBtn));
        this.secondContinueBtn.click();
    }
}
