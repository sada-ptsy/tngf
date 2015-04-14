package com.tngf.webdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tngf.prop.InternetExplorerProps;


public class InternetExplorer implements IWebDriver {
	String hostName= StringUtils.EMPTY;
	WebDriver driver = null;
	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

	public WebDriver getWebdriver(String host) {
			System.out.println("Using IE browser on " + hostName);
			hostName = host;
			/*System.setProperty(InternetExplorerProps.getString("DRIVERNAME"), InternetExplorerProps.getString("DRIVER_EXECUTABLE")); 
			System.setProperty("webdriver.ie.driver.silent",InternetExplorerDriver.SILENT);
			System.setProperty(InternetExplorerProps.getString("DRIVER_LOGFILE"), InternetExplorerProps.getString("DRIVER_LOGFILE-LOCATION")); 
			*/
			/*driver = new InternetExplorerDriver(capabilities);
			driver.manage().deleteAllCookies();*/
			ieRemoteDriver();

		return driver;
	}
	
	 private void ieRemoteDriver(){
	    	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setJavascriptEnabled(true);
			ieCapabilities.setBrowserName("internet explorer"); 
			ieCapabilities.setPlatform(Platform.ANY);
			try{
				URL url = new URL("http",hostName, "/wd/hub" );
				driver = new RemoteWebDriver(url, ieCapabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			catch (MalformedURLException e) {
				System.out.println("Execution machine ip/port/path is incorrect");
			}
			catch(Exception e){
				 printError();
				// System.exit(1);
			}
	    }

	 
	 private static void printError(){
	    	System.out.println("--------------------------------------------------------------");
	    	System.out.println("[ERROR] Duh! Unable to reach Remote Selenium WebDriver");
	    	System.out.println("--------------------------------------------------------------");
 }

	 
	
}
