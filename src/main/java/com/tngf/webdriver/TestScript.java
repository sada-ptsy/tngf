/**
 * Derive all your classes from this class
 * this should be start of the script execution
 */
package com.tngf.webdriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
/**
 * @author sada
 *
 */
public class TestScript {
	public static WebDriver driver;

	//private static String URL = null;
	//private static String BROWSER = null;
	
	public WebDriver setUp(String HOST, String BROWSER) {
		IWebDriver driver1;
		try {
			driver1 = (IWebDriver) Class.forName(BROWSER).newInstance();
			driver = driver1.getWebdriver(HOST);
			driver.manage().window().maximize();
			return driver;
		} 
		catch (InstantiationException e) {
			return null;
		} 
		catch (IllegalAccessException e) {
			return null;
		} 
		catch (ClassNotFoundException e) {
			return null;
		}
		
	}
	
	
	@AfterClass
	public void cleanUp() {
		System.out.println("cleaning up");
		driver.quit();
	}
}
