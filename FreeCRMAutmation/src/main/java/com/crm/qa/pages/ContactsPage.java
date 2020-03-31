package com.crm.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.CRMBase;
import com.crm.qa.util.Utilities;

public class ContactsPage extends CRMBase{
	
	@FindBy(css="input[placeholder='Search']")
	WebElement verifyContact;
	
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")    //*[@id="dashboard-toolbar"]/div[2]/div/a/button
	WebElement createBtn;
	
	@FindBy(css="input[name='first_name']")
	WebElement firstName;
	
	@FindBy(css="input[name='last_name']")
	WebElement lastName;
	
	@FindBy(css="input[name='middle_name']")
	WebElement middleName;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement companyName;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[3]/div[2]/div/label[2]/div")
	WebElement tag;
	
	
	@FindBy(css="input[placeholder='Email address']")
    WebElement emailAddress;	
	
	@FindBy(css="input[placeholder='Personal email, Business, Alt...']")
	WebElement personalEmailAddress;
	
	//Common function
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[2]/div/div")
	WebElement category;
	
	//common function
	@FindBy(xpath="//*[@name='status']")
	WebElement status;
	
	@FindBy(css="textarea[name='description']")
	WebElement description;
	
	@FindBy(xpath="//*[@name='channel_type']")
	WebElement socialChannel;
	
	@FindBy(css="input[placeholder='LinkedIn profile link']")
	WebElement socialChannelLink;
	
	//common function
	@FindBy(xpath="//*[@name='timezone']")
	WebElement timeZone;
	
	@FindBy(css="input[name='address']")
	WebElement address;
	
	@FindBy(css="input[name='city']")
	WebElement city;
	
	@FindBy(css="input[name='state']")
	WebElement state;
	
	@FindBy(css="input[name='zip']")
	WebElement zipCode;
	
	@FindBy(xpath="//*[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//*[@name='hint']")
	WebElement phone;
	
	
	@FindBy(css="input[placeholder='Number']")
	WebElement number;
	
	@FindBy(css="input[placeholder='Home, Work, Mobile...']")
	WebElement mobileNumber;
	
	@FindBy(css="input[name='position']")
	WebElement position;
	
	
	@FindBy(css="input[name='department']")
	WebElement department;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[11]/div[2]/div/div/input")
	WebElement supervisor;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[12]/div[1]/div/div/input")
	WebElement assistant;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[12]/div[2]/div/div/input")
	WebElement referredBy;
	
	
	@FindBy(xpath="//*[@name='source']")
	WebElement source;
	
	@FindBy(css="input[name='identifier']")
    WebElement identifier;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[13]/div[2]/div/div/label")
	WebElement doNotCall;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[14]/div[1]/div/div/label")
	WebElement doNotText;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[14]/div[2]/div/div/label")
	WebElement doNotEmail;
	
	
	@FindBy(css="input[name='day']")
	WebElement day;
	
	@FindBy(xpath="//*[@name='month']")
	WebElement month;
	
	@FindBy(css="input[name='year']")
	WebElement year;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/i")
	WebElement searchCompany;
	
	@FindBy(css="input[name='image']")
	WebElement imageFilePath;
	
	
	
	
	
	
	
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContact()
	{
		String val="Andhukuri";
		boolean flag=true;
		flag=Utilities.fieldAlphaValidation(val);
		if(flag)
		{
			verifyContact.sendKeys(val);
			verifyContact.sendKeys(Keys.ENTER);
			
		}
		else
		{
			flag=false;
		}
		return flag;
	}
	
	
	public void clickNew()
	{
		createBtn.click();
	}
	
	 public void selectCategory(){
		 
	    driver.findElement(By.xpath("//*[@name='category']")).click();
	     
		 List<WebElement> options= driver.findElements(By.xpath("//*[@name='category']//*[@role='option']/span"));
		 
		 options.get(2).click();
		 
	
	  }
	 
	 public void selectStatus(String status1)
	 {
		 status.click();
		 
		 List<WebElement> options =driver.findElements(By.xpath("//*[@name='status']//*[@role='option']/span"));
		 
		 for(WebElement option: options)
		 {
			 if(status1.equals(option.getText()))
			 {
				 option.click();
			 }
		 }
	 }
	 
	 public void selectCountry(String countryName)
	 {
		 country.click();
		 
		 List<WebElement> options =driver.findElements(By.xpath("//*[@name='country']//*[@role='option']/span"));
		 
		 for(WebElement option: options)
		 {
			 if(countryName.equals(option.getText()))
			 {
				 option.click();
			 }
		 }
		 
	 }
	 
