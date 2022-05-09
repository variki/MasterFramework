package com.tours.tests;

import com.master.driver.DriverManager;
import com.master.tests.web.base.WebBase;
import com.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BookFlightTicket extends WebBase {
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
       RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
       registrationPage.goTo();
       registrationPage.enterUserDetails("Renga","Santosh");
       registrationPage.enterUserCredencials("RengaSantosh","worstday");
       registrationPage.submit();
   }

   @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPage(){
       RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(DriverManager.getDriver());
       registrationConfirmationPage.goToFlightDetailsPage();
   }

   @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
       FlightDetailsPage flightDetailsPage = new FlightDetailsPage(DriverManager.getDriver());
       flightDetailsPage.selectPassengers(noOfPassenger);
       flightDetailsPage.goToFindFlightsPage();
   }

   @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
       FlightPage flightPage = new FlightPage(DriverManager.getDriver());
       flightPage.submitFlightDetails();
       flightPage.goToOrderConfirmationPage();
   }

   @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
       FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(DriverManager.getDriver());
       String price = flightConfirmationPage.getPrice();
       Assert.assertEquals(expectedPrice,price);
   }



}
