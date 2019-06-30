package il.co.jb.ebay.auto.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.jb.ebay.auto.infra.config.MainConfig;
import il.co.jb.ebay.auto.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTest {
	
	protected ReportDispatcher report = ReportManager.getInstance();
	protected static WebDriver driver;

	@BeforeMethod
	public void beforeTest() throws IOException{
		
		MainConfig.initFromFile("src\\main\\resources\\config\\MainConfig.properties");
		
		if (driver == null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}
	}
	
	public void browseToUrl(String url) {
		report.log("Browse to url: "+url);
		driver.get(url);
	}
	
	/*@AfterMethod
	public void afterTest() {
		
		if (driver != null && MainConfig.closeBrowserAtTestEnd) {
			
			try {
				driver.close();
			}
			
			catch (Exception e) {
				
			}
		}
	}*/
	


	
	//hover:
	//Actions action = new Actions(webdriver);
	//WebElement we = webdriver.findElement(By.xpath("html/body/div[13]/ul/li[4]/a"));
	//action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("/expression-here"))).click().build().perform();
}
