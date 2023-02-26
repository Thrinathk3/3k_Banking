package com.bank_3k.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank_3k.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy (name="uid")
	WebElement userid;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (name="btnLogin")
	WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pwd) {
		userid.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		System.out.println("Login Success");
	}

}
