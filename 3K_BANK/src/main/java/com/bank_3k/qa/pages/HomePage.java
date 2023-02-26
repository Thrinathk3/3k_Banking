package com.bank_3k.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.bank_3k.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomaPageTitle()  {
		return driver.getTitle();
	}

}
