package com.newtours.pages;

import static com.newtours.util.CommonMethods.getProperty;

import java.util.List;

import org.hamcrest.Matchers;

import com.newtours.beans.BookFlightBean;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class BookFlightPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	
	BookFlightBean bean = new BookFlightBean();

	@FindBy(locator="button.purchase.bookflightpage")
	private QAFWebElement btnPurchase;
	
	@FindBy(locator="summary.depart.bookflightpage")
	private QAFWebElement txtDepart;
	
	@FindBy(locator="summary.departdate.bookflightpage")
	private QAFWebElement txtDepartDate;
	
	@FindBy(locator="summary.departflight.bookflightpage")
	private QAFWebElement txtDepartFlight;
	
	@FindBy(locator="summary.departclass.bookflightpage")
	private QAFWebElement txtDepartClass;
	
	@FindBy(locator="summary.departprice.bookflightpage")
	private QAFWebElement txtDepartPrice;
	
	@FindBy(locator="summary.arrival.bookflightpage")
	private QAFWebElement txtArrival;
	
	@FindBy(locator="summary.arrivaldate.bookflightpage")
	private QAFWebElement txtArrivalDate;
	
	@FindBy(locator="summary.arrivalflight.bookflightpage")
	private QAFWebElement txtArrivalFlight;
	
	@FindBy(locator="summary.arrivalclass.bookflightpage")
	private QAFWebElement txtArrivalClass;
	
	@FindBy(locator="summary.arrivalprice.bookflightpage")
	private QAFWebElement txtArrivalPrice;
	
	@FindBy(locator="summary.passengers.bookflightpage")
	private QAFWebElement txtPassengers;
	
	@FindBy(locator="summary.taxes.bookflightpage")
	private QAFWebElement txtTaxes;
	
	@FindBy(locator="summary.total.bookflightpage")
	private QAFWebElement txtTotal;
	
	@FindBy(locator="select.meal.bookflightpage")
	private QAFWebElement selectMeal;
	
	@FindBy(locator="option.meal.bookflightpage")
	private List<QAFWebElement> listMeal;
	
	@FindBy(locator="select.creditcardtype.bookflightpage")
	private QAFWebElement selectCreditCard;
	
	@FindBy(locator="option.creditcardtype.bookflightpage")
	private List<QAFWebElement> listCreditCard;
	
	@FindBy(locator="select.monthccexpiry.bookflightpage")
	private QAFWebElement selectCCExpiryMonth;
	
	@FindBy(locator="option.monthccexpiry.bookflightpage")
	private List<QAFWebElement> listCCExpiryMonth;
	
	@FindBy(locator="select.yearccexpiry.bookflightpage")
	private QAFWebElement selectCCExpiryYear;
	
	@FindBy(locator="option.yearccexpiry.bookflightpage")
	private List<QAFWebElement> listCCExpiryYear;
	
	@FindBy(locator="select.billcountry.bookflightpage")
	private QAFWebElement selectBillCountry;
	
	@FindBy(locator="option.billcountry.bookflightpage")
	private List<QAFWebElement> listBillCountry;
	
	@FindBy(locator="select.deliverycountry.bookflightpage")
	private QAFWebElement selectDeliveryCountry;
	
	@FindBy(locator="option.deliverycountry.bookflightpage")
	private List<QAFWebElement> listDeliveryCountry;
	
	
	
	
	public QAFWebElement getTxtDepart() {
		return txtDepart;
	}


	public QAFWebElement getTxtDepartDate() {
		return txtDepartDate;
	}


	public QAFWebElement getTxtDepartFlight() {
		return txtDepartFlight;
	}


	public QAFWebElement getTxtDepartClass() {
		return txtDepartClass;
	}


	public QAFWebElement getTxtDepartPrice() {
		return txtDepartPrice;
	}


	public QAFWebElement getTxtArrival() {
		return txtArrival;
	}


	public QAFWebElement getTxtArrivalDate() {
		return txtArrivalDate;
	}


	public QAFWebElement getTxtArrivalFlight() {
		return txtArrivalFlight;
	}


	public QAFWebElement getTxtArrivalClass() {
		return txtArrivalClass;
	}


	public QAFWebElement getTxtArrivalPrice() {
		return txtArrivalPrice;
	}


	public QAFWebElement getTxtPassengers() {
		return txtPassengers;
	}


	public QAFWebElement getTxtTaxes() {
		return txtTaxes;
	}


	public QAFWebElement getTxtTotal() {
		return txtTotal;
	}


	public QAFWebElement getSelectMeal() {
		return selectMeal;
	}


	public List<QAFWebElement> getListMeal() {
		return listMeal;
	}


	public QAFWebElement getSelectCreditCard() {
		return selectCreditCard;
	}


	public List<QAFWebElement> getListCreditCard() {
		return listCreditCard;
	}


	public QAFWebElement getSelectCCExpiryMonth() {
		return selectCCExpiryMonth;
	}


	public List<QAFWebElement> getListCCExpiryMonth() {
		return listCCExpiryMonth;
	}


	public QAFWebElement getSelectCCExpiryYear() {
		return selectCCExpiryYear;
	}


	public List<QAFWebElement> getListCCExpiryYear() {
		return listCCExpiryYear;
	}


	public QAFWebElement getSelectBillCountry() {
		return selectBillCountry;
	}


	public List<QAFWebElement> getListBillCountry() {
		return listBillCountry;
	}


	public QAFWebElement getSelectDeliveryCountry() {
		return selectDeliveryCountry;
	}


	public List<QAFWebElement> getListDeliveryCountry() {
		return listDeliveryCountry;
	}


	public void verifySummary()
	{
		Validator.verifyThat("Verify Departure Cities",txtDepart.getText()  , Matchers.equalTo(getProperty("departure.cities")));
		Validator.verifyThat("Verify Departure Dates", txtDepartDate.getText()  , Matchers.equalTo(getProperty("departure.date")));
		Validator.verifyThat("Verfiy Departure Flight",txtDepartFlight.getText() , Matchers.equalTo(getProperty("departure.flight")));
		Validator.verifyThat("Verify Departure Class", txtDepartClass.getText() , Matchers.equalTo(getProperty("departure.class")));
		Validator.verifyThat("Verify Departure ticket Price",txtDepartPrice.getText()  ,Matchers.equalTo(getProperty("departure.price")));
		Validator.verifyThat("Verify Arrival Cities",txtArrival.getText() , Matchers.equalTo(getProperty("arrival.cities")));
		Validator.verifyThat("Verify Arrival Date",txtArrivalDate.getText() , Matchers.equalTo(getProperty("arrival.date")));
		Validator.verifyThat("Verify Arrival Class",txtArrivalClass.getText() , Matchers.equalTo(getProperty("arrival.class")));
		Validator.verifyThat("Verify Arrival ticket Price",txtArrivalPrice.getText()  , Matchers.equalTo(getProperty("arrival.price")));
		Validator.verifyThat("Verify number of Passengers ",txtPassengers.getText() , Matchers.equalTo(getProperty("passengers")));
		Validator.verifyThat("Verify Tax",txtTaxes.getText()  , Matchers.equalTo(getProperty("taxes")));
		Validator.verifyThat("Verify total Price",txtTotal.getText(), Matchers.equalTo(getProperty("total.price")));
	}
	
	
	public void clickSubmit()
	{
		
	}
	
	
	public void selectMeal(String meal)
	{
		selectMeal.click();
		for(QAFWebElement element:listMeal)
		{
			if(element.getText().equals(meal))
			{
				element.click();
			}
		}
	}
	
	public void selectCreditCard(String card)
	{
		selectCreditCard.click();
		for(QAFWebElement element:listCreditCard)
		{
			if(element.getText().equals(card))
				element.click();
		}
	}
	
	public void selectCCExpiryMonth(String month)
	{
		selectCCExpiryMonth.click();
		for(QAFWebElement element:listCCExpiryMonth)
		{
			System.out.println(element.getText());
			if(element.getText().contains(month))
				element.click();
		}
	}
	
	public void selectCCExpiryYear(String year)
	{
		selectCCExpiryYear.click();
		for(QAFWebElement element:listCCExpiryYear)
		{
			if(element.getText().contains(year))
				element.click();
		}
	}
	
	
	public void clickPurchaseButton()
	{
		btnPurchase.click();
	}
	
	public void selectBillCountry(String country)
	{
		selectBillCountry.click();
		for(QAFWebElement element:listBillCountry)
		{
			if(element.getText().equals(country))
				element.click();
		}
	}
	
	
	public void selectDeliveryCountry(String country)
	{
		selectDeliveryCountry.click();
		for(QAFWebElement element:listDeliveryCountry)
		{
			if(element.getText().equals(country))
				element.click();
		}
	}
	
	public void fillDetails()
	{
		bean.clearFields();
		bean.fillFromConfig("data");
		bean.fillUiElements();
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	
	

}
