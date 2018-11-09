package com.newtours.tests;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class FlightFinderTest extends WebDriverTestCase {
	
	public  FlightFinderPage flightFinderPage;
	public  HomePage homePage;
	public  SignOnPage signOnPage;
	public  SelectFlightsPage selectFlightsPage;
	public BookFlightPage bookFlightPage; 
	public FlightConfirmationPage confirmationPage;
	public CommonMethods commonMethods;
	
	@BeforeClass
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	
	
	@QAFDataProvider(key="data.login")
	@Test(description="Enter Flight details on flight finder page",priority=2)
	public void enterFlightDetails(Map<String,String> data)
	{
		commonMethods = new CommonMethods();
		flightFinderPage = new FlightFinderPage();
		commonMethods.signOn(data.get("username"),data.get("password"));
		flightFinderPage.selectFlightDetails();
		flightFinderPage.clickButtonContinue();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("selectflightpage.url")));
		
	}
	
	@Test(dependsOnMethods="enterFlightDetails",description="Select departure and arrival flights")
	public void selectFlight()
	{
		selectFlightsPage = new SelectFlightsPage();
		selectFlightsPage.scrollDown();
		selectFlightsPage.selectDepartFlight();
		selectFlightsPage.selectReturnFlight();
		selectFlightsPage.clickContinueButton();
		Validator.verifyThat("User should be on Book Flight Page", getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("bookflightpage.url")));
	}

	
	@Test(dependsOnMethods="selectFlight",description="Enter booking details")
	public void bookFlight()
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
		
	}
	
	@Test(dependsOnMethods="bookFlight",description="Confirm booking details")
	public void confirmFlight()
	{
		confirmationPage = new FlightConfirmationPage();
		confirmationPage.verifyInvoice();
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		getDriver().close();
	}
	
}
