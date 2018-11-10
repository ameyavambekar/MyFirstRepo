package com.newtours.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CruisePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator="text.cruiserate.cruisepage")
	private QAFWebElement textCruiseRate;
	
	@FindBy(locator="text.cruiseitinerary.cruisepage")
	private QAFWebElement textCruiseItinerary;

	@FindBy(locator="link.acceptingreservations.cruisepage")
	private QAFWebElement linkAcceptingReservations;
	
	
	
	public QAFWebElement getLinkAcceptingReservations() {
		return linkAcceptingReservations;
	}


	public QAFWebElement getTextCruiseRate() {
		return textCruiseRate;
	}


	public QAFWebElement getTextCruiseItinerary() {
		return textCruiseItinerary;
	}

	
	public boolean verifyCruiseRate()
	{
		return textCruiseRate.isDisplayed();
	}
	
	
	public boolean verifyCruiseIninerary()
	{
		return textCruiseItinerary.isDisplayed();
	}

	public void clickAcceptingReservationsLink()
	{
		linkAcceptingReservations.click();
	}


	@Override
	protected void openPage(PageLocator locator, Object... args) {
		
		
	}

}
