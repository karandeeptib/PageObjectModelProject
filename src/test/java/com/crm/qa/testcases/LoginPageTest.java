package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase{
	
	// Defining LoginPage class and HomePage class reference at class-level so that it can be used throughout the program
	LoginPage loginPage;
	HomePage homePage;
	
	Logger log=Logger.getLogger(LoginPageTest.class);
	
	// 1. create the constructor of LoginPageTest and with the help of super() keyword, call the constructor of parent class 
	public LoginPageTest() {
		super();     
	}
	
	
	// 2. Now, create the setup method and initialize the webdriver
	
	/**NOTE: Since we have already called the base class constrctor
	 and initialized the proporty file, calling the initialize method will not give nullpointer exception. Had we not done that
	 it would have give the exception as in the initilization method we use the data from property file. */
	
	@BeforeMethod
	public void setUp() {
		
		log.info("*********Inside the setup method ************");
		initialization();
		loginPage=new LoginPage();
	}
	
	
	
	// 3. Create Test cases 
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		log.info("*********running login page title test*********** ");
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void CRMLogoImageTest() {
		boolean logoFlag= loginPage.validateCRMImage();
		Assert.assertTrue(logoFlag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
		
	}
	
	
	
	// 4. End your test with the Teardown method and close your browser
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
