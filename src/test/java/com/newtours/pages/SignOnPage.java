package com.newtours.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SignOnPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator="input.username.signonpage")
	private QAFWebElement username;
	
	@FindBy(locator="input.password.signonpage")
	private QAFWebElement password;
	
	@FindBy(locator="button.login.signonpage")
	private QAFWebElement buttonLogin;
	
	
	
	public QAFWebElement getUsername() {
		return username;
	}



	public QAFWebElement getPassword() {
		return password;
	}



	public QAFWebElement getButtonLogin() {
		return buttonLogin;
	}

	
	public void enterUsername(String username1)
	{
		username.sendKeys(username1);
	}
	
	public void enterPassword(String password1)
	{
		password.sendKeys(password1);
	}

	public void clickButtonLogin()
	{
		buttonLogin.click();
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	
	

}
