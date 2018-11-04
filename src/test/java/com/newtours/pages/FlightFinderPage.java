package com.newtours.pages;
import static com.newtours.util.CommonMethods.getProperty;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FlightFinderPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator="radiobutton.roundtrip.flightfinderpage")
	private QAFWebElement radioBtnRoundTrip;
	
	@FindBy(locator="select.passengers.flightfinderpage")
	private QAFWebElement selectPassengers;
	
	@FindBy(locator="option.passengers.flightfinderpage")
	private List<QAFWebElement> optionPassenger;
	
	@FindBy(locator="select.departing.flightfinderpage")
	private QAFWebElement selectDepartingFrom;
	
	@FindBy(locator="option.departing.flightfinderpage")
	private List<QAFWebElement> departingCity;
	
	@FindBy(locator="select.frommonth.flightfinderpage")
	private QAFWebElement selectFromMonth;
	
	@FindBy(locator="option.frommonth.flightfinderpage")
	private List<QAFWebElement> fromMonth;
	
	@FindBy(locator="select.fromday.flightfinderpage")
	private QAFWebElement selectFromDay;
	
	@FindBy(locator="option.fromday.flightfinderpage")
	private List<QAFWebElement> fromDay;
	
	@FindBy(locator="select.arriving.flightfinderpage")
	private QAFWebElement selectArrivingTo;
	
	@FindBy(locator="option.arriving.flightfinderpage")
	private List<QAFWebElement> arrivingCity;
	
	@FindBy(locator="select.tomonth.flightfinderpage")
	private QAFWebElement selectToMonth;
	
	@FindBy(locator="option.tomonth.flightfinderpage")
	private List<QAFWebElement> toMonth;
	
	@FindBy(locator="select.today.flightfinderpage")
	private QAFWebElement selectToDay;
	
	@FindBy(locator="option.today.flightfinderpage")
	private List<QAFWebElement> toDay ;
	
	@FindBy(locator="button.continue.flightfinderpage")
	private QAFWebElement buttonContinue;

	public QAFWebElement getRadioBtnRoundTrip() {
		return radioBtnRoundTrip;
	}

	public QAFWebElement getSelectPassengers() {
		return selectPassengers;
	}

	public List<QAFWebElement> getOptionPassenger() {
		return optionPassenger;
	}

	public QAFWebElement getSelectDepartingFrom() {
		return selectDepartingFrom;
	}

	/*public QAFWebElement getOptionPortland() {
		return optionPortland;
	}*/

	public QAFWebElement getSelectFromMonth() {
		return selectFromMonth;
	}

	public List<QAFWebElement> getFromMonth() {
		return fromMonth;
	}

	public QAFWebElement getSelectFromDay() {
		return selectFromDay;
	}

	public List<QAFWebElement> getFromDay() {
		return fromDay;
	}

	public QAFWebElement getSelectArrivingTo() {
		return selectArrivingTo;
	}

	public List<QAFWebElement> getArrivingCity() {
		return arrivingCity;
	}

	public QAFWebElement getSelectToMonth() {
		return selectToMonth;
	}

	public List<QAFWebElement> getToMonth() {
		return toMonth;
	}
	
	public QAFWebElement getSelectToDay()
	{
		return selectToDay;
	}

	public List<QAFWebElement> getToDay() {
		return toDay;
	}


	public QAFWebElement getButtonContinue() {
		return buttonContinue;
	}

	
	public void selectFlightDetails()
	{
		if(!radioBtnRoundTrip.isEnabled())
			radioBtnRoundTrip.click();
		
		selectPassengers.click();
		for(QAFWebElement element:optionPassenger)
		{
			if(element.getText().equals(getProperty("passenger")))
				element.click();
		}
		selectDepartingFrom.click();
		for(QAFWebElement element:departingCity)
		{
			if(element.getText().equals(getProperty("city1")))
				element.click();
		}
		selectFromMonth.click();
		for(QAFWebElement element:fromMonth)
		{
			if(element.getText().equals(getProperty("month1")))
				element.click();
		}
		selectFromDay.click();
		for(QAFWebElement element:fromDay)
		{
			if(element.getText().equals(getProperty("day1")))
				element.click();
		}
		selectArrivingTo.click();
		for(QAFWebElement element:arrivingCity)
		{
			if(element.getText().equals(getProperty("city2")))
				element.click();
		}	
		selectToMonth.click();
		for(QAFWebElement element:toMonth)
		{
			if(element.getText().equals(getProperty("month2")))
				element.click();
		}
		selectToDay.click();
		for(QAFWebElement element:toDay)
		{
			if(element.getText().equals(getProperty("day2")))
				element.click();
		}
	}
	
	public void selectSameCity()
	{
		selectDepartingFrom.click();
		for(QAFWebElement element:departingCity)
		{
			if(element.getText().equals(getProperty("city3")))
				element.click();
		}
		
		selectArrivingTo.click();
		for(QAFWebElement element:arrivingCity)
		{
			if(element.getText().equals(getProperty("city3")))
				element.click();
		}
	}
	
	public void selectDates(String onDay,String onMonth,String returnDay,String returnMonth)
	{
	
		int integerReturnDay = Integer.parseInt(returnDay);
		returnDay = Integer.toString(integerReturnDay);
		System.out.println(returnDay);
		
		
		
		
		
		
		
		selectFromMonth.click();
		for(QAFWebElement element: fromMonth)
		{
			if(element.getText().equals(onMonth))
				element.click();
		}
		
		
		
		selectFromDay.click();
		for(QAFWebElement element: fromDay)
		{
			if(element.getText().equals(onDay))
				element.click();
		}
		
		selectToMonth.click();
		for(QAFWebElement element:toMonth)
		{
			if(element.getText().equals(returnMonth))
				element.click();
		}
		
		selectToDay.click();
		for(QAFWebElement element:toDay)
		{
		
			if(element.getText().equals(returnDay))
				element.click();
		}
	}
	
	public void clickButtonContinue()
	{
		buttonContinue.click();
	}
	
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		
	}
	
	
	
	
	

}
