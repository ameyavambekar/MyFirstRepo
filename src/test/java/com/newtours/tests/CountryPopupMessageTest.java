package com.newtours.tests;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newtours.pages.BookFlightPage;
import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.HomePage;
import com.newtours.pages.SelectFlightsPage;
import com.newtours.pages.SignOnPage;
import com.newtours.util.CommonMethods;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class CountryPopupMessageTest extends WebDriverTestCase {
	
	public SignOnPage signOnPage;
	public HomePage homePage;
	public FlightFinderPage flightFinderPage;
	public SelectFlightsPage selectFlightsPage;
	public BookFlightPage bookFlightPage;
	public CommonMethods commonMethods;
	
	
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
		
		
		commonMethods.signOn(getProperty("username"), getProperty("password"));
		flightFinderPage.selectFlightDetails();
		flightFinderPage.clickButtonContinue();
		selectFlightsPage.scrollDown();
		selectFlightsPage.selectDepartFlight();
		selectFlightsPage.selectReturnFlight();
		selectFlightsPage.clickContinueButton();
		//Validator.verifyThat("User landed on book flight page", getDriver().getCurrentUrl(), Matchers.equalTo("bookflightpage.url"));
	}
	

	@Test(description="If user selects any other country other than America, pop-up should be displayed")
	public void countryPopupMessageTest()
	{
		bookFlightPage = new BookFlightPage();
		bookFlightPage.fillDetails("data");
		bookFlightPage.selectCCExpiryMonth(getProperty("month"));
		bookFlightPage.selectCCExpiryYear(getProperty("year"));
		bookFlightPage.selectCreditCard(getProperty("card"));
		bookFlightPage.selectMeal(getProperty("meal"));
		
		
		try {
			bookFlightPage.selectBillCountry(getProperty("country"));
			bookFlightPage.selectDeliveryCountry(getProperty("country"));
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = getDriver().switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        Validator.verifyThat("Validate pop up Message", alertText, Matchers.equalTo("You have chosen a mailing location outside of the United States and its territories. An additional charge of $6.5 will be added as mailing charge."));
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}
		
	
		
		String billCountry = bookFlightPage.getSelectBillCountry().getText();
		String deliveryCountry = bookFlightPage.getSelectDeliveryCountry().getText();
		/*Validator.verifyThat(billCountry, Matchers.contains(billCountrygetProperty("country")));
		Validator.verifyThat(deliveryCountry, Matchers.contains(getProperty("country")));*/
		Validator.verifyTrue(billCountry.contains(getProperty("country")),"Chosen country is not selected","Chosen country is selected");
		Validator.verifyTrue(deliveryCountry.contains(getProperty("country")), "Chosen country is not selected","Chosen country is selected");
		//bookFlightPage.clickPurchaseButton();
		
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
