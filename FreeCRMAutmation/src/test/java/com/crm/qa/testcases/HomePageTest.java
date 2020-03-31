package com.crm.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginPageHome;

public class HomePageTest extends CRMBase{
	
	LoginPage loginpage;
	LoginPageHome loginpagehome;
	HomePage homePage;
	ContactsPage contactpage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		loginpage=new LoginPage();
		loginpage.clickLogin();
		loginpagehome=new LoginPageHome();
		loginpagehome.login("surihana.parveen@gmail.com", "Abdul@87");
		homePage=new HomePage();
		
	}
	
	@Test(priority=1)
	public void verifyHomePageLinks()
	{
		boolean flag=homePage.verifyHomeLinks();
		Assert.assertEquals(flag, true,"The all the link are not properly assigned");
	}
	
	@Test(priority=2)
	public void verifyHomeLogo()
	{
		boolean actual=homePage.verifyImageFile();
		Assert.assertEquals(actual, true,"The logo is not present");
	}
	
	@Test(priority=3)
	public void verifyHomeLinksClickable()
	{
		boolean actual=homePage.verifyClickable();
		Assert.assertEquals(actual,true,"Some links are not clickable");
	}
	
	
	@Test(priority=4,dependsOnMethods="verifyHomePageLinks")
	public void clickContact()
	{
		contactpage=homePage.clickContactLink();
	}
	
	@AfterTest
	 public void tearDown() throws InterruptedException
	 {
		Thread.sleep(30000);
		driver.close();
	 }

}
