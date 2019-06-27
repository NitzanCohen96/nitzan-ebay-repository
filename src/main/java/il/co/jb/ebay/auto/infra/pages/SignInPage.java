package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPage {
	
	private static final By helloTitle = By.id("GREET-HELLO");
	private static final By userIdField = By.id("userid");
	private static final By userPasswordField = By.id("pass");
	private static final By signInButton = By.id("sgnBt");
	
	public SignInPage (WebDriver driver) throws Exception {
		super(driver, helloTitle, userIdField, userPasswordField);
	}
	
	public void writeToUserIdField (String userId) {
		driver.findElement(userIdField).sendKeys(userId);
	}
	
	public void writeToPasswordField (String userPassword) {
		driver.findElement(userPasswordField).sendKeys(userPassword);
	}
	
	public EbayHomePage clickOnSignInButton() throws Exception {
		driver.findElement(signInButton).click();
		return new EbayHomePage(driver);
	}

}
