package com.newtours.tests;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newtours.pages.BookFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.HomePage;
import com.newtours.pages.SelectFlightsPage;
import com.newtours.pages.SignOnPage;
import com.newtours.util.CommonMethods;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class BookFlightNameTest extends WebDriverTestCase {

	
	
		
		public  FlightFinderPage flightFinderPage;
		public  HomePage homePage;
		public  SignOnPage signOnPage;
		public  SelectFlightsPage selectFlightsPage;
		public BookFlightPage bookFlightPage; 
		public FlightConfirmationPage confirmationPage;
		public CommonMethods common;
		
		
		@BeforeClass
		public void init()
		{
			getDriver().get("/");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		}
		
		
		@BeforeMethod
		public void preConditions() {
			common = new CommonMethods();
			flightFinderPage = new FlightFinderPage();
			selectFlightsPage = new SelectFlightsPage();
			
			common.signOn(getProperty("username"),getProperty("password"));
			flightFinderPage.selectFlightDetails();
			flightFinderPage.clickButtonContinue();
			Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("selectflightpage.url")));
			selectFlightsPage.scrollDown();
			selectFlightsPage.selectDepartFlight();
			selectFlightsPage.selectReturnFlight();
			selectFlightsPage.clickContinueButton();
			Validator.verifyThat("User should be on Book Flight Page", getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("bookflightpage.url")));
		}

		

		
		@Test(description="Enter booking details and keep name field blank")
		public void bookFlightWithBlankName()
		{
			bookFlightPage = new BookFlightPage();
			bookFlightPage.verifySummary();
			bookFlightPage.selectMeal(getProperty("meal"));
			bookFlightPage.selectCreditCard(getProperty("card"));
			bookFlightPage.selectCCExpiryMonth(getProperty("month"));
			bookFlightPage.selectCCExpiryYear(getProperty("year"));
			bookFlightPage.fillDetails("blank-name");
			bookFlightPage.clickPurchaseButton();
			Validator.verifyThat("User should navigate to flight booking confirmation page", getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
			confirmationPage = new FlightConfirmationPage();
			confirmationPage.verifyInvoice();
		}
		
		
		@Test(description="Enter booking details and name field should contain only special characters and numeric values")
		public void bookFlightWithNonAlphabeticCharacters()
		{
			bookFlightPage = new BookFlightPage();
			bookFlightPage.verifySummary();
			bookFlightPage.selectMeal(getProperty("meal"));
			bookFlightPage.selectCreditCard(getProperty("card"));
			bookFlightPage.selectCCExpiryMonth(getProperty("month"));
			bookFlightPage.selectCCExpiryYear(getProperty("year"));
			bookFlightPage.fillDetails("invalid-name");
			bookFlightPage.clickPurchaseButton();
			Validator.verifyThat("User should navigate to flight booking confirmation page", getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
			confirmationPage = new FlightConfirmationPage();
			confirmationPage.verifyInvoice();
		}
		
		@Test(description="Enter booking details and name field should contain only alphabetic characters")
		public void bookFlightWithAlphabeticName()
		{
			bookFlightPage = new BookFlightPage();
			bookFlightPage.verifySummary();
			bookFlightPage.selectMeal(getProperty("meal"));
			bookFlightPage.selectCreditCard(getProperty("card"));
			bookFlightPage.selectCCExpiryMonth(getProperty("month"));
			bookFlightPage.selectCCExpiryYear(getProperty("year"));
			bookFlightPage.fillDetails("data");
			bookFlightPage.clickPurchaseButton();
			Validator.verifyThat("User should navigate to flight booking confirmation page", getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
			confirmationPage = new FlightConfirmationPage();
			confirmationPage.verifyInvoice();
		}
		
		@AfterMethod
		public void afterMethod()
		{
			common = new CommonMethods();
			common.signOff();
		}
		
		
		@AfterClass
		public void tearDown()
		{
			getDriver().close();
		}
		


}