	 public void selectSource(String refferalName)
	 {
		 source.click();
		 
      List<WebElement> options =driver.findElements(By.xpath("//*[@name='source']//*[@role='option']/span"));
		 
		 for(WebElement option: options)
		 {
			 if(refferalName.equals(option.getText()))
			 {
				 option.click();
			 }
		 }
	 }
	 
	 public void selectSocialChannel(String channelName)
	 {
		 socialChannel.click();
		 
        List<WebElement> options =driver.findElements(By.xpath("//*[@name='channel_type']//*[@role='option']/span"));
		 
		 for(WebElement option: options)
		 {
			 if(channelName.equals(option.getText()))
			 {
				 option.click();
			 }
		 }
	 }
	 
	 public void selectTimeZone(String timeZoneName)
	 {
		 timeZone.click();
		 
	        List<WebElement> options =driver.findElements(By.xpath("//*[@name='timezone']//*[@role='option']/span"));
			 
			 for(WebElement option: options)
			 {
				 if(timeZoneName.equalsIgnoreCase(option.getText()))
				 {
					 option.click();
				 }
			 }
	 }
	 
	 public void selectPhone(String phoneCountry)
	 {
		 phone.click();
		 
	        List<WebElement> options =driver.findElements(By.xpath("//*[@name='hint']//*[@role='option']/span"));
			 
			 for(WebElement option: options)
			 {
				 if(phoneCountry.equalsIgnoreCase(option.getText()))
				 {
					 option.click();
				 }
			 }
			 
			 number.sendKeys("+91"); 
			 mobileNumber.sendKeys("7799886655");
		
	 }
	 
	 public void selectBirth()
	 {
		 day.sendKeys("6");
		 month.click();
		 
		 List<WebElement> options =driver.findElements(By.xpath("//*[@name='month']//*[@role='option']/span"));
		 
		 for(WebElement option: options)
		 {
			 if("April".equalsIgnoreCase(option.getText()))
			 {
				 option.click();
			 }
		 }
		 year.sendKeys("1988");
	 }
	 
	 public void selectCompany(String companyName) 
	 {
		 boolean flag=false;
		 
		 searchCompany.click();
		 
         List<WebElement> options =driver.findElements(By.xpath("//*[@name='month']//*[@role='option']/span"));
		 
		 for(WebElement option: options)
		 {
			 if(companyName.equalsIgnoreCase(option.getText()))
			 {
				 option.click();
				 flag=true;
			 }
		 }
		 
		/*
		 * if(!flag) { companyName.sendKeys("Akvila Company"); }
		 */
		 
		 
		 
	 }
	 
	 
	 
	
	
	public void fillContactDetails(String firstName1, String lastName1, String companyName1) throws InterruptedException, AWTException
	{
		
		Thread.sleep(1000);
		firstName.sendKeys(firstName1);
		lastName.sendKeys(lastName1);
		middleName.sendKeys("Sri");
		
		//selectCompany("Akvila");
		companyName.sendKeys(companyName1);
		//tag.sendKeys("Id");
		if(Utilities.fieldEmailValidation("abc.cde@gmail.com"))
		{
		emailAddress.sendKeys("abc@gmail.com");
		}
		personalEmailAddress.sendKeys("abc@gmail.com");
		selectCategory();
		selectStatus("Inactive");
		
		description.sendKeys("Nothing to describe");
		selectSocialChannel("LinkedIn");
		socialChannelLink.sendKeys("https://in.linkedin.com/");
		selectTimeZone("Indian/Christmas");
		selectPhone("India"); //Under code and number also can be defined in selectPhone method.
		position.sendKeys("Technical Lead");
		department.sendKeys("Tech Department");
		supervisor.sendKeys("Sharukh");
		assistant.sendKeys("RoshanAssistant");
		referredBy.sendKeys("Andhukuri");
		address.sendKeys("Kukatpally");
		city.sendKeys("Hyderabad");
		state.sendKeys("Telanagna");
		zipCode.sendKeys("500072");
		selectCountry("India");
		selectSource("Referral");
		doNotCall.click();
		identifier.sendKeys("BirthDay Certificate");
		doNotText.click();
		doNotEmail.click();
		selectBirth();
		imageSelection();
		
		
	}

	private void imageSelection() throws AWTException, InterruptedException {
		
		
		
		StringSelection sel = new StringSelection("D:\\Reports\\Images\\flowers.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		
		imageFilePath.click();
		
		
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
		
		Thread.sleep(1000);
		
		//Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		
		
		

		
		
	}
	
	

}
