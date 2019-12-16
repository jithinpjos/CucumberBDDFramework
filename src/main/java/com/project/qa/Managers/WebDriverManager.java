package com.project.qa.Managers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.project.qa.Enums.DriverType;
import com.project.qa.Enums.EnvironmentType;

public class WebDriverManager {
	 private WebDriver driver;
	 private static DriverType driverType;
	 private static EnvironmentType environmentType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	 private static final String FIREFOX_DRIVER_PROPERTY="webdriver.gecko.driver";
	 
	 public WebDriverManager() {
	 driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	 environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	 }
	 
	 public WebDriver getDriver() throws MalformedURLException {
	 if(driver == null) driver = createDriver();
	 return driver;
	 }
	 
	 private WebDriver createDriver() throws MalformedURLException {
	    switch (environmentType) {     
	         case LOCAL : driver = createLocalDriver();
	          break;
	         case REMOTE : driver = createRemoteDriver();
	          break;
	    }
	    return driver;
	 }
	 
	 private WebDriver createRemoteDriver() throws MalformedURLException {
		 String nodeURL=FileReaderManager.getInstance().getConfigReader().getnodeURL();
		 switch (driverType) {     
	        case FIREFOX : 
	        	 DesiredCapabilities capability=DesiredCapabilities.firefox();
	 	    	capability.setBrowserName("firefox");
	 	    	capability.setPlatform(Platform.ANY);
	 	    	driver=new RemoteWebDriver(new URL(nodeURL),capability);
	      break;
	        case CHROME : 
	        	 DesiredCapabilities capability_chrome=DesiredCapabilities.chrome();
	        	 capability_chrome.setBrowserName("chrome");
	        	 capability_chrome.setPlatform(Platform.ANY);
	 	    	driver=new RemoteWebDriver(new URL(nodeURL),capability_chrome);
	     break;
	     }
	    	return driver;
	 }
	 
	 private WebDriver createLocalDriver() {
	        switch (driverType) {     
	        case FIREFOX : 
	        System.setProperty(FIREFOX_DRIVER_PROPERTY,FileReaderManager.getInstance().getConfigReader().getDriverPath_Firefox());
	         driver = new FirefoxDriver();
	      break;
	        case CHROME : 
	         System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath_Chrome());
	         driver = new ChromeDriver();
	     break;
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	     break;
	        }
	 
	        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	 return driver;
	 } 
	 
	 public void closeDriver() {
	driver.close();
	/*	 try {
	            Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 driver.quit();*/
	 }

}
