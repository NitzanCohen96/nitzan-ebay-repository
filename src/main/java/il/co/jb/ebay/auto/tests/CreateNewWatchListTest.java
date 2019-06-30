package il.co.jb.ebay.auto.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.infra.config.MainConfig;
import il.co.jb.ebay.auto.infra.pages.CreateNewListPage;
import il.co.jb.ebay.auto.infra.pages.EbayHomePage;
import il.co.jb.ebay.auto.infra.pages.SignInPage;
import il.co.jb.ebay.auto.infra.pages.WatchListPage;

public class CreateNewWatchListTest extends AbstractTest{
	
	String listName;

public void openBrowserAndLogin() throws Exception {
		
		//Browse to ebay home page and init driver:
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);

		//Login to auto user:
		SignInPage signInPage = ebayHomePage.clickOnHomeSignInButton();
		signInPage.writeToUserIdField("aumat15");//I know it's hard coded, but this is the way it's not crashing
		signInPage.writeToPasswordField("QaTesting3105");//I know it's hard coded, but this is the way it's not crashing
		ebayHomePage = signInPage.clickOnSignInButton();
	}
	
	@Test
	public void test_createNewList () throws Exception {
		
		initListNameParams();
		
		//Step 1: click on 'me ebay' menu, and click on 'watch list'
		
		report.startLevel("Step 1: click on 'me ebay' menu, and click on 'watch list'");
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		
		ebayHomePage.hoverOnMyEbay();
		WatchListPage watchListPage = ebayHomePage.clickOnWatchList();
		report.endLevel();
		
		//Step 2: click on 'watch list', and click on 'create a new list'
		
		report.startLevel("Step 2: click on 'watch list', and click on 'create a new list'");
		watchListPage.clickOnWatchListButton();
		CreateNewListPage createNewListPage = watchListPage.createNewList();
		report.endLevel();
		
		//Step 3: Name the new list and click on 'create' button
		
		report.startLevel("Step 3: Name the new list and click on 'create' button");
		createNewListPage.InsertNewListName(listName);
		watchListPage =  createNewListPage.clickOnCreateNewListButton();
		report.endLevel();
		
		
		//Verify the new list has been added
		report.startLevel("Verify the new list has been added");
		String newListCreatedMessage = watchListPage.getListAddedMessage();
		
		Assert.assertEquals(newListCreatedMessage, listName+" created successfully.", "New list has not been created");
		report.endLevel();
		
		
	}
	
	private void initListNameParams() throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config/WatchListTestInfo.properties");

		prop.load(input);

		listName = prop.getProperty("listName");		
		input.close();
	}
	
}
