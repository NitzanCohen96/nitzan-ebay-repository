package il.co.jb.ebay.auto.tests.SearchTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.tests.AbstractTest;

public class SaveThisSearchButton extends AbstractTest {
	
	@Test
	public void test_2_SaveThisSearchButon() {
	
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: Write at the top search bar the value "computer" and click on search button	
		WebElement searchBox = driver.findElement(By.id("gh-ac"));
		WebElement searchButton = driver.findElement(By.id("gh-btn"));
		
		searchBox.sendKeys("computer");
		searchButton.click();
		
		//Step 3: Click on the heart icon for saving this search
		WebElement saveThisSearchButton = driver.findElement(By.id("w4-w5-follow-follow-faux-btn"));
		
		saveThisSearchButton.click();
	
	}
	
	
	
	
	

}
