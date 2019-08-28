package com.crm.qa.pages;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//1. Create the Page Factory - OR
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name = "title")
	WebElement titleCaption;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	//2. Create the constructor of the class and Initialize the above page objects
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//3. Now create the diffrent menthods/actions that we need to perform on this page
	
	public Boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	// this is the generic xpath code for selecting the dynamic checkbox based on the corresponding value
	
	public void selectContactsByName(String name) {
		
		driver.findElement(By.xpath("//a[text()='\"+name+\"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title, String fname, String lname, String comp) {
		
		Select select=new Select(titleCaption);
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}

}
