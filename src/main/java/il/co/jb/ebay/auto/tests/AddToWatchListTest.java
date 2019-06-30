package il.co.jb.ebay.auto.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.infra.config.MainConfig;
import il.co.jb.ebay.auto.infra.pages.EbayHomePage;
import il.co.jb.ebay.auto.infra.pages.ProductPage;
import il.co.jb.ebay.auto.infra.pages.SearchResultsPage;
import il.co.jb.ebay.auto.infra.pages.SignInPage;

public class AddToWatchListTest extends AbstractTest {
	

	String searchTerm;
	
	@BeforeMethod // Pre step - open browser and login to user
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
	public void test_addToList() throws Exception {
		
		initListNameParams();
		
		//Step 1: Write a search term to search box, and click on 'search' button
		report.startLevel("Step 1: Write a search term to search box, and click on 'search' button");
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		
		ebayHomePage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = ebayHomePage.clickOnSearchButton();
		report.endLevel();
		
		//Step 2: Click on the first non sponsored item
		report.startLevel("Step 2: Click on the first non sponsored item");
		ProductPage productPage = searchResultsPage.clickOnItem();
		report.endLevel();
		
		//Step 3: Click on 'add to list' button
		report.startLevel("Step 3: Click on 'add to list' button");
		productPage.clickOnAddToListButton();
		report.endLevel();
		
		//Verify product has been added
		report.startLevel("Verify product has been added");
		String addedText = productPage.addedToWatchListTitle();
		Assert.assertEquals(addedText, "Added to your", "Wrong message");
		

	}
	
	
	private void initListNameParams() throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config/WatchListTestInfo.properties");

		prop.load(input);

		searchTerm = prop.getProperty(searchTerm);		
		input.close();
	}
}
