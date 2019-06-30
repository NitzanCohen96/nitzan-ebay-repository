package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.ebay.auto.infra.web.By2;

public class WatchListPage extends AbstractPage{

	private static final By2 watchListButton = new By2 ("'Watchlist' button", By.xpath("//button[@class='m-middle-header__title']"));
	private static final By2 noItemsInWatchList = new By2 ("no item's message", By.xpath("//div[class='nsg-placeholder']"));
	private static final By2 listCreatesSuccessfullyMessage = new By2 ("list creates successfully'", By.xpath("//span[contains(text(),'created successfully')]"));
	private static final By2 createANewList = new By2 ("'create new list' button",By.xpath("//button[text()='Create a new list']"));
	
	public WatchListPage (WebDriver driver) throws Exception {
		super (driver, watchListButton);
	}
	
	public CreateNewListPage createNewList() throws Exception {
		bot.click(createANewList);
		return new CreateNewListPage(driver);
	}
	
	public void clickOnWatchListButton() {
		bot.click(watchListButton);
	}
	
	public String getListAddedMessage() {
		String listCreatesMessageText = bot.getElementText(listCreatesSuccessfullyMessage);
		return listCreatesMessageText;
	}
	

	
	
}
