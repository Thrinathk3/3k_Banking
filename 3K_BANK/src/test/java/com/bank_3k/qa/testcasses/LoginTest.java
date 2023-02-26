package com.bank_3k.qa.testcasses;

import org.testng.annotations.*;

import com.bank_3k.qa.base.TestBase;
import com.bank_3k.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage loginPage;

	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	@Test
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
