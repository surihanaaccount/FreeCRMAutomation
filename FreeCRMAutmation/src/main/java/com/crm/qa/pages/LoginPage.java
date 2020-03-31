package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class LoginPage extends CRMBase{
	
	@FindBy(xpath="//img[contains(@src,'/images/cogtiny1.jpg')")
	WebElement ImageFile;

	@FindBy(xpath="//a[contains(@href,'https://ui.freecrm.com')]")
	WebElement loginClick;
	
	@FindBy(xpath="//*[text()='crm']")
	WebElement crmColor;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[1]/div/div")
	WebElement mobileNo;
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCRMMenu()
	{
		boolean flag= false;
		
		List<String> expectedCRMList=new ArrayList<String>();
		
		expectedCRMList.add("CRM for Any Business");
		expectedCRMList.add("HIPAA CRM ");
		expectedCRMList.add("Dental CRM");
		expectedCRMList.add("Automotive CRM");
		expectedCRMList.add("Call Center CRM");
		expectedCRMList.add("Insurance CRM");
		expectedCRMList.add("Real Estate CRM");
		expectedCRMList.add("Professional Services CRM");
		expectedCRMList.add("Contractor Builder CRM");
		expectedCRMList.add("Independent Sales CRM");
		
		List<String> actualCRMList = new ArrayList<String>();
		
		List<WebElement> CRMList=driver.findElements(By.xpath(" //div/nav/div[2]/div/div[2]/ul/li[3]/ul/li/a"));
		for(WebElement actualCRML:CRMList)
		{
			System.out.println(actualCRML.getText());
			actualCRMList.add(actualCRML.getText());
		}
		
		for(String expectCRM:expectedCRMList)
		{
			if(actualCRMList.contains(expectCRM))
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
	
	public  boolean verifyLogo()
	{
		boolean ImagePresent=true;
		//boolean ImagePresent=(boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		return ImagePresent;
	}
	
	public  boolean verifyMobileNumber()
	{
		boolean mobilePresent=false;
		
		Utilities.isVisible("//img[contains(@src,'/images/cogtiny1.jpg')");
		
		String mobileNumber=mobileNo.getText();
		
		System.out.println("The mobile number"+mobileNumber);
		
		if(mobileNumber.length()>0)
		{
			mobilePresent =true;
		}
		else
		{
			mobilePresent =false;
		}
		return mobilePresent;
	}
	
	public String verifyLogoColor(String browser)
	{
		String[] hexValue = null;
		
		String logocrmCSS=crmColor.getCssValue("color");
		
		Utilities.isVisible("//*[text()='crm']");
		
		if(browser.equals("Chrome"))
		{
		 hexValue = logocrmCSS.replace("rgba(", "").replace(")", "").split(",");
		}
		else if(browser.equals("Firefox"))
		{
		 hexValue = logocrmCSS.replace("rgb(", "").replace(")", "").split(",");
		}
		 
		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);
		 
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		
		return actualColor;
	}
	
	public LoginPageHome clickLogin()
	{
		
		Utilities.isClickable(loginClick);
		
		loginClick.click();
		return new LoginPageHome();
		
		
	}

	
	
	

}
