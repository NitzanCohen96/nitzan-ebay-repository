package il.co.jb.ebay.auto.tests;

import org.testng.annotations.Test;

public class LoginTests extends AbstractTest {

	@Test
	public void test1_LoginToEbay() {
		
		driver.get("https://www.ebay.com");
	}
	
}
