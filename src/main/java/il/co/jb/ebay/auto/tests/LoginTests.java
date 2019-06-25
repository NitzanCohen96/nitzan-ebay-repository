package il.co.jb.ebay.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.infra.pages.EbayHomePage;


public class LoginTests extends AbstractTest {
	
	@Test
	public void test_1_BasicLogin() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		//Step 3: Insert user name and password. Click on "sign in" button
		driver.findElement(By.id("userid")).sendKeys("aumat15");
		driver.findElement(By.id("pass")).sendKeys("QaTesting3105");
		driver.findElement(By.id("sgnBt")).click();
		
		//Step 4: Verify that user is connected by "sign in" button not visible
		
		
	}

	@Test
	public void test_2_InsertOnlyUserName() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		//WebElement signInButton = driver.findElement(By.xpath("//a[text()='Sign in']"));
		EbayHomePage.signInButton.click();
		
		
		//Step 3: Insert only user name, and click on "sign in" button
		driver.findElement(By.id("userid")).sendKeys("will be taken from a config file");
		driver.findElement(By.id("sgnBt")).click();
		
		//Expected result - an error message will appear "Oops, that's not a match."
		WebElement errorMessage = driver.findElement(By.id("errf"));
		String errorMessageText = errorMessage.getText();
		
		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		
	}
	
	@Test
	public void test_3_InsertOnlyPassword() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		//Step 3: Insert only password, and click on "sign in" button
		driver.findElement(By.id("pass")).sendKeys("will be taken from a config file");
		driver.findElement(By.id("sgnBt")).click();
		
		//Expected result - an error message will appear "Oops, that's not a match."
		WebElement errorMessage = driver.findElement(By.id("errf"));
		String errorMessageText = errorMessage.getText();
				
		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		
	}
	
	@Test
	public void test_4_WrongUserName() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();;
		
		//Step 3: Insert incorrect email address, and the correct password. Click on "sign in" button
		driver.findElement(By.id("userid")).sendKeys("Will be taken from a config file");
		driver.findElement(By.id("pass")).sendKeys("QaTesting3105");
		driver.findElement(By.id("sgnBt")).click();
		
		//Expected result - an error message will appear "Oops, that's not a match."
		WebElement errorMessage = driver.findElement(By.id("errf"));
		String errorMessageText = errorMessage.getText();
		
		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		
	}
	
	@Test
	public void test_5_WrongPassword() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		//Step 3: Insert correct user name and incorrect password. Click on "sign in" button
		driver.findElement(By.id("userid")).sendKeys("aumat15");
		driver.findElement(By.id("pass")).sendKeys("aA3542");
		driver.findElement(By.id("sgnBt")).click();
		
		//Expected result - an error message will appear "Oops, that's not a match."
		WebElement errorMessage = driver.findElement(By.id("errf"));
		String errorMessageText = errorMessage.getText();
		
		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		
	}
	
	@Test
	public void test_6_StaySignedIn() {
		
		//Step 1: Browse to e-bay home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		//Step 3: Mark the check box "Stay signed in"
		
		
	}
	

}
