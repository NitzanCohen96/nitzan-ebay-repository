package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.ebay.auto.infra.web.By2;

public class SignInPage extends AbstractPage {
	
	private static final By2 helloTitle = new By2 ("Hello title", By.id("GREET-HELLO"));
	private static final By2 userIdField = new By2 ("User id field",By.id("userid"));
	private static final By2 userPasswordField = new By2 ("User password field", By.id("pass"));
	private static final By2 signInButton = new By2 ("'sign in' button", By.id("sgnBt"));
	private static final By2 errorMessage = new By2 ("Error message",By.id("errf"));
	

	
	public SignInPage (WebDriver driver) throws Exception {
		super(driver, helloTitle, userIdField, userPasswordField);
	}
	
	public String writeToUserIdField (String userId) {
		bot.writeToElement(userIdField, userId);
		return userId;
		
	}

	public String writeToPasswordField (String userPassword) {
		bot.writeToElement(userPasswordField, userPassword);
		return userPassword;
	}
	
	public EbayHomePage clickOnSignInButton() throws Exception {
		bot.click(signInButton);
		return new EbayHomePage(driver);
	
	}
	
	public void clickOnSignInPageOnly() {
		bot.click(signInButton);
	}
	
	
	public String getErrorMessageText() {
		String errorMessageText = bot.getElementText(errorMessage);
		return errorMessageText;
	}
	


}
