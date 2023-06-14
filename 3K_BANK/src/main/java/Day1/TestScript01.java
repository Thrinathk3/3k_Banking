package Day1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * 
 * @author Krishna Rungta
 *        Test Script 01
 *        ************** 
 *        Test Steps
 *        1)  Go to http://www.demo.guru99.com/V4/
          2) Enter valid UserId
          3) Enter valid Password
          4) Click Login
 */

public class TestScript01 {



	public static void main(String[] args) throws Exception {	  

		//Setup Chrome driver    	
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://www.demo.guru99.com/V4/";

		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);


		// Enter username
		driver.findElement(By.name("uid")).sendKeys("mngr481080");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("majevYp");

		// Click Login
		driver.findElement(By.name("btnLogin")).click();
		
		

	}


}

