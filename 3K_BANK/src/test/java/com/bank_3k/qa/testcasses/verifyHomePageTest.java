package com.bank_3k.qa.testcasses;

import org.testng.Assert;
import org.testng.annotations.*;

import com.bank_3k.qa.base.TestBase;
import com.bank_3k.qa.pages.HomePage;
import com.bank_3k.qa.pages.LoginPage;

public class verifyHomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public verifyHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void verifyHomepageTitleTest()  {
		String exp=homePage.verifyHomaPageTitle();
		Assert.assertEquals(exp, prop.getProperty("homepagetitle"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
