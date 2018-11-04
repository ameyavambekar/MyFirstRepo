package com.newtours.pages;


import static com.newtours.util.CommonMethods.*;
import org.openqa.selenium.JavascriptExecutor;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SelectFlightsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator="radiobutton.unifiedairlines563.selectflightspage")
	private QAFWebElement unifiedAirlines563;
	
	@FindBy(locator="radiobutton.blueskies651.selectflightspage")
	private QAFWebElement blueSkiesAirlines651;
	
	@FindBy(locator="button.continue.selectflightspage")
	private QAFWebElement buttonContinue;
	
	@FindBy(locator="table.departure.selectflightspage")
	private QAFWebElement tableDeparture;
	
	@FindBy(locator="table.arrival.selectflightspage")
	private QAFWebElement tableArrival;
	
	@FindBy(locator="text.depart.date.selectflightspage")
	private QAFWebElement departDatePast;
	
	@FindBy(locator="text.arrival.date.selectflightspage")
	private QAFWebElement arrivalDatePast;
	
	@FindBy(locator="text.arrival.future.selectflightspage")
	private QAFWebElement arrivalDateFuture;
	
	@FindBy(locator="text.depart.future.selectflightspage")
	private QAFWebElement departDateFuture;
	
	@FindBy(locator="text.depart.invalid.selectflightspage")
	private QAFWebElement departDateInvalid;
	
	@FindBy(locator="text.arrival.invalid.selectflightspage")
	private QAFWebElement arrivalDateInvalid;
	
	public QAFWebElement getDepartDatePast() {
		return departDatePast;
	}



	public QAFWebElement getArrivalDatePast() {
		return arrivalDatePast;
	}



	public QAFWebElement getTableDeparture() {
		return tableDeparture;
	}



	public QAFWebElement getTableArrival() {
		return tableArrival;
	}



	public QAFWebElement getUnifiedAirlines563() {
		return unifiedAirlines563;
	}



	public QAFWebElement getBlueSkiesAirlines651() {
		return blueSkiesAirlines651;
	}



	public QAFWebElement getButtonContinue() {
		return buttonContinue;
	}


	
	/*public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", buttonContinue);
	}*/
	
	
	
	public void selectReturnFlight()
	{
		QAFExtendedWebElement element = new QAFExtendedWebElement(String.format(getProperty("radiobutton.flight.selectflightspage"),getProperty("return.flight")));
		element.click();
	}
	
	public void clickContinueButton()
	{
		buttonContinue.click();
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	
	public void selectDepartFlight()
	{
		QAFExtendedWebElement element = new QAFExtendedWebElement(String.format(getProperty("radiobutton.flight.selectflightspage"),getProperty("depart.flight")));
		element.click();
	}
	
	
	public void verifyPastDates()
	{
		Validator.verifyTrue(departDatePast.getText().equals(getProperty("on.date.past")), "Depart flight dates are incorrect", "Depart flight dates are correct");
		Validator.verifyTrue(tableDeparture.isDisplayed(), "Departure flight details are not displayed", "Departure flight details are displayed");
		Validator.verifyTrue(arrivalDatePast.getText().equals(getProperty("return.date.past")),"Return flight dates are incorrect", "Return flight dates are correct");
		Validator.verifyTrue(tableArrival.isDisplayed(), "Return flight details are not displayed", "Return flight details are displayed");
	}

	
	public void verifyFutureDates()
	{
		Validator.verifyTrue(departDateFuture.getText().equals(getProperty("on.date.future")), "Depart flight dates are incorrect", "Depart flight dates are correct");
		Validator.verifyTrue(tableDeparture.isDisplayed(), "Departure flight details are not displayed", "Departure flight details are displayed");
		Validator.verifyTrue(arrivalDateFuture.getText().equals(getProperty("return.date.future")),"Return flight dates are incorrect", "Return flight dates are correct");
		Validator.verifyTrue(tableArrival.isDisplayed(), "Return flight details are not displayed", "Return flight details are displayed");
	}
	
	
	public void verifyInvalidDates()
	{
		Validator.verifyTrue(departDateInvalid.getText().equals(getProperty("on.date.invalid")), "Depart flight dates are incorrect", "Depart flight dates are correct");
		Validator.verifyTrue(tableDeparture.isDisplayed(), "Departure flight details are not displayed", "Departure flight details are displayed");
		Validator.verifyTrue(arrivalDateInvalid.getText().equals(getProperty("return.date.invalid")),"Return flight dates are incorrect", "Return flight dates are correct");
		Validator.verifyTrue(tableArrival.isDisplayed(), "Return flight details are not displayed", "Return flight details are displayed");
	}
	
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	
}
