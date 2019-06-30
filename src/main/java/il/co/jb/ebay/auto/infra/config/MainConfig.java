package il.co.jb.ebay.auto.infra.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import il.co.jb.ebay.auto.infra.web.WebDriverType;

public class MainConfig {
		
	public static WebDriverType webDriverType;
	public static boolean closeBrowserAtTestEnd;
	public static int webDriverImplicitWaitInSeconds;
	public static String baseUrl;
	public static String userId;
	public static String userPassword;
	
	public static void initFromFile(String filePath) throws IOException{
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(filePath);
		
		prop.load(input);
		
		webDriverType = WebDriverType.valueOf(prop.getProperty("webDriverType"));
		closeBrowserAtTestEnd = Boolean.valueOf(prop.getProperty("closeBrowserAtTestEnd"));
		webDriverImplicitWaitInSeconds = Integer.parseInt(prop.getProperty("webDriverImplicitWaitInSeconds"));
		baseUrl = prop.getProperty("baseUrl");
		userId = prop.getProperty("userId");
		userPassword = prop.getProperty("userPassword");
		
		input.close();
		
	}

}