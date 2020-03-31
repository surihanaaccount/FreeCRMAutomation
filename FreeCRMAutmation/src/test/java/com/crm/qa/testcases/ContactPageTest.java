package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
import com.crm.qa.util.Utilities;

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
	
	
	
	@Test(priority=3)
	public void verifyFirstName()
	{
		
	}
	
	
	
	@Test(priority =2)
	public void ClickNewContact()
	{
		
		contactpage.clickNew();
	}
	
	
	
	
	@Test(priority =4,dataProvider="contactDetails")
	public void createNewContract(String FirstName,String LastName,String CompanyName) throws InterruptedException, AWTException
	{
		
		
		
		
		
		
		contactpage.fillContactDetails(FirstName,LastName,CompanyName);
		
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(30000);
		driver.close();
	}
	
	
	@DataProvider(name="contactDetails")
	
	public Object[][] contactData() throws Exception{
		
		Object[][] arrayObject = ExcelUtil.getTableArray("D:\\Automation Projects\\FreeCRMAutmation\\src\\main\\resources\\FreeCRMData.xlsx","ContactSheet");
	    
		return arrayObject;
	
	}
	
	

}
