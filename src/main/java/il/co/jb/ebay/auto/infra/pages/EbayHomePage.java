package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHomePage extends AbstractPage {
	
	public static final By homeSignInButton = By.xpath("//a[text()='Sign in']");
	private static final By searchBox = By.id("gh-ac");
	private static final By searchButton = By.id("gh-btn");
	private static final By autoPlayScreen = By.className("carousel__container");
	private static final By hiUserFirstName = By.id("gh-ug");
	
	public EbayHomePage (WebDriver driver) throws Exception {
		super(driver, searchBox, autoPlayScreen);
	}
	
	public void writeToSearchBox (String searchTerm) {
		driver.findElement(searchBox).sendKeys(searchTerm);
	}
	
	public SignInPage clickOnHomeSignInButton () throws Exception {
		driver.findElement(homeSignInButton).click();
		return new SignInPage(driver);
	}
	
	public SearchResultsPage clickOnSearchButton () throws Exception {
		driver.findElement(searchButton).click();
		return new SearchResultsPage(driver);
	}
	
	public boolean isHiUserFirstNameVisible() {
		
		try {
			WebeElement driver.findElement(hiUserFirstName)
			return hiUserFirstName.isDisplayed();
		}
		
		catch{
			
		}
	}

}
