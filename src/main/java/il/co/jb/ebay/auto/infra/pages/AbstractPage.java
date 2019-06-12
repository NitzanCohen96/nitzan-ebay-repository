package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

}
