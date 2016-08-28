package Demo;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandler {
	
	public static  RemoteControlConfiguration rc;
	public static WebDriver driver;
	
	@BeforeTest
	
	public void initiate() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");
		WindowsUtils.tryToKillByName("chrome.exe");
		driver = new ChromeDriver();
		driver.get("http:macys.com");
		Thread.sleep(8000);
	}
	
	
	@Test
	public void windowhandler()throws InterruptedException
	{
		windowhandler1();
		
	}
	
	public void windowhandler1()throws InterruptedException
	{
		//Save the WindowHandle of Parent Browser Window
		String currentWindowId = driver.getWindowHandle();
		// clicking on exclusion and details on the homepage of macys.com
		WebElement exanddetails = driver.findElement(By.xpath(".//*[@id='row1_column1']/div/map[1]/area"));
		exanddetails.click();
		Alert alert=driver.switchTo().alert();
		// to get the text of the alert
		String Textalert=alert.getText();
		alert.accept();
		assertEquals("Msg Saved Successfully",Textalert);

		//Get Handles of all the open Popup Windows
		//Iterate through the set and check if tile of each window matches
		//with expected Window Title
		Set<String> allWindows = driver.getWindowHandles();
		if(!allWindows.isEmpty()) {
		for (String windowId : allWindows) {
		driver.switchTo().window(windowId);
		if(driver.getPageSource().contains("exclusions and details"))
		{
			try
			{
				WebElement closeButton = driver.findElement(By.xpath("//div[@class='popupContainer popupContainerIni']/div[4]//a[2]/img"));
				closeButton.click();
			}
			catch(Exception e) {
				e.printStackTrace();
				}
					}
			}
				}
		//Move back to the Parent Browser Window
		driver.switchTo().window(currentWindowId);
	}
	
	

	private void assertEquals(String string, String textalert) {
		// TODO Auto-generated method stub
		
	}
	}

	
	
	

		
			
	
		
		


