package il.co.jb.ebay.auto.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.jb.ebay.auto.infra.config.MainConfig;
import il.co.jb.ebay.auto.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTest {
	
	protected static ReportDispatcher report = ReportManager.getInstance();
	
	protected static WebDriver driver;

	@BeforeMethod
	public void beforeTest(){
		
		if (driver==null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}
	}

		
}
