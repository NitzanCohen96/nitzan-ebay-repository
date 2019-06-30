package il.co.jb.ebay.auto.tests.SearchTests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.infra.config.MainConfig;
import il.co.jb.ebay.auto.infra.pages.EbayHomePage;
import il.co.jb.ebay.auto.infra.pages.SearchResultsPage;
import il.co.jb.ebay.auto.tests.AbstractTest;

public class BasicSearchTest extends AbstractTest {
	
	String searchTermBasic;
	String expectedWordInResult;
	
	@Test
	public void test_1_BasicSearchTest() throws Exception {
		
		initSearchTermsParams();
		
		//Step 1: Browse to e-bay home page
		report.startLevel("Step 1: Browse to e-bay home page");
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		report.endLevel();
		
		
		//Step 2: Write a random search term in the search bar and click on "search" button
		report.startLevel("Step 2: Write a random search term in the search bar and click on 'search' button");
		ebayHomePage.writeToSearchBox(searchTermBasic);
		SearchResultsPage searchResultsPage = ebayHomePage.clickOnSearchButton();
		report.endLevel();
		
		//Step 3: Verify that the first item is relevant to search term
		report.startLevel("Step 3: Verify that the first item is relevant to search term");
		expectedWordInResult = searchTermBasic;
		WebElement firstNonSponsoredResult = driver.findElement(By.id("srp-river-results-listing7"));
		String firstResultText = firstNonSponsoredResult.getText();
		
		Assert.assertTrue("The result doesn't contain: '"+ expectedWordInResult +"'", firstResultText.contains(expectedWordInResult));
		}
	

	
	private void initSearchTermsParams() throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config/SearchTestsInfo.properties");

		prop.load(input);

		searchTermBasic = prop.getProperty("searchTermBasic");		
		input.close();
	}
}
