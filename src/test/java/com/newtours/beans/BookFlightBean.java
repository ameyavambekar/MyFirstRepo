package com.newtours.beans;

import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;

public class BookFlightBean extends BaseFormDataBean {
	
	@UiElement(fieldLoc="input.creditcardnumber.bookflightpage")
	public String ccNumber;

	@UiElement(fieldLoc="input.firstname.bookflightpage")
	public String firstName;
	
	@UiElement(fieldLoc="input.lastname.bookflightpage")
	public String lastName;
	
	@UiElement(fieldLoc="input.ccfirstname.bookflightpage")
	public String ccFirstName;
	
	@UiElement(fieldLoc="input.cclastname.bookflightpage")
	public String ccLastName;
	
	@UiElement(fieldLoc="input.ccmiddlename.bookflightpage")
	public String ccMiddleName;
	
	@UiElement(fieldLoc="input.billaddressline1.bookflightpage")
	public String billAddressLine1;
	
	@UiElement(fieldLoc="input.billaddressline2.bookflightpage")
	public String billAddressLine2;
	
	@UiElement(fieldLoc="input.billcity.bookflightpage")
	public String billCity;
	
	@UiElement(fieldLoc="input.billstate.bookflightpage")
	public String billState;
	
	@UiElement(fieldLoc="input.billpostalcode.bookflightpage")
	public String billPostalCode;
	
	@UiElement(fieldLoc="input.deliveryaddressline1.bookflightpage")
	public String deliveryAddressLine1;
	
	@UiElement(fieldLoc="input.deliveryaddressline2.bookflightpage")
	public String deliveryAddressLine2;
	
	@UiElement(fieldLoc="input.deliverycity.bookflightpage")
	public String deliveryCity;
	
	@UiElement(fieldLoc="input.deliverystate.bookflightpage")
	public String deliveryState;
	
	@UiElement(fieldLoc="input.deliverypostalcode.bookflightpage")
	public String deliveryPostalCode;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCcFirstName() {
		return ccFirstName;
	}

	public String getCcLastName() {
		return ccLastName;
	}

	public String getCcMiddleName() {
		return ccMiddleName;
	}

	public String getBillAddressLine1() {
		return billAddressLine1;
	}

	public String getBillAddressLine2() {
		return billAddressLine2;
	}

	public String getBillCity() {
		return billCity;
	}

	public String getBillState() {
		return billState;
	}

	public String getBillPostalCode() {
		return billPostalCode;
	}

	public String getDeliveryAddressLine1() {
		return deliveryAddressLine1;
	}

	public String getDeliveryAddressLine2() {
		return deliveryAddressLine2;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public String getDeliveryPostalCode() {
		return deliveryPostalCode;
	}
	
	public String getCcNumber()
	{
		return ccNumber;
	}
	
	
	public void clearFields()
	{
		billAddressLine1="";
		billCity="";
		billState="";
		billPostalCode="";
		deliveryAddressLine1="";
		deliveryCity="";
		deliveryState="";
		deliveryPostalCode="";
	}
	
}
