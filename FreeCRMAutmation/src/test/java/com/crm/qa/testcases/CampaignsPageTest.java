package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.CampaignsPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginPageHome;

public class CampaignsPageTest extends CRMBase{
	
	LoginPage loginpage;
	LoginPageHome loginpagehome;
	HomePage homePage;
	CampaignsPage campaignpage;
	
	public CampaignsPageTest()
	{
		super();
	}
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws InterruptedException
	{
		initialization(browser);
		loginpage=new LoginPage();
		loginpage.clickLogin();
		loginpagehome=new LoginPageHome();
		loginpagehome.login("surihana.parveen@gmail.com", "Abdul@87");
		homePage=new HomePage();
		homePage.clickCampaignsLink();
		campaignpage=new CampaignsPage();
		
		
	}
	
	@Test(priority =1)
	public void createNewCampaign() throws InterruptedException, AWTException
	{
		
		campaignpage.clickCampaignBtn();
		campaignpage.fillCampaignDetails();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		driver.close();
	}
	
	

}
