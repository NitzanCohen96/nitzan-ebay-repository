package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHomePage extends AbstractPage {
	
	protected static final By signInButton = By.xpath("//a[text()='Sign in']");
	//private static final By searchBox = By.id("gh-ac");
	//private static final By searchButton = By.id("gh-btn");

	public EbayHomePage (WebDriver driver) {
		super(driver, signInButton);
	}
	
}
