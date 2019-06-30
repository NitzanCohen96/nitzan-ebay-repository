package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.ebay.auto.infra.web.By2;

public class ProductPage extends AbstractPage {
	
	
	private static final By2 addToListButton = new By2 ("'Add to watch list' button", By.className("default small primary"));
	private static final By2 addToCartButton = new By2 ("'Add to cart' button", By.id("isCartBtn_btn"));
	private static final By2 addedToWatchList = new By2 ("'Added to your watch list' title", By.id("w1-6-_lmsg"));
	private static final By2 watchListLink = new By2 ("", By.xpath("//span//a[text()='Watch list']"));

	public ProductPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void clickOnAddToListButton() {
		bot.click(addToListButton);
	}
	
	public String addedToWatchListTitle() {
		String addedText = bot.getElementText(addedToWatchList);
		return addedText;
	}
	public WatchListPage clickOnWatchListLink() throws Exception{
		bot.click(watchListLink);
		return new WatchListPage(driver);
	}
	
	
}
