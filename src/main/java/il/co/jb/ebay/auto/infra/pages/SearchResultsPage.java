package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.ebay.auto.infra.web.By2;

public class SearchResultsPage extends AbstractPage {
	

	private static final By2 firstNonSponsoredItemLink = new By2 ("Link to item", By.xpath("//li[@id='srp-river-results-listing2']//a[@class='s-item__link']"));

	public SearchResultsPage (WebDriver driver) throws Exception {
		super(driver);
	}
	
	public ProductPage clickOnItem() throws Exception {
		bot.click(firstNonSponsoredItemLink);
		return new ProductPage(driver);
	}
	
	
	

	
}
