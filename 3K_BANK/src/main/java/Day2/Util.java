package Day2;

/*
 * Declare some common parameters for scripts
 * You can change them to adapt your environment
 *
 */

public class Util {
	
	public static final String FIREFOX_KEY = "webdriver.gecko.driver";
	/* You can change the Path of FireFox based on your environment here */
	public static final String FIREFOX_PATH = "./drivers/geckodriver.exe";
	
	// Setting Base URL
	public static final String BASE_URL = "http://www.demo.guru99.com/";
    
	// Time to wait when searching for a GUI element 
	public static final int WAIT_TIME = 30; 
											

	// Valid account for login
	public static final String USER_NAME = "mngr481080";
	public static final String PASSWD = "majevYp";


	// Expected output
	public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	

}
