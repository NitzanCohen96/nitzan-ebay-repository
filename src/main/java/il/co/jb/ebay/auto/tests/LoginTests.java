package il.co.jb.ebay.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends AbstractTest {

	@Test
	public void test_2_InsertOnlyUserName() {
		
		//Step 1: Browse to e-bay.com home page
		driver.get("https://www.ebay.com");
		
		//Step 2: On the top left, click on "sign in" button
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
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
	

}
