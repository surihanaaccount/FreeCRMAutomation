package com.crm.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.CRMBase;


public class Utilities extends CRMBase {
	
	public static final long IMPLICIT_WAIT = 30;
	public static final long PAGE_LOAD_TIMEOUT=30;
	
	
	
	
	public static void clickBtn(WebElement element)
	{
		element.click();
	}
	
	 public static void selectValue(WebElement element,String FindBy, String comparisionVal)
	 {
		 
		 element.click();
		 
		 List<WebElement> options =driver.findElements(By.xpath(FindBy));
		 
		 for(WebElement option: options)
		 {
			 if(comparisionVal.equals(option.getText()))
			 {
				 option.click();
			 }
		 }
		 
	 }
	 
	 public static void imageSelection(WebElement element,String filePath) throws AWTException, InterruptedException {
			
			
			
			StringSelection sel = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
			
			element.click();
			
			
			Robot robot = new Robot();
			
			Thread.sleep(1000);
			
			//Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			Thread.sleep(1000);
			
			//Press CTRL+V
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			//robot.keyRelease(KeyEvent.VK_V);
			
			
			
			//Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
			
			
	}
	 
	 public static String getCurrentTimeStamp() {
		 
		 SimpleDateFormat sdfDate=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss.SSS");
		 Date now=new Date();
		 String strDate=sdfDate.format(now);
		 return strDate;
		 
			
	}
	 
	 public static void clickAction(WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.moveToElement(element).click().build().perform(); 
	 }
	 
	 public static boolean isClickable(WebElement webe)      
		{
		    try
		    {
		        WebDriverWait wait = new WebDriverWait(driver, 5);
		        wait.until(ExpectedConditions.elementToBeClickable(webe));
		        return true;
		    }
		    catch (Exception e)
		    {
		        return false;
		    }
		}
	 
	 public static boolean fieldAlphaValidation(String val)
	 {
		 Pattern p = Pattern.compile("^[a-zA-Z]*$");
		 
		 boolean flag=isAlpha(val,p);
		 
		 return flag;
   
			
	 }
	 public static boolean isAlpha(String s,Pattern p) {
			return p.matcher(s).find();
		}
	 
	 public static boolean fieldEmailValidation(String val)
	 {
	    boolean flag=false;
		 Pattern pattern=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 Matcher matcher=pattern.matcher(val);
		 if(matcher.matches())
		 {
			 flag=true;
		 }
		 return flag;
	 }
	 
	 public static boolean fieldPhoneNumberValidation(String val)
	 {
		 boolean flag=false;
		 Pattern pattern=Pattern.compile("	\r\n" + 
		 		"(^1300\\d{6}$)|(^1800|1900|1902\\d{6}$)|(^0[2|3|7|8]{1}[0-9]{8}$)|(^13\\d{4}$)|(^04\\d{2,3}\\d{6}$)");
		 Matcher matcher=pattern.matcher(val);
		 if(matcher.matches())
		 {
			 flag=true;
		 }
		 return flag;
	 }
	 
	 public static boolean fieldNumberValidation(String val)
	 {
		 boolean flag=false;
		 Pattern pattern=Pattern.compile(".*[^0-9].*");
		 Matcher matcher=pattern.matcher(val);
		 if(matcher.matches())
		 {
			 flag=true;
		 }
		 return flag;
	 }
	 
	 public static boolean fieldPincodeValidation(String val)
	 {
		 boolean flag=false;
		 Pattern pattern=Pattern.compile("\\d{6}");
		 Matcher matcher=pattern.matcher(val);
		 if(matcher.matches())
		 {
			 flag=true;
		 }
		 return flag;
	 }
	 
	 public static boolean isVisible(String type)
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(type)));
		 return true;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 
	}
	 
}
