package com.crm.qa.testcases;

import javax.rmi.CORBA.Util;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	
	// 1. create the constructor of LoginPageTest and with the help of super() keyword, call the constructor of parent class
	public HomePageTest() {
		super();
	}
	
	
	// 2. Now, create the setup method and initialize the webdriver
	
		/**NOTE: Since we have already called the base class constrctor
		 and initialized the proporty file, calling the initialize method will not give nullpointer exception. Had we not done that
		 it would have give the exception as in the initilization method we use the data from property file. */
		
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage= new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	// 3. Create Test cases 
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest() {
		String title= homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home Page title not matched");
	}
	
	@Test (priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactsLink();
	}
	
	
	
	// 4. End your test with the Teardown method and close your browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
