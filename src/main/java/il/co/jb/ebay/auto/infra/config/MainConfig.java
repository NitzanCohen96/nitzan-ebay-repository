package il.co.jb.ebay.auto.infra.config;

import il.co.jb.ebay.auto.infra.web.WebDriverType;

public class MainConfig {
		
	public static WebDriverType webDriverType = WebDriverType.CHROME;
	public static boolean closeBrowserAtTestEnd;
	public static int webDriverImplicitWaitInSeconds;

	
	}