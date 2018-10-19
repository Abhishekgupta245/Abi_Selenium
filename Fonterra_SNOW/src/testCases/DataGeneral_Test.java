package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import fonterraPageObjects.Data_General;

public class DataGeneral_Test 
{
	
	
	
	
	@Test (priority=1,description="Fill the form values and submit the form")
	public void submitDataGeneralForm() throws InterruptedException
	{
	//Setting the location of Internet Explorer driver
		System.setProperty("webdriver.ie.driver","C:\\Users\\guptaab1\\Selenium Work\\GSDE_Workspace\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		Data_General form = new Data_General(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
	//Maximize the browser window before running the tests
		driver.manage().window().maximize();
		
	// Open Data General Form
		String formURL = ("https://fonterrauat.service-now.com/sp?id=sc_cat_item&sys_id=a0a7a8310cb9d200c2b5d022fe94d361");
		driver.get(formURL);

//		Data_General form = new Data_General(driver);
		
	// Enter the value in 'Who is this request for' field and verify the value
		String requesterName = "Julia Blithe";
		form.enterValueinRequesterField(requesterName);
		String txt=driver.findElement(By.cssSelector("#select2-chosen-1")).getText();
		Assert.assertEquals(requesterName, txt);
		
	// Enter the value in the details and Additional Info fields
		driver.findElement(Data_General.enterDetail).sendKeys("Adding detail of the ticket through automated test");
		driver.findElement(Data_General.enterAdditionalInfo).sendKeys("Adding Additional info through automated test");
	
	// Submit the form	
		driver.findElement(Data_General.submitButton).click();
		System.out.println("Data General Form submitted successfully");
		
	//Click on the new RITM link generated in the message pop up window to open the newly created RITM
		driver.findElement(Data_General.newRITMLink).click();
		
	// Add customer comment and verify
		String CustCommentText = "Adding customer comment";
		driver.findElement(Data_General.addCustComment).sendKeys(CustCommentText);
		driver.findElement(Data_General.custCommentSendButton).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='scroll']/ul/li[1]/div[2]/div/div[2]/p")).getText(), CustCommentText);
		System.out.println("Customer comment added and verified successfully");
	
	// Click on Get and update button and verify 
		driver.findElement(Data_General.getAnUpdateButton).click();
		Thread.sleep(500);
		String getUpdateText=(driver.findElement(Data_General.loggedInUser).getText() + " has escalated this request. Please contact the customer with an update.");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='scroll']/ul/li[1]/div[2]/div/div[2]/p")).getText(), getUpdateText);
		System.out.println("Update requested successfully and verified");
	}
	

	
	
}
