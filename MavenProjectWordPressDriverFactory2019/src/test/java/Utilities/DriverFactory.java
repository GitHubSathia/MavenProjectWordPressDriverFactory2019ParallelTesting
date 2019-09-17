package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Config.Configuration;

public class DriverFactory {
	
	private DriverFactory()
	   {
	      //Do-nothing..Do not allow to initialize this class from outside
	   }
	   private static DriverFactory instance = new DriverFactory();

	   public static DriverFactory getInstance()
	   {
	      return instance;
	   }

	   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
	   {
	      @Override
	      protected WebDriver initialValue()
	      {
	    	  System.setProperty("webdriver.gecko.driver", "C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\BrowserDriverDownloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	          return new FirefoxDriver(); // can be replaced with other browser drivers
	    	 /* WebDriver browser=null;
	         if(Configuration.Browser.browser.equalsIgnoreCase("ff")) {
				   System.setProperty("webdriver.gecko.driver", "C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\BrowserDriverDownloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
				   browser= new FirefoxDriver();
			   }else if(Configuration.Browser.browser.equalsIgnoreCase("chrome")) {
				   System.setProperty("webdriver.chrome.driver", "C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\BrowserDriverDownloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
					 browser= new ChromeDriver();
			   }else if(Configuration.Browser.browser.equalsIgnoreCase("ie")) {
				   System.setProperty("webdriver.ie.driver", "C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\BrowserDriverDownloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
					browser= new InternetExplorerDriver();
			   }
			return browser;*/
	         
	                 
	      }
	   };

	   public WebDriver getDriver() // call this method to get the driver object and launch the browser
	   {
	      return driver.get();
	   }

	   public void removeDriver() // Quits the driver and closes the browser
	   {
	      driver.get().quit();
	      driver.remove();
	   }
}
