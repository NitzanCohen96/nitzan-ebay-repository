package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.jb.ebay.auto.infra.web.ActionBot;
import il.co.jb.ebay.auto.infra.web.By2;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public abstract class AbstractPage {
	
	protected ReportDispatcher report = ReportManager.getInstance();
	protected WebDriver driver;
	protected By2[] pageUniqueElements;
	protected ActionBot bot;
	
	public AbstractPage(WebDriver driver, By2...pageUniqueElements) throws Exception {
		this.driver = driver;
		this.bot = new ActionBot(driver);
		this.pageUniqueElements = pageUniqueElements;
		assertInPage();
	}
	
	public void assertInPage() throws Exception {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		
		try {
			for (By2 pageElement : pageUniqueElements) {
				webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pageElement.by));
			}
			report.log("*** On page: "+ this.getClass().getSimpleName());
		}
		
		catch (TimeoutException exception){
			throw new Exception("Not on the expected page - " + this.getClass().getSimpleName() + "\n" + exception.getMessage());
		}
	}

}
