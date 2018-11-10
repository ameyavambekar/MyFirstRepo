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
import com.newtours.util.CommonMethods;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class BackToHomeTest extends WebDriverTestCase {

	
	public CommonMethods commonMethods;
	public HomePage homePage;
	public SelectFlightsPage selectFlightsPage;
	public FlightFinderPage flightFinderPage;
	public BookFlightPage bookFlightPage;
	public FlightConfirmationPage flightConfirmationPage;
	
	

	@BeforeClass
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeMethod
	public void preCondition()
	{
		commonMethods = new CommonMethods();
		flightFinderPage = new FlightFinderPage();
		selectFlightsPage = new SelectFlightsPage();
		bookFlightPage = new BookFlightPage();
		
		
		commonMethods.signOn(getProperty("username"), getProperty("password"));
		flightFinderPage.selectFlightDetails();
		flightFinderPage.clickButtonContinue();
		selectFlightsPage.scrollDown();
		selectFlightsPage.selectDepartFlight();
		selectFlightsPage.selectReturnFlight();
		selectFlightsPage.clickContinueButton();
		bookFlightPage.selectCreditCard(getProperty("card"));
		bookFlightPage.selectMeal(getProperty("meal"));
		bookFlightPage.selectCCExpiryMonth(getProperty("month"));
		bookFlightPage.selectCCExpiryYear(getProperty("year"));
		bookFlightPage.fillDetails("data");
		bookFlightPage.clickPurchaseButton();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("flightconfirmationpage.url")));
	}

	
	@Test(description="User should navigate back to Flight Finder page after clicking on Back To flights button")
	public void backToFlightsTest()
	{
		flightConfirmationPage = new FlightConfirmationPage();
		flightConfirmationPage.clickBackToHomeButton();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("backtohomepage.url")));
		
	}
	
	
	
	
	@AfterMethod
	public void postCondition()
	{
		commonMethods = new CommonMethods();
		commonMethods.signOff();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		getDriver().close();
	}
	
	
}
