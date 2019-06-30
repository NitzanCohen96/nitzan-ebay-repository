package il.co.jb.ebay.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.ebay.auto.infra.web.By2;

public class CreateNewListPage extends AbstractPage {
	
	private static final By2 createNewListTitle = new By2 ("Window title",By.id("dialog-title-CREATE_LIST_TEMPLATE"));
	private static final By2 newListName = new By2 ("'New list' name field", By.id("listName"));
	private static final By2 createNewListButton = new By2 ("'Create' button", By.xpath("//button[@aria-describedby='dialog-action-CREATE_LIST_TEMPLATE']"));
	

	public CreateNewListPage (WebDriver driver) throws Exception {
		super(driver, createNewListTitle);
	}

	public void InsertNewListName (String listName) {
		bot.writeToElement(newListName, listName);
	}
	
	public WatchListPage clickOnCreateNewListButton() throws Exception {
		bot.click(createNewListButton);
		return new WatchListPage(driver);
	}
}
