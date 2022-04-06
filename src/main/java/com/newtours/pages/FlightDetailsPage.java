package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    @FindBy(name = "passCount")
    private WebElement passengersList;

    @FindBy(name = "findFlights")
    private WebElement continueBtn;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassengers(String passenger){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passengersList));
        Select select = new Select(this.passengersList);
        select.selectByValue(passenger);
    }

    public void goToFindFlightsPage(){
        this.continueBtn.click();
    }
}
