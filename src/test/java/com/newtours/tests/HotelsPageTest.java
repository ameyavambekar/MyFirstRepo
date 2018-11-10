package com.newtours.tests;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.newtours.util.CommonMethods.getProperty;
import com.newtours.pages.HomePage;
import com.newtours.pages.HotelsPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class HotelsPageTest extends WebDriverTestCase {

	public HotelsPage hotelsPage;
	public HomePage homePage;
	
	@BeforeClass
	public void init()
	{
		getDriver().get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	
	@Test(description="Verify if hotels page is under construction")
	public void hotelsPageTest()
	{
		hotelsPage = new HotelsPage();
		homePage = new HomePage();
		
		homePage.clickHotelsLink();
		Validator.verifyTrue(hotelsPage.getTextUnderConstruction().verifyVisible(), "Text message is not visible", "Text message is visible");
		Validator.verifyTrue(hotelsPage.getButtonBackToHome().isDisplayed(), "Back to home button is not displayed", "Back to home button is displayed");
		hotelsPage.clickButtonBackToHome();
		Validator.verifyThat(getDriver().getCurrentUrl(), Matchers.equalTo(getProperty("backtohomepage.url")));
	}
	
	
	@AfterClass
	public void tearDown()
	{
		getDriver().close();
	}
	
}
