package suite.sanity;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tngf.webdriver.TestScript;
//Add Comment for iss90
//
//Chenaged for BrNewBranch
public class LoginVerification extends TestScript {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void set(String browser) throws MalformedURLException {
		 driver = this.setUp("localhost:4444",browser);
	}

	@Test
	@Parameters({ "username", "password" })
	public void loginCheck(String userName, String password) throws Exception {
		driver.get("http://www.google.com");
		Thread.sleep(5000);
	}
	
}
