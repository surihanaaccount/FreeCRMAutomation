package com.crm.qa.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginPageHome;


public class LoginPageTest extends CRMBase {
	LoginPage loginpage;
	LoginPageHome loginpagehome;
	HomePage homePage;
	
	Logger log=Logger.getLogger("devpinoyLogger");
	
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		loginpage=new LoginPage();
		//loginpage.clickLogin();
		loginpagehome=new LoginPageHome();
		homePage=new HomePage();
		
	}
	
	/*@BeforeMethod
	public void setUp1()
	{
		initialization();
		loginpage=new LoginPage();
		loginpage.clickLogin();
		loginpagehome=new LoginPageHome();
		
	}*/
	
	@Test(priority=0)
	public void verifyCRMLinks()
	{
		System.out.println("The crm result is "+loginpage.validateCRMMenu());
		Assert.assertTrue(loginpage.validateCRMMenu(), "All the links are available");
	}
	
	@Test(priority=1) 
	  public void verifyLogo() {
	 
	  Assert.assertTrue(loginpage.verifyLogo()); 
	  //loginpage.clickLogin(); 
	  
	  }
	  
	  @Test(priority=2)
	  public void verifyMobile()
	  {
	  boolean flag=loginpage.verifyMobileNumber();	  
	  Assert.assertTrue(flag); 
	  }
	  
	  @Test(priority=3)
	  @Parameters("browser")
	  public void verifyLogoColor(String browser)
	  {
	  String actualValue=loginpage.verifyLogoColor(browser);
	  Assert.assertEquals(actualValue, "#0e3655","The CRM logo is not matched");
	  }
	  
	  @Test(priority=4)
	  public void clickLogin()
	  {
		  loginpage.clickLogin(); 
	  }
	  
	 @Test(priority=5)
	public void login() throws InterruptedException
	{
		Thread.sleep(10000);
		homePage = loginpagehome.login("surihana.parveen@gmail.com", "Abdul@87");
		String actualName=homePage.verifyUserName();
		Assert.assertEquals(actualName, "surihana parveen");
	}
	
	/*@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus()){
			 try{
				 
				 TakesScreenshot screenshot=(TakesScreenshot)driver;
				 File src=screenshot.getScreenshotAs(OutputType.FILE);
			     FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
				 System.out.println("Successfully captured a screenshot");
				 }catch (Exception e){
				 System.out.println("Exception while taking screenshot "+e.getMessage());
				 } 
		}
	}*/
	
	@AfterTest
	public void tearDown1()
	{
		log.info("Test Script Login end");
		//driver.close();
	}

}
