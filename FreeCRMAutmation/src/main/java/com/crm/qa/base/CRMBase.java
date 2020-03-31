package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.Utilities;

public class CRMBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public CRMBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization(String browser) {
		//String browserName=prop.getProperty("browser");
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}
	
	

}
