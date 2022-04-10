package com.tours.tests;

import com.master.tests.webBase;
import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BookFlightTicket extends webBase {
   private String noOfPassenger;
   private String expectedPrice;

   @BeforeTest
   @Parameters({"noOfPassenger","expectedPrice"})
   public void testSetup(String noOfPassenger,String expectedPrice){
      this.noOfPassenger = noOfPassenger;
      this.expectedPrice =expectedPrice;
   }

   @Test
    public void registrationPageTest(){
       RegistrationPage registrationPage = new RegistrationPage(getDriver());
       registrationPage.goTo();
       registrationPage.enterUserDetails("Renga","Santosh");
       registrationPage.enterUserCredencials("RengaSantosh","worstday");
       registrationPage.submit();
   }

   @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPage(){
       RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(getDriver());
       registrationConfirmationPage.goToFlightDetailsPage();
   }

   @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
       FlightDetailsPage flightDetailsPage = new FlightDetailsPage(getDriver());
       flightDetailsPage.selectPassengers(noOfPassenger);
       flightDetailsPage.goToFindFlightsPage();
   }

   @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
       FlightPage flightPage = new FlightPage(getDriver());
       flightPage.submitFlightDetails();
       flightPage.goToOrderConfirmationPage();
   }

   @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
       FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(getDriver());
       String price = flightConfirmationPage.getPrice();
       Assert.assertEquals(expectedPrice,price);
   }



}
