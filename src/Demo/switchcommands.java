package Demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class switchcommands {
	
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	
	@BeforeTest
	
		public void initiate()throws InterruptedException
		{
		/*System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");*/
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		// Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Launch the URL
        driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
		}

	@Test
		public void Whandler() throws InterruptedException
		{
		//windowhandle1();
		windowhandle2();
		}
	
	public void windowhandle1() throws InterruptedException
	{
	/*	1.Get Window name (Use GetWindowHandle command)
		2.Click on Button �New Message Window�, it will open a Pop Up Window
		3. Get all the Windows name ( Use GetWindowHandles command)
		4. Close the Pop Up Window (Use Switch Command to shift window)*/
		
		//Get Window name (Use GetWindowHandle command) ie Store and Print the name of the First window on the console
		String window=driver.getWindowHandle();
		System.out.println(window);
		
		//Click on Button �New Message Window�, it will open a Pop Up Window
		WebElement newmessagebutton =driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]"));
		newmessagebutton.click();
		// Store and Print the name of all the windows open	
		Set<String> allwindows=driver.getWindowHandles();
		System.out.println(allwindows);
		
		// Close the Pop Up Window (Use Switch Command to shift window)
        // ie pass the window handle to other window
		
		for(String handle1:allwindows)
		{
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		
		//Close the Pop Up Window ie driver.close() closes the current window
		driver.close();
		
		// Close Original window
		 driver.quit();
		
	}
	
	public void windowhandle2()throws InterruptedException
	{
	
		/*1) Launch new Browser
		2) Open URL �http://www.toolsqa.com/automation-practice-switch-windows/�
		3) Click on Button �Alert Box�, it will open a Pop Up Window generated by JavaScript
		4) Switch to Alert window (Use �SwitchTo()Alert() command)
		5) Close the Pop Up Window (Use Accept command)
		*/
		
		WebElement alert=driver.findElement(By.id("alert"));
		alert.click();
		
		System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
		 
        // Create new WebDriver wait
 
        WebDriverWait wait = new WebDriverWait(driver, 20);
 
        // Wait for Alert to be present
 
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
 
        System.out.println("Either Pop Up is displayed or it is Timed Out");
 
		
	    Alert myalert=driver.switchTo().alert();
	    myalert.accept();
	    driver.close();
	 
	}
	
	}

