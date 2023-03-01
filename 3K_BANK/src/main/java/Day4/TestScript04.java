package Day4;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestScript04 {

	private WebDriver driver; // Selenium control driver
	private String baseUrl; // baseUrl of website Guru99

	/**
	 * create test data for testing The test data include set of username,
	 * password
	 * 
	 * @return
	 */
	@DataProvider(name = "GuruTest")
	public Object[][] testData() throws Exception {
		return Util.getDataFromExcel(Util.FILE_PATH, Util.SHEET_NAME,
				Util.TABLE_NAME);
	}

	
	@BeforeMethod
	public void setUp() throws Exception {

		System.setProperty("webdriver.gecko.driver",Util.FIREFOX_PATH);
		driver = new FirefoxDriver();

		// Setting Base URL of website Guru99
		baseUrl = Util.BASE_URL;
		driver.manage().timeouts()
				.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		// Go to http://www.demo.guru99.com/V4/
		driver.get(baseUrl + "/V4/");
	}

	/**
	 * Above test script executed several times for each set of data used in @DataProvider
	 * annotation. Any failed test does not impact other set of execution.
	 * 
	 * SS1: Enter valid userid & password 
	 * Expected: Login successful home page shown 
	 * SS2: Enter invalid userid & valid password 
	 * SS3: Enter valid userid & invalid password 
	 * SS4: Enter invalid userid & invalid password 
	 * Expected:
	 * A pop-up �User or Password is not valid� is shown
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */

	@Test(dataProvider = "GuruTest")
	public void testCase04(String username, String password) throws Exception {
		String actualTitle;
		String actualBoxMsg;
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();

		
	    try{ 
	    
	       	Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			 // Compare Error Text with Expected Error Value					
			Assert.assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
			
		}    
	    catch (NoAlertPresentException Ex){ 
	    	actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
	    	Assert.assertEquals(actualTitle,Util.EXPECT_TITLE);
        } 
	}

	/**
	 * Complete the testing
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}