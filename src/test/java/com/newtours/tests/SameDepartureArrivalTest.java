package com.newtours.tests;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.HomePage;
import com.newtours.pages.SelectFlightsPage;
import com.newtours.pages.SignOnPage;
import com.newtours.util.CommonMethods;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class SameDepartureArrivalTest extends WebDriverTestCase {
	
	HomePage homePage;
	SignOnPage signOnPage;
	CommonMethods common;
	FlightFinderPage flightFinderPage;
	SelectFlightsPage selectFlightsPage;
	
	
	@BeforeClass
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
	}
	
	@QAFDataProvider(key="data.login")
	@Test(description="Select same arrival and departure cities")
	public void selectSameCityTest(Map<String,String> data)
	{
		homePage = new HomePage();
		signOnPage = new SignOnPage();
		common = new CommonMethods();
		flightFinderPage = new FlightFinderPage();
		selectFlightsPage = new SelectFlightsPage();
		
		homePage.clickSingOnLink();
		signOnPage.waitForPageToLoad();
		common.signOn(data.get("username"), data.get("password"));
		flightFinderPage.waitForPageToLoad();
		flightFinderPage.selectSameCity();
		flightFinderPage.clickButtonContinue();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("selectflightpage.url")));
		Validator.verifyTrue(selectFlightsPage.getTableArrival().isDisplayed(), "Arrival data is not displayed", "Arrival data is displayed");
		Validator.verifyTrue(selectFlightsPage.getTableDeparture().isDisplayed(), "Departure data is not dispalyed", "Departure data is displayed");
		
	}

}
