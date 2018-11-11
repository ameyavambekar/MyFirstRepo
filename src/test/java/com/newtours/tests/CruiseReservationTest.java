package com.newtours.tests;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.pages.CruisePage;
import com.newtours.pages.HomePage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class CruiseReservationTest extends WebDriverTestCase {
	
	public HomePage homePage;
	public CruisePage cruisePage;
	
	@BeforeClass
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	
	@Test(description="Verifying Cruise Reservation Page")
	public void cruiseReservationTest()
	{
		homePage = new HomePage();
		cruisePage = new CruisePage();
		
		homePage.clickCruisesLink();
		Validator.verifyTrue(cruisePage.verifyCruiseRate(), "Cruise rate is not displayed", "Cruise rate is displayed");
		Validator.verifyTrue(cruisePage.verifyCruiseIninerary(), "Cruise itinerary is not displayed", "Cruise itinerary is displayed");
		cruisePage.clickAcceptingReservationsLink();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("homepage.nowacceptingreservations.url")));
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		getDriver().close();
	}

}
