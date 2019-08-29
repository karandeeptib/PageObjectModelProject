package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	 
	//1. Create the Page Factory - OR 
	
	@FindBy(name="username11")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//2. Create the constructor of the class and Initialize the above page objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//3. Now create the diffrent menthods/actions that we need to perform on this page
	
	public String validateLoginPageTitle() {
		return driver.getTitle();	
	}

	public Boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		TestUtil.customWait10s(); 
		loginBtn.click();
		
		/** Now after clicking login button, we are directed to the homepage (landing page), so this method should return
		Home page class object */
		
		return new HomePage();
		
	}
	
	
}
