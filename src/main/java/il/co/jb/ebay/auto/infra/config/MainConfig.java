package il.co.jb.ebay.auto.infra.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public class MainConfig {
	
	protected static ReportDispatcher report = ReportManager.getInstance();

	@Test
	public void hi() {
	WebDriver driver = new ChromeDriver();
	}
	
	}