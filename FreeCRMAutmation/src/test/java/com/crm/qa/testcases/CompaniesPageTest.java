package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginPageHome;

public class CompaniesPageTest extends CRMBase{
	
	LoginPage loginpage;
	LoginPageHome loginpagehome;
	HomePage homePage;
	CompaniesPage companyPage;
	
	public CompaniesPageTest()
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
		homePage.clickCompaniesLink();
		companyPage=new CompaniesPage();
		
	}
	
	@Test(priority =1)
	public void createNewCompany() throws InterruptedException, AWTException
	{
		
		companyPage.clickCompanyBtn();
		companyPage.fillCompanyDetails();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		driver.close();
	}

}
