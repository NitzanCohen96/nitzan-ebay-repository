package il.co.jb.ebay.auto.infra.web;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class ActionBot {
	
	private ReportDispatcher report = ReportManager.getInstance();
	private WebDriver driver;

	public ActionBot (WebDriver driver) {
		this.driver = driver;
	}

	public void click(By2 elementLocator) {
		report.log("Click on element: "+ elementLocator);
		WebElement element = driver.findElement(elementLocator.by);
		element.click();
	}

	public String getElementText(By2 elementLocator) {
		String text = driver.findElement(elementLocator.by).getText();
		report.log("Element: "+ elementLocator +" inner text: "+ text);
		return text;
	}

	public void writeToElement(By2 elementLocator, String text) {
		report.log("Write '"+ text + " ' to "+ elementLocator);
		WebElement element = driver.findElement(elementLocator.by);
		element.clear();
		element.sendKeys(text);
	}

	public boolean isElementDisplayed(By2 elementLocator) throws Exception {
		
		report.log("Check is "+ elementLocator+" is displayed");
		try {
			WebElement element = driver.findElement(elementLocator.by);
			return element.isDisplayed();
		}

		catch (NoSuchElementException exception) {
			return false;
		}
	}
	
	public void hoverOnElement (By2 elementLocator) {
		
		report.log("hover on element: " + elementLocator);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(elementLocator.by);
		action.moveToElement(element).build().perform();	
		
	}



}
