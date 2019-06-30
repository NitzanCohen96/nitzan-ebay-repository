package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import il.co.jb.ebay.auto.infra.web.By2;

public class EbayHomePage extends AbstractPage {
	
	public static final By2 homeSignInButton = new By2 ("'sign in' button in home page", By.xpath("//a[text()='Sign in']"));
	private static final By2 searchBox = new By2 ("Search box at home page", By.id("gh-ac"));
	private static final By2 searchButton = new By2 ("'Search' button", By.id("gh-btn"));
	private static final By2 myEbayLink = new By2 ("'myEbay' menu", By.id("gh-eb-My"));
	private static final By2 watchListButton = new By2 ("'watch list' button", By.xpath("//a[@href='https://www.ebay.com/myb/WatchList']"));
	private static final By2 autoPlayScreen = new By2 ("Information scrren with site's options", By.className("carousel__container"));
	private static final By2 hiUserFirstName = new By2 ("'Hi' + first user name ", By.id("gh-ug"));
	
	public EbayHomePage (WebDriver driver) throws Exception {
		super(driver, searchBox, autoPlayScreen);
	}
	
	public void writeToSearchBox (String searchTerm) {
		bot.writeToElement(searchBox, searchTerm);
	}
	
	public SignInPage clickOnHomeSignInButton () throws Exception {
		bot.click(homeSignInButton);
		return new SignInPage(driver);
	}
	
	public SearchResultsPage clickOnSearchButton () throws Exception {
		bot.click(searchButton);
		return new SearchResultsPage(driver);
	}
	
	public boolean isHiUserFirstNameVisible() {	
		try {
			 WebElement element = driver.findElement(hiUserFirstName.by);
			 return element.isDisplayed();
		}
		
		catch (NoSuchElementException exception) {
			return false;
		}
	}
	
	public boolean isHomeSignInButtonVisible() {
		
		try {
			driver.findElement(homeSignInButton.by);
			return true;
		}
		catch (NoSuchElementException exception) {
			return false;
		}
	}
	public void hoverOnMyEbay() {
		report.log("hover on element: "+ myEbayLink);
		bot.hoverOnElement(myEbayLink);
	}
	
	public WatchListPage clickOnWatchList() throws Exception {
		report.log("hover on: "+ myEbayLink);
		bot.hoverOnElement(myEbayLink);
		
		report.log("click on: "+ watchListButton);
		bot.click(watchListButton);
		return new WatchListPage(driver);
		
	}

}
