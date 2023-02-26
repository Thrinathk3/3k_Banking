package com.bank_3k.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank_3k.qa.base.TestBase;

public class LoginsPage extends TestBase{
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	public LoginsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String login(String un, String pwd) {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
		return "Login Success";
	}
	public String invalidLogin(String un, String pwd) {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
		String msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return msg;
	}
	
}
