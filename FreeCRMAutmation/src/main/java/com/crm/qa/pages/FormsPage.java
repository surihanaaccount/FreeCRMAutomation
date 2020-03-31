package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class FormsPage extends CRMBase{
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[@href='/forms/new']/button")
	WebElement newBtn;
	
	@FindBy(css="input[name=name]")
    WebElement name;
	
	@FindBy(css="textarea[name=intro]")
	WebElement introductionText;
	
	@FindBy(css="textarea[name=outro]")
	WebElement completionText;
	
	@FindBy(css="input[name=active]")
	WebElement activeStatus;
	
	public FormsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewForm()
	{
		Utilities.clickBtn(newBtn);
	}
	
	public void fillFormsDetails()
	{
		boolean flag=false;
		name.sendKeys("Surihana Parveen");
		flag=activeStatus.isSelected();
		if(flag==false)
		{
			activeStatus.click();
		}
		introductionText.sendKeys("New Employee to this company");
		completionText.sendKeys("Nothing is there to complete");
	}
}
