package com.crm.qa.pages;


import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class CompaniesPage extends CRMBase {
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[@href='/companies/new']/button")
	WebElement companyBtn;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement export;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div/input")
	WebElement name;
	
	@FindBy(css="input[name='url']")
	WebElement websiteURL;
	
	@FindBy(xpath="//button[contains(text(),'Fetch')]")
	WebElement fetchBtn;
	
	@FindBy(css="input[name='address']")
	WebElement address;
	
	@FindBy(css="input[name='city']")
	WebElement city;
	
	@FindBy(css="input[name='state']")
	WebElement state;
	
	@FindBy(css="input[name='zip']")
	WebElement zip;
	
	@FindBy(xpath="//*[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//*[@name='hint']")
	WebElement phone;
	
	@FindBy(css="input[placeholder='Number']")
	WebElement number;
	
	@FindBy(css="input[placeholder='Home, Work, Mobile...']")
	WebElement homeNumber;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[2]/div/label[2]/div")
	WebElement tag;
	
	@FindBy(xpath="//textarea")
	WebElement description;
	
	@FindBy(xpath="//*[@name='channel_type']")
	WebElement socialChannel;
	
	@FindBy(css="input[placeholder='LinkedIn profile link']")
	WebElement socialChannelLink;
	
	@FindBy(css="input[name='industry']")
	WebElement industry;
	
	
	@FindBy(css="input[name='num_employees']")
	WebElement numberOfEmployees;
	
	@FindBy(css="input[name='symbol']")
	WebElement symbol;
	
	@FindBy(css="input[name='annual_revenue']")
	WebElement annualRevenue;
	
	@FindBy(xpath="//*[@name='priority']")
	WebElement priority;
	
	@FindBy(xpath="//*[@name='status']")
	WebElement status;
	
	@FindBy(xpath="//*[@name='source']")
	WebElement source;
	
	@FindBy(xpath="//*[@name='category']")
	WebElement category;
	
	@FindBy(css="input[name='vat_number']")
	WebElement vatNumber;
	
	@FindBy(css="input[name='identifier']")
	WebElement identifier;
	
	@FindBy(css="input[name='image']")
	WebElement image;
	
	
	
	public CompaniesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickCompanyBtn() throws InterruptedException
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", companyBtn);
		
	}
	
	
	
	public void fillCompanyDetails() throws AWTException, InterruptedException
	{
		
		
		 name.sendKeys("lathasingh");
		 websiteURL.sendKeys("google.com");
		 Utilities.clickBtn(fetchBtn);
		 address.sendKeys("Kukatpally");
		 city.sendKeys("Hyderabad");
		 state.sendKeys("Telangana");
		 zip.sendKeys("500072");

		 Utilities.selectValue(phone, "//*[@name='hint']//*[@role='option']/span", "India");
		 Utilities.selectValue(country, "//*[@name='country']//*[@role='option']/span", "India");
		 number.sendKeys("91");
		 homeNumber.sendKeys("7788996655");
		 description.sendKeys("Nothing to describe");
		// tag.sendKeys("More Employees Selection");
		 Utilities.selectValue(socialChannel, "//*[@name='channel_type']//*[@role='option']/span", "LinkedIn");
         socialChannelLink.sendKeys("https://in.linkedin.com/");
         industry.sendKeys("Akvila");
         numberOfEmployees.sendKeys("150");
         symbol.sendKeys("Leopeard");
         annualRevenue.sendKeys("15 crores");
         Utilities.selectValue(priority, "//*[@name='priority']//*[@role='option']/span", "High");
         Utilities.selectValue(status, "//*[@name='status']//*[@role='option']/span", "Active");
         Utilities.selectValue(source, "//*[@name='source']//*[@role='option']/span", "Customer");
         Utilities.selectValue(category, "//*[@name='category']//*[@role='option']/span", "Client");
         vatNumber.sendKeys("1234567891234567");
         identifier.sendKeys("Tiger Symbol");
         Utilities.imageSelection(image,"D:\\Reports\\Images\\flowers.jpg");
		 
		 
		 
		
	}
	

}
