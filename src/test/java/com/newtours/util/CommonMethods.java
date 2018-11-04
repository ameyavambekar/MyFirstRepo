package com.newtours.util;

import org.hamcrest.Matchers;

import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.HomePage;
import com.newtours.pages.SignOnPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class CommonMethods extends WebDriverBaseTestPage<WebDriverTestPage> {

	public HomePage homePage;
	public SignOnPage signOnPage;
	public FlightFinderPage flightFinderPage;
	

	public  void signOn(String username,String password)
	{
		homePage = new HomePage();
		flightFinderPage = new FlightFinderPage();
		homePage.waitForPageToLoad();
		homePage.clickSingOnLink();
		signOnPage = new SignOnPage();
		Validator.verifyThat("User should land on Sign On Page", driver.getCurrentUrl(), Matchers.containsString(getProperty("signonpage")));
		signOnPage.enterUsername(username);
		signOnPage.enterPassword(password);
		signOnPage.clickButtonLogin();
		flightFinderPage.waitForPageToLoad();
		//Validator.verifyThat("User should land on flight finder page", driver.getCurrentUrl(), Matchers.equalTo(getProperty("flightfinderpage.url")));		
	}
	
	public void signOff()
	{
		homePage = new HomePage();
		homePage.getLinkSignOff().click();
	}
	
	public static String getProperty(String key)
	{
		return ConfigurationManager.getBundle().getString(key);
	}


	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
}
