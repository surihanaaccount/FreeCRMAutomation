package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class DealsPage extends CRMBase{
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[@href='/deals/new']/button")
	WebElement newBtn;
	
	@FindBy(css="input[name='title']")
	WebElement title;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div")
	WebElement assignedTo;
	
	@FindBy(xpath="//*[@name='company']/input")
	WebElement company;
	
	@FindBy(xpath="//*[@name='products']/input")
	WebElement product;
	
	@FindBy(xpath="//*[@name='contacts']/input")
	WebElement contact;
	
	@FindBy(css="textarea[name='description']")
	WebElement description;
	
	@FindBy(css="input[name='probability']")
	WebElement probability;
	
	@FindBy(css="input[name='amount']")
	WebElement amount;
	
	@FindBy(css="input[name='commission']")
	WebElement commission;
	
	@FindBy(xpath="//*[@name='stage']")            //*[@name='stage']//*[@role='option']/span
	WebElement stage;
	
	@FindBy(css="input[name='closed']")
	WebElement closeStatus;
	
	@FindBy(xpath="//*[@name='status']")         //*[@name='status']//*[@role='option']/span
	WebElement status;
	
	@FindBy(css="textarea[name='next_step']")
	WebElement nextStep;
	
	@FindBy(xpath="//*[@name='type']")     //*[@name='type']//*[@role='option']/span
	WebElement type;
	
	
	@FindBy(xpath="//*[@name='source']")       //*[@name='source']//*[@role='option']/span
	WebElement source;
	
	@FindBy(css="input[name='identifier']")
	WebElement identifier;
	
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[1]/div/div[1]/div/input")
	WebElement clickCalendar;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewDeal()
	{
		Utilities.clickBtn(newBtn);
		
	}
	
	public void fillDealDetails()
	{
		boolean flag=false;
		
		System.out.println("Enter the details");
		
		title.sendKeys("Product Deal");
		company.sendKeys("Akvila.com");
		contact.sendKeys("parveen");
		product.sendKeys("Tyres");
		description.sendKeys("nothing To mentioned");
		probability.sendKeys("Infinity");
		amount.sendKeys("15000");
		commission.sendKeys("10 percentage");
		Utilities.selectValue(stage, "//*[@name='stage']//*[@role='option']/span", "Qualify");
	    //closeStatus.click();   //dynamic handling
		Utilities.selectValue(status, "//*[@name='status']//*[@role='option']/span", "Active");
		nextStep.sendKeys("Approval Level");	
		Utilities.selectValue(type, "//*[@name='type']//*[@role='option']/span", "Old");
		Utilities.selectValue(source," //*[@name='source']//*[@role='option']/span","Partner");
		identifier.sendKeys("Company symbol");
		
		
  }
  
	public void clickCal()
	{
		
	}
}
