package il.co.jb.ebay.auto.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.ebay.auto.infra.config.MainConfig;
import il.co.jb.ebay.auto.infra.pages.EbayHomePage;
import il.co.jb.ebay.auto.infra.pages.SignInPage;


public class LoginTests extends AbstractTest {

	private String userIdTest4;
	private String userPasswordTest4;
	private String userIdTest5;
	private String userPasswordTest5;

	@Test
	public void test_1_BasicLogin() throws Exception {

		//Step 1: Browse to ebay home page

		report.startLevel("Step 1: Browse to ebay home page");
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		report.endLevel();

		//Step 2: On the top left, click on "sign in" button

		report.startLevel("Step 2: On the top left, click on 'sign in' button");
		SignInPage signInPage = ebayHomePage.clickOnHomeSignInButton();
		report.endLevel();

		//Step 3: Insert user name and password. Click on 'sign in' button

		report.startLevel("Step 3: Insert user name and password. Click on 'sign in' button");
		String userId = MainConfig.userId;
		String userPassword = MainConfig.userPassword;

		signInPage.writeToUserIdField(userId);
		signInPage.writeToPasswordField(userPassword);
		ebayHomePage = signInPage.clickOnSignInButton();
		report.endLevel();

		//Step 4: Verify that user is connected by "sign in" button not visible

		report.startLevel("Step 4: Verify that user is connected by \"sign in\" button not visible");
		boolean hiUserNameVisible = ebayHomePage.isHiUserFirstNameVisible();

		Assert.assertEquals(hiUserNameVisible, true, "User first name is not visible");
		Assert.assertEquals(ebayHomePage.isHomeSignInButtonVisible(), false, "Sign in button is still visible");
		report.endLevel();

		driver.close();
	}

	@Test
	public void test_2_InsertOnlyUserName() throws Exception {

		//Step 1: Browse to ebay home page

		report.startLevel("Step 1: Browse to ebay home page");
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		report.endLevel();

		//Step 2: On the top left, click on 'sign in' button

		report.startLevel("Step 2: On the top left, click on 'sign in' button");
		SignInPage signInPage = ebayHomePage.clickOnHomeSignInButton();
		report.endLevel();

		//Step 3: Insert only user name, and click on 'sign in' button

		report.startLevel("Step 3: Insert only user name, and click on 'sign in' button");
		String userId = MainConfig.userId;
		signInPage.writeToUserIdField(userId);

		try{
			ebayHomePage = signInPage.clickOnSignInButton();
		}
		catch (Exception ex) {
			report.log("Exception: "+ ex +" has found.");
		}
		signInPage.clickOnSignInPageOnly();
		report.endLevel();

		//Expected result - an error message will appear 'Oops, that's not a match.'

		report.startLevel("Expected result - an error message will appear 'Oops, that's not a match.'");
		String errorMessageText = signInPage.getErrorMessageText();

		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		report.endLevel();

		driver.close();
	}

	@Test
	public void test_3_InsertOnlyPassword() throws Exception {

		//Step 1: Browse to ebay home page

		report.startLevel("Step 1: Browse to ebay home page");
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		report.endLevel();

		//Step 2: On the top left, click on 'sign in' button

		report.startLevel("Step 2: On the top left, click on 'sign in' button");
		SignInPage signInPage = ebayHomePage.clickOnHomeSignInButton();
		report.endLevel();

		//Step 3: Insert only password, and click on 'sign in' button

		report.startLevel("Step 3: Insert only password, and click on 'sign in' button");
		String userPassword = MainConfig.userPassword;
		signInPage.writeToPasswordField(userPassword);

		try{
			ebayHomePage = signInPage.clickOnSignInButton();
		}
		catch (Exception ex) {
			report.log("Exception: "+ ex +" has found.");
		}
		signInPage.clickOnSignInPageOnly();
		report.endLevel();

		//Expected result - an error message will appear 'Oops, that's not a match.'

		report.startLevel("Expected result - an error message will appear 'Oops, that's not a match.'");
		String errorMessageText = signInPage.getErrorMessageText();

		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		report.endLevel();

		driver.close();
	}

	@Test
	public void test_4_WrongUserName() throws Exception {
		
		initTest4Params();

		//Step 1: Browse to ebay home page

		report.startLevel("Step 1: Browse to ebay home page");
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		report.endLevel();

		//Step 2: On the top left, click on 'sign in' button

		report.startLevel("Step 2: On the top left, click on 'sign in' button");
		SignInPage signInPage = ebayHomePage.clickOnHomeSignInButton();
		report.endLevel();

		//Step 3: Insert incorrect email address, and the correct password. Click on 'sign in' button

		report.startLevel("Step 3: Insert incorrect email address, and the correct password. Click on 'sign in' button");
		signInPage.writeToUserIdField(userIdTest4);

		signInPage.writeToPasswordField(userPasswordTest4);

		try{
			ebayHomePage = signInPage.clickOnSignInButton();
		}
		catch (Exception ex) {
			report.log("Exception: "+ ex +" has found.");
		}
		signInPage.clickOnSignInPageOnly();
		report.endLevel();

		//Expected result - an error message will appear 'Oops, that's not a match.'

		report.startLevel("Expected result - an error message will appear 'Oops, that's not a match.'");
		String errorMessageText = signInPage.getErrorMessageText();

		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		report.endLevel();

		driver.close();
	}

	@Test
	public void test_5_WrongPassword() throws Exception{
		
		initTest5Params();

		//Step 1: Browse to ebay home page

		report.startLevel("Step 1: Browse to ebay home page");
		browseToUrl(MainConfig.baseUrl);
		EbayHomePage ebayHomePage = new EbayHomePage(driver);
		report.endLevel();

		//Step 2: On the top left, click on 'sign in' button

		report.startLevel("Step 2: On the top left, click on 'sign in' button");
		SignInPage signInPage = ebayHomePage.clickOnHomeSignInButton();
		report.endLevel();

		//Step 3: Insert correct user name and incorrect password. Click on 'sign in' button

		report.startLevel("Step 3: Insert correct user name and incorrect password. Click on 'sign in' button");
		
		signInPage.writeToUserIdField(userIdTest5);
		signInPage.writeToPasswordField(userPasswordTest5);

		try{
			ebayHomePage = signInPage.clickOnSignInButton();
		}
		catch (Exception ex) {
			report.log("Exception: "+ ex +" has found.");
		}
		signInPage.clickOnSignInPageOnly();
		report.endLevel();

		//Expected result - an error message will appear 'Oops, that's not a match.'

		report.startLevel("Expected result - an error message will appear 'Oops, that's not a match.'");
		String errorMessageText = signInPage.getErrorMessageText();

		Assert.assertEquals(errorMessageText, "Oops, that's not a match.", "Wrong error message");
		report.endLevel();

		driver.close();
	}

	private void initTest4Params() throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config/LoginTest4.properties");

		prop.load(input);

		userIdTest4 = prop.getProperty("userId");
		userPasswordTest4 = prop.getProperty("userPasswordTest4");
		
		input.close();
	}

	private void initTest5Params() throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config/LoginTest5.properties");

		prop.load(input);

		userIdTest5 = prop.getProperty("userIdTest5");
		userPasswordTest5= prop.getProperty("userPasswordTest5");
		
		input.close();
	}




}
