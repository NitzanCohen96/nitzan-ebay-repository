package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	
	protected WebDriver driver;
	protected By[] pageUniqueElements;
	
	public AbstractPage(WebDriver driver, By...pageUniqueElements) throws Exception {
		this.driver = driver;
		this.pageUniqueElements = pageUniqueElements;
		assertInPage();
	}
	
	public void assertInPage() throws Exception {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		
		try {
			for (By pageElement : pageUniqueElements) {
				webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pageElement));
			}
		}
		
		catch (TimeoutException exception){
			throw new Exception("Not on the expected page - " + this.getClass().getSimpleName());
		}
	}

}
