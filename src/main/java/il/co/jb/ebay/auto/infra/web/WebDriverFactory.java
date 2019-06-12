package il.co.jb.ebay.auto.infra.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import il.co.jb.ebay.auto.infra.config.MainConfig;

public class WebDriverFactory {
	
	public static WebDriver getWebDriver(WebDriverType webDriverType) {
		
		WebDriver driver = null;
		
		switch(webDriverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case INTERNET_EXPLORER:
			System.setProperty("webdriver.ie.driver", "webDrivers/IEDriverService.exe");
			driver = new InternetExplorerDriver();	
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(MainConfig.webDriverImplicitWaitInSeconds, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
}
