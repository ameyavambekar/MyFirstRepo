package com.newtours.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.HomePage;
import com.newtours.pages.SelectFlightsPage;
import com.newtours.pages.SignOnPage;
import com.newtours.util.CommonMethods;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlightDatesTest extends WebDriverTestCase {

	HomePage homePage;
	SignOnPage signOnPage;
	FlightFinderPage flightFinderPage;
	SelectFlightsPage selectFlightsPage;
	CommonMethods common;
	
	@BeforeClass
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@QAFDataProvider(key="data")
	@Test(priority=1,enabled=true)
	public void pastDatesTest(Map<String,String> data)
	{
		homePage = new HomePage();
		signOnPage = new SignOnPage();
		flightFinderPage = new FlightFinderPage();
		selectFlightsPage = new SelectFlightsPage();
		common = new CommonMethods();
		
		homePage.clickSingOnLink();
		common.signOn(data.get("login.username"),data.get("login.password"));
		flightFinderPage.selectDates(data.get("dates.past.on-day"),data.get("dates.past.on-month"),data.get("dates.past.return-day"),data.get("dates.past.return-month"));
		flightFinderPage.clickButtonContinue();
		selectFlightsPage.waitForPageToLoad();
		selectFlightsPage.verifyPastDates();
		common.signOff();
	}
	
	
	@QAFDataProvider(key="data")
	@Test(priority=2,enabled=true)
	public void futureDatesTest(Map<String,String> data)
	{
		homePage = new HomePage();
		signOnPage = new SignOnPage();
		flightFinderPage = new FlightFinderPage();
		selectFlightsPage = new SelectFlightsPage();
		common = new CommonMethods();
		
		homePage.clickSingOnLink();
		common.signOn(data.get("login.username"),data.get("login.password"));
		flightFinderPage.selectDates(data.get("dates.future.on-day"),data.get("dates.future.on-month"),data.get("dates.future.return-day"),data.get("dates.future.return-month"));
		flightFinderPage.clickButtonContinue();
		selectFlightsPage.waitForPageToLoad();
		selectFlightsPage.verifyFutureDates();
		common.signOff();
	}
	
	@QAFDataProvider(key="data")
	@Test(priority=3,enabled=true)
	public void invalidDatesTest(Map<String,String> data)
	{
		homePage = new HomePage();
		signOnPage = new SignOnPage();
		flightFinderPage = new FlightFinderPage();
		selectFlightsPage = new SelectFlightsPage();
		common = new CommonMethods();
		
		homePage.clickSingOnLink();
		common.signOn(data.get("login.username"),data.get("login.password"));
		flightFinderPage.selectDates(data.get("dates.invalid.on-day"),data.get("dates.invalid.on-month"),data.get("dates.invalid.return-day"),data.get("dates.invalid.return-month"));
		flightFinderPage.clickButtonContinue();
		selectFlightsPage.waitForPageToLoad();
		selectFlightsPage.verifyInvalidDates();
		common.signOff();
	}
	
	
}
