package il.co.jb.ebay.auto.tests.SearchTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.tests.AbstractTest;

public class BasicSearchTest extends AbstractTest {
	
	@Test
	public void test_1_BasicSearchTest() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		
		//Step 2: Write a random search term in the search bar and click on "search" button
		
		WebElement searchBox = driver.findElement(By.id("gh-ac"));
		
		WebElement searchButton = driver.findElement(By.id("gh-btn"));
		
		searchBox.sendKeys("iPhone");//Will be change to non hard coded
		searchButton.click();
	}

}
