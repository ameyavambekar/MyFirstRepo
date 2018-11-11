package com.newtours.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HotelsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator="text.underconstruction.hotelspage")
	private QAFWebElement textUnderConstruction;
	
	@FindBy(locator="button.backtohome.hotelspage")
	private QAFWebElement buttonBackToHome;
	
	
	
	public QAFWebElement getTextUnderConstruction() {
		return textUnderConstruction;
	}



	public QAFWebElement getButtonBackToHome() {
		return buttonBackToHome;
	}

	public void clickButtonBackToHome()
	{
		buttonBackToHome.click();
	}


	@Override
	protected void openPage(PageLocator locator, Object... args) {
		
		
	}

}
