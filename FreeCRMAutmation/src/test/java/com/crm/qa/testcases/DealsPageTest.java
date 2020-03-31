package com.crm.qa.testcases;


import java.awt.AWTException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.CampaignsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginPageHome;

public class DealsPageTest extends CRMBase{
	
	LoginPage loginpage;
	LoginPageHome loginpagehome;
	HomePage homePage;
	DealsPage dealPage;
	
	public DealsPageTest()
	{
		super();
	}
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws InterruptedException
	{
		initialization(browser);
		loginpage=new LoginPage();
		loginpage.clickLogin();
		loginpagehome=new LoginPageHome();
		loginpagehome.login("surihana.parveen@gmail.com", "Abdul@87");
		homePage=new HomePage();
		homePage.clickDealsLink();
		dealPage=new DealsPage();
		
		
	}
	
	@Test(priority =1)
	public void createNewButton() throws InterruptedException, AWTException
	{
		dealPage.clickNewDeal();
		dealPage.fillDealDetails();
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		driver.close();
	}

}
