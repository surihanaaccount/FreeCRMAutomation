package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class HomePage extends CRMBase{
	
	Actions action=new Actions(driver);
	
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[3]/span[1]")
	WebElement userName;
	
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[1]")
	WebElement imageFile;
	
	

	@FindBy(css="a[href='/contacts']")
	WebElement contactLink;
	
	@FindBy(css="a[href='/companies']")
	WebElement companiesLink;
	
	@FindBy(css="a[href='/deals']")
	WebElement dealsLink;
	
	@FindBy(css="a[href='/campaigns']")
	WebElement campaignsLink;
	
	@FindBy(css="a[href='/forms']")
	WebElement formsLink;
	
	@FindBy(css="a[href='/documents']")
	WebElement documentLink;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyUserName()
    {
		return userName.getText();
	}
	public ContactsPage clickContactLink()
	{
	    action.moveToElement(contactLink).click().build().perform();
		return new ContactsPage();
	}
	
	public CompaniesPage clickCompaniesLink()
	{
		action.moveToElement(companiesLink).click().build().perform();
		return new CompaniesPage();
	}
	public CampaignsPage clickCampaignsLink()
	{
		action.moveToElement(campaignsLink).click().build().perform();
		return new CampaignsPage();
	}
	
	public FormsPage clickFormsLink()
	{
		Utilities.clickAction(formsLink);
		return new FormsPage();
	}
	
	public DealsPage clickDealsLink()
	{
		Utilities.clickAction(dealsLink);
		return new DealsPage();
	}

	public boolean verifyHomeLinks() {
		
		boolean flag=false;
		
		List<String> expectedHomeLinks=new ArrayList();
		expectedHomeLinks.add("Home");
		expectedHomeLinks.add("Calendar");
		expectedHomeLinks.add("Contacts");
		expectedHomeLinks.add("Companies");
		expectedHomeLinks.add("Deals");
		expectedHomeLinks.add("Tasks");
		expectedHomeLinks.add("Cases");
		expectedHomeLinks.add("Calls");
		expectedHomeLinks.add("Documents");
		expectedHomeLinks.add("Email");
		expectedHomeLinks.add("Campaigns");
		expectedHomeLinks.add("Forms");
		
		List<String> actualHomeLinks=new ArrayList();
		List<WebElement> homeLinks=driver.findElements(By.xpath("//*[@id=\"main-nav\"]/a/span"));
		for(WebElement eachLink:homeLinks)
		{
			actualHomeLinks.add(eachLink.getText());
		}
		
		for(String expectHome:expectedHomeLinks)
		{
			if(actualHomeLinks.contains(expectHome))
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		
		return flag;
		
		
	}
	
	public boolean verifyImageFile()
	{
		boolean ImagePresent=(boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imageFile);
		return ImagePresent;
	}

	public boolean verifyClickable() {
		
		boolean flag=true;
		
		List<WebElement> homeLinks1=driver.findElements(By.xpath("//*[@id=\"main-nav\"]/a/span"));
		for(WebElement eachLink:homeLinks1)
		{
			flag=Utilities.isClickable(eachLink);
			if(flag)
			{
				System.out.println(eachLink.getText() + " is clickable");
				
			}
			else
			{
				System.out.println(eachLink.getText() + " is not clickable");
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	
}
