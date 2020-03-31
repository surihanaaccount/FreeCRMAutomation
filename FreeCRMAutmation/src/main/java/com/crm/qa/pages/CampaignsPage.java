package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class CampaignsPage extends CRMBase {
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[@href='/campaigns/new']/button")
	WebElement campaignBtn;
	
	@FindBy(css="input[name='name']")
	WebElement name;
	
	@FindBy(xpath="//*[@name='transport_type']")         //*[@name='transport_type']//*[@role='option']/span
	WebElement transportType;
	
	@FindBy(xpath="//*[@name='transport_id']")
	WebElement transportId;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/label")
	WebElement activeStatus;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[3]/table/tbody/tr/td[2]/div/label")
	WebElement templateActiveStatus;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[3]/table/tbody/tr/td[3]/div")
	WebElement templateActive;
	
	public CampaignsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickCampaignBtn()
	{
		
		campaignBtn.click();
		
	}
	
	
	
	public void fillCampaignDetails()
	{
		boolean flag=false;
		name.sendKeys("parveen");
		Utilities.selectValue(transportType, "//*[@name='transport_type']//*[@role='option']/span", "Email");
		transportId.sendKeys("surihana.parveen@gmail.com");
		activeStatus.click();
		flag=templateActiveStatus.isSelected();
		if(flag==false)
		{
			templateActiveStatus.click();
		}
		templateActive.sendKeys("Email");
		
	}
	
	
	


}
