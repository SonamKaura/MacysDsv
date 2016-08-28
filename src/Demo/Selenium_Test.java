package Demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_Test {
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	
		@BeforeTest
		public void initiate() throws InterruptedException
		{
		//code to run the chrome
		
		System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");
		WindowsUtils.tryToKillByName("chrome.exe");
		driver = new ChromeDriver();
		driver.get("http:google.com");
				
		}
	
	@Test
	public void selenium_method() throws Exception
	{
		
		/*//Not clear
		List <WebElement> links=driver.findElements(By.xpath("//div[@class='header-top']//div"));
		System.out.println("The list is "+links);
		assertsEquals(3,links.size());
		
		WebElement gmailLink = driver.findElement(By.linkText("GMail"));
		assertsEquals("http://mail.google.com/",gmailLink.getAttribute("href"));
		
		WebElement inboxLink=driver.findElement(By.partialLinkText("Inbox"));
		System.out.println(inboxLink.getText())*/;
		
		// Calling the method to take the screenshot 
		Selenium_Test st=new Selenium_Test();
		st.getscreenshot();
		//Calling IsElementPresentMethod()
		st.TestisElementpresent();
		//callin alert method()
		st.alerts();
		}
		
	public void getscreenshot() throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png" of the "google.com"
         // that we specified in driver.get("http:google.com");
            FileUtils.copyFile(scrFile, new File("D:\\PICS\\screenshot.png"));
    }
	
	public void TestisElementpresent()throws InterruptedException
	{
		//Check if element with locator criteria exists on Page
		if(isElementPresent(By.xpath("//a[text()='Gmail']")));
		{
		System.out.println("Element is present");
		//click on gmail
		WebElement gmail=driver.findElement(By.xpath("//a[text()='Gmail']"));
		gmail.click();
		System.out.println("Element is clciked");
		}
		}
	
	public void alerts()throws InterruptedException
	{
		//get the alert
		Alert alert=driver.switchTo().alert();
		//get the text displayed on alert by usin getText () method of the alert class
		String Textalert=alert.getText();
		//clicking on ok button by calling accept() method of the alert class
		alert.accept();
		//Verify alert is dispalyed correct message to the user.
		assertsEquals("Msg is saved",Textalert);
	}

	private boolean isElementPresent(By xpath) {
		// TODO Auto-generated method stub
		return false;
	}

	private File newFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private void assertsEquals(String string, String attribute) {
		// TODO Auto-generated method stub
		
	}

	private void assertsEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
	}