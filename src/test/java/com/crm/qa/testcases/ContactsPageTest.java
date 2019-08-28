package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage= new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
	
	@Test (priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact label is not available on the page");		
	}
	

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data= TestUtil.getTestData("contact");
		return data;
		
		
	}
	
	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void createNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName,lastName,company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
