package com.newtours.pages;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlightConfirmationPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator="text.departing.flightconfirmationpage")
	private QAFWebElement txtDeparting;
	
	@FindBy(locator="text.arrival.flightconfirmationpage")
	private QAFWebElement txtArrival;
	
	@FindBy(locator="text.passengers.flightconfirmationpage")
	private QAFWebElement txtPassengers;
	
	@FindBy(locator="text.billedto.flightconfirmationpage")
	private QAFWebElement txtBilledTo;
	
	@FindBy(locator="text.deliveryaddress.flightconfirmationpage")
	private QAFWebElement txtDeliveryAddress;
	
	@FindBy(locator="text.totaltaxes.flightconfirmationpage")
	private QAFWebElement txtTotalTaxes;
	
	@FindBy(locator="text.totalprice.flightconfirmationpage")
	private QAFWebElement txtTotalPrice;
	
	
	
	
	public QAFWebElement getTxtDeparting() {
		return txtDeparting;
	}




	public QAFWebElement getTxtArrival() {
		return txtArrival;
	}




	public QAFWebElement getTxtPassengers() {
		return txtPassengers;
	}




	public QAFWebElement getTxtBilledTo() {
		return txtBilledTo;
	}




	public QAFWebElement getTxtDeliveryAddress() {
		return txtDeliveryAddress;
	}




	public QAFWebElement getTxtTotalTaxes() {
		return txtTotalTaxes;
	}




	public QAFWebElement getTxtTotalPrice() {
		return txtTotalPrice;
	}



	public void verifyInvoice()
	{
		
		BookFlightPage bookFlight = new BookFlightPage();
		List<String> expectedDepart = new ArrayList<String>();
		List<String> expectedArrival = new ArrayList<String>();
		
		String departCities = getProperty("departure.cities");
		String departDate = getProperty("departure.date");
		String departFlight = getProperty("departure.flight");
		String departClass = getProperty("departure.class");
		String departPrice = getProperty("departure.price");
		String arrivalCities = getProperty("arrival.cities");
		String arrivalDate = getProperty("arrival.date");
		String arrivalFlight = getProperty("arrival.flight");
		String arrivalClass = getProperty("arrival.class");
		String arrivalPrice = getProperty("arrival.price");
		String passenger = getProperty("passengers");
		String addressLine1 = getProperty("data.billAddressLine1");
		String addressLine2 = getProperty("data.billAddressLine2");
		String fname = getProperty("data.ccFirstName");
		String lname = getProperty("data.ccLastName");
		String mname = getProperty("data.ccMiddleName");
		String city = getProperty("data.billCity");
		String state = getProperty("data.billState");
		String postalCode = getProperty("data.billPostalCode");
		String totalPrice = getProperty("total.price");
		String totalTax = getProperty("taxes");
		
		expectedDepart.add(departCities);
		expectedDepart.add(departDate);
		expectedDepart.add(departFlight);
		expectedDepart.add(departClass);
		expectedDepart.add(departPrice);
		
		expectedArrival.add(arrivalPrice);
		expectedArrival.add(arrivalCities);
		expectedArrival.add(arrivalDate);
		expectedArrival.add(arrivalClass);
		expectedArrival.add(arrivalFlight);
		
		String actualDepart = txtDeparting.getText();
		String actualArrival = txtArrival.getText();
		
		
		
		
		for(int i=0;i<expectedDepart.size();i++)
		{
			Validator.verifyTrue(actualDepart.contains(expectedDepart.get(i)), "Departure details are incorrect", "Departure details are correct");
			Validator.verifyTrue(actualArrival.contains(expectedArrival.get(i)), "Arrival details are incorrect", "Arrival details are correct");
		}
		
		Validator.verifyTrue(txtPassengers.getText().contains(passenger), "No of passengers is incorrect", "No of passengers is correct");
		
		Validator.verifyTrue(txtBilledTo.getText().contains(addressLine1)&&txtBilledTo.getText().contains(addressLine2), "Billing address is incorrect", "Billing address is correct");
		
		Validator.verifyTrue(txtTotalTaxes.getText().contains(totalTax),"Total tax is incorrect","Total tax is correct");
		Validator.verifyTrue(txtTotalPrice.getText().contains(totalPrice), "Total price is incorrect", "Total price is correct");
		
		
	}
	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	

	
	
	
}
