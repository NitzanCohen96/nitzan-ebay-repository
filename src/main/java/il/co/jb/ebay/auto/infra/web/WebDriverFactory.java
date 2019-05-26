package il.co.jb.ebay.auto.infra.web;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	public WebDriver getWebDriver(WebDriverType webDriverType) {
		
		WebDriver driver = null;
		
		switch(webDriverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
			break;
		case INTERNET_EXPLORER:
			break;
		}
		
		
		return driver;
	}
}
