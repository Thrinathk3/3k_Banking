package com.bank_3k.qa.testcasses;

import org.testng.Assert;
import org.testng.annotations.*;

import com.bank_3k.qa.base.TestBase;
import com.bank_3k.qa.pages.LoginsPage;

public class LoginsTest extends TestBase{
	LoginsPage loginsPage;
	private  String msg;
	public LoginsTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginsPage = new LoginsPage();
	}
	
	@Test(priority=0)
	public void validLoginTest() {
		msg=loginsPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(msg, msg);
	}
	@Test(priority=1)
	public void invalidUseridLoginTest() {
		msg=loginsPage.invalidLogin(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(msg, prop.getProperty("loginfailedmsg"));
	}
	@Test(priority=2)
	public void invalidPasswordLoginTest() {
		msg=loginsPage.invalidLogin(prop.getProperty("username"), prop.getProperty("password1"));
		Assert.assertEquals(msg, prop.getProperty("loginfailedmsg"));
	}
	@Test(priority=3)
	public void invalidLoginTest() {
		msg=loginsPage.invalidLogin(prop.getProperty("username1"), prop.getProperty("password1"));
		Assert.assertEquals(msg, prop.getProperty("loginfailedmsg"));
	}
	
	@AfterMethod()
	public void teardown() {
		driver.close();
	}

}
