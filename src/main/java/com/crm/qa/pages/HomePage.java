package com.crm.qa.pages;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	//1. Create the Page Factory - OR

	@FindBy(xpath="//td[contains(text(),'User: Karandeep tib')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//2. Create the constructor of the class and Initialize the above page objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//3. Now create the diffrent menthods/actions that we need to perform on this page
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
	}
	

}
