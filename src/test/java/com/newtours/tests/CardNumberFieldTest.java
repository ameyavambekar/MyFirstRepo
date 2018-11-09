package com.newtours.tests;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.newtours.pages.BookFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.HomePage;
import com.newtours.pages.SelectFlightsPage;
import com.newtours.pages.SignOnPage;
import com.newtours.util.CommonMethods;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class CardNumberFieldTest extends WebDriverTestCase {
	
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
		bookFlightPage = new BookFlightPage();
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
		bookFlightPage.selectCreditCard(getProperty("card"));
		bookFlightPage.selectCCExpiryMonth(getProperty("month"));
		bookFlightPage.selectCCExpiryYear(getProperty("year"));
		bookFlightPage.selectMeal(getProperty("meal"));
	
	}
	

	@QAFDataProvider(key="maxcardlength")
	@Test(description="Enter card number with length more than 16")
	public void maxCardLength(Map<String,String> data)
	{
		bookFlightPage = new BookFlightPage();
		bookFlightPage.fillDetails("maxcardlength");
		bookFlightPage.verifyCreditCardNumberLength(data.get("ccNumber"));		
	}

	@QAFDataProvider(key="invalidcardnumber")
	@Test(description="Enter card number with alphanumeric and special characters")
	public void invalidCardNumber(Map<String,String> data)
	{
		bookFlightPage = new BookFlightPage();
		confirmationPage = new FlightConfirmationPage();
		
		
		bookFlightPage.fillDetails("invalidcardnumber");	
		bookFlightPage.clickPurchaseButton();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
		confirmationPage.verifyInvoice();
	}
	
	@QAFDataProvider(key="numericcardnumber")
	@Test(description="Enter 16 digit numeric card number and validate")
	public void validCardNumber(Map<String,String> data)
	{
		bookFlightPage = new BookFlightPage();
		confirmationPage = new FlightConfirmationPage();
		
		bookFlightPage.fillDetails("numericcardnumber");
		bookFlightPage.clickPurchaseButton();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
		confirmationPage.verifyInvoice();
	}
	
	
	@QAFDataProvider(key="lessthansixteencardnumber")
	@Test(description="Enter card number with less than 16 digits")
	public void lessThanSixteenCardNumber(Map<String,String>data)
	{
		bookFlightPage = new BookFlightPage();
		confirmationPage = new FlightConfirmationPage();
		bookFlightPage.fillDetails("lessthansixteencardnumber");
		bookFlightPage.clickPurchaseButton();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
		confirmationPage.verifyInvoice();
		
	}
	
	
	@AfterMethod
	public void logOut()
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
