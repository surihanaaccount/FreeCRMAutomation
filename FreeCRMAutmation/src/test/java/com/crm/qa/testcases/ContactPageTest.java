package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;


import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginPageHome;
import com.crm.qa.util.ExcelUtil;


public class ContactPageTest extends CRMBase {
	
	LoginPage loginpage;
	LoginPageHome loginpagehome;
	HomePage homePage;
	ContactsPage contactpage;
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws InterruptedException {
		
		initialization(browser);
		loginpage=new LoginPage();
		loginpage.clickLogin();
		loginpagehome=new LoginPageHome();
		loginpagehome.login("surihana.parveen@gmail.com", "Abdul@87");
		homePage=new HomePage();
		homePage.clickContactLink();
		Thread.sleep(30000);
		contactpage=new ContactsPage();
		
	}
	
	/*
	 * @Test(priority = 1) public void clickNewBtn() { contactpage.clickNew(); }
	 */
	@Test(priority =1,enabled=false)
	public void verifyContactSearch()
	{
		boolean flag=contactpage.verifyContact();
		assertEquals(flag, true, "The contact Name is not given properly");
	}
	
	@Test(priority =2)
	public void ClickNewContact() throws InterruptedException
	{
		
		contactpage.clickNew();
	}
	
	
	
	
	@Test(priority =3,dataProvider="contactDetails")
	public void createNewContract(String FirstName,String LastName,String middleName,String CompanyName,String EmailAddress,String PersonalEmail,String Status,String description,String SocialChannel,String channelLink,String timeZone,String phoneCountry,String position,String department,String supervisor,String assistant,String refferedBy,String address,String city,String state,String zipCode,String country,String source,String identifier) throws InterruptedException, AWTException
	{
		
		contactpage.fillContactDetails(FirstName,LastName,middleName,CompanyName,EmailAddress,PersonalEmail,Status,description,SocialChannel,channelLink,timeZone,phoneCountry,position,department,supervisor,assistant,refferedBy,address,city,state,zipCode,country,source,identifier);
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(30000);
		//driver.close();
	}
	
	
	@DataProvider(name="contactDetails")
	
	public Object[][] contactData() throws Exception{
		
		Object[][] arrayObject = ExcelUtil.getTableArray("D:\\Automation Projects\\FreeCRMAutmation\\src\\main\\resources\\FreeCRMData.xlsx","ContactSheet2");
	    
		return arrayObject;
	
	}
	
	

}
