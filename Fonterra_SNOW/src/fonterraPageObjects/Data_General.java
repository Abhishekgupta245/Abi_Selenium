package fonterraPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Data_General 
{
	
	WebDriver driver;
	
//Locating the fields in the form	
	public static   By requesterName=By.xpath(".//*[@id='select2-chosen-1']");
	public static   By enterDetail=By.cssSelector("#sp_formfield_Request_detail");
	public static   By enterAdditionalInfo=By.xpath("//*[@id='sp_formfield_Additional_information']");
	public static   By submitButton=By.cssSelector("[name='submit']");
	public static   By newRITMLink=By.xpath("//a[contains(text(),'Click here to view:')]");
    public static   By addCustComment=By.cssSelector("#post-input");
    public static	By custCommentSendButton=By.cssSelector("#sand > div > span.input-group-btn > input");
    public static 	By getAnUpdateButton=By.cssSelector("#accordion > div.panel.panel-default.ng-scope > div > button > span");
    public static	By loggedInUser=By.xpath("//*[@id='sp-nav-bar']/ul[2]/li[1]/a/span[2]");
	public Data_General(WebDriver driver)
	{
	this.driver=driver;
	}
	
/*The below method clicks on the Requester field, selects a username from the dropdown and
  then tabs to another field to load the value in the requester field..*/
	
	public void enterValueinRequesterField(String value) throws InterruptedException
	
	{
		driver.findElement(By.cssSelector("#s2id_sp_formfield_affected_contact > a")).click();
		driver.findElement(By.cssSelector("#s2id_autogen1_search")).sendKeys(value);
		Thread.sleep(200);
		driver.findElement(By.cssSelector("#s2id_autogen1_search")).sendKeys(Keys.TAB);
		
		

	}
	
//	driver.findElement(enterDetail).sendKeys("This is test detail");
//	driver.findElement(enterAdditionalInfo).sendKeys("This is test Additional Information");
//	driver.findElement(submitForm).click();
//	driver.findElement(By.xpath("//a[contains(text(),'Click here to view:')]")).click();
		
}
