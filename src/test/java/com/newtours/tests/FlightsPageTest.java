package com.newtours.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.newtours.util.CommonMethods.*;
import com.newtours.pages.HomePage;
import com.newtours.pages.SignOnPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class FlightsPageTest extends WebDriverTestCase {
	
	HomePage homePage;
	SignOnPage signOnPage;
	
	@BeforeTest
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
	}
	
	@Test(description="Verify without logging in, user cannot go to Flights Page",priority = 1,groups="functional")
	public void flightsLinkTest()
	{	
		
		homePage = new HomePage();
		signOnPage = new SignOnPage();
		//precondition
		Validator.verifyThat("User is on homepage", getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("homepage.url")));
		homePage.clickFlightsLink();
		QAFTestBase.pause(1000);
		Validator.verifyThat("User is on signonpage",getDriver().getCurrentUrl(),Matchers.equalTo(getProperty("signonpage.url")));		
	}
	
	@AfterTest
	public void tearDown()
	{
		getDriver().close();
	}

}
