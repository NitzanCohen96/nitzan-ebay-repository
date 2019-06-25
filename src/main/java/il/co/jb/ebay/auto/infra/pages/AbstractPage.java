package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	
	protected WebDriver driver;
	protected By[] pageUniqueElements;
	
	public AbstractPage(WebDriver driver, By...pageUniqueElements) {
		this.driver = driver;
		this.pageUniqueElements = pageUniqueElements;
		assertInPage();
	}
	
	public void assertInPage() {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		
	}

}
