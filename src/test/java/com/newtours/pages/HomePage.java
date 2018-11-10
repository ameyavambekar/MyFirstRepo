package com.newtours.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator="input.username.homepage")
	private QAFWebElement txtBoxUsername;
	
	@FindBy(locator="input.password.homepage")
	private QAFWebElement txtBoxPassword;
	
	@FindBy(locator="link.flights.homepage")
	private QAFWebElement linkFlights;
	
	@FindBy(locator="link.signon.homepage")
	private QAFWebElement linkSignOn;
	
	@FindBy(locator="link.signoff.homepage")
	private QAFWebElement linkSignOff;
	
	@FindBy(locator="link.hotels.homepage")
	private QAFWebElement linkHotels;
	
	@FindBy(locator="link.cruises.homepage")
	private QAFWebElement linkCruises;
	
	public QAFWebElement getLinkCruises()
	{
		return linkCruises;
	}
	
	public QAFWebElement getLinkHotels()
	{
		return linkHotels;
	}
	
	
	
	public QAFWebElement getLinkSignOff() {
		return linkSignOff;
	}




	public QAFWebElement getSignOn()
	{
		return linkSignOn;
	}
	
	
	
	
	public QAFWebElement getTxtBoxUsername() {
		return txtBoxUsername;
	}




	public QAFWebElement getTxtBoxPassword() {
		return txtBoxPassword;
	}




	public QAFWebElement getLinkFlights() {
		return linkFlights;
	}
	
	public void clickFlightsLink()
	{
		linkFlights.click();
	}

	public void clickCruisesLink()
	{
		linkCruises.click();
	}
	
	
	public void clickHotelsLink()
	{
		linkHotels.click();
	}

	public void clickSingOnLink()
	{
		linkSignOn.click();
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	
	

}
