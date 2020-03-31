package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;

public class LoginPageHome extends CRMBase{
	
	@FindBy(css="input[name='email']")
	WebElement userName;
	
	@FindBy(css="input[name='password']")
	WebElement passWord;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginBtn;
	
	public LoginPageHome()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String username,String password)
	{
	System.out.println(username);
	System.out.println(password);
	  userName.sendKeys(username);
	  passWord.sendKeys(password);
	  loginBtn.click();
	  return new HomePage();
		
	}
	
	

}
