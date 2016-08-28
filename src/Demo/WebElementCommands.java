package Demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.List;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.Selenium;
//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import com.thoughtworks.selenium.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.server.RemoteControlConfiguration;
public class WebElementCommands {
	
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	
	public void initiate()throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");
		WindowsUtils.tryToKillByName("chrome.exe");
		
		
		//1) Launch new Browser
		//2) Open URL http://www.toolsqa.com/automation-practice-form/
		//3) Click on the Link “Partial Link Test” (Use ‘patialLinkTest’ locator and search by ‘Partial’ word)
		//4) Type Name & Last Name (Use Name locator)
		//5) Click on Submit button (Use ID locator)
		//6) Click on the Link “Link Test” (Use ‘linkTest’ locator)
		//7) Get Page Title name and Title length
		//8) Print Page Title and Title length on the Eclipse Console.
		//9) Get Page URL and URL length
		//10)Print URL and URL length on the Eclipse Console.
		//11)Refresh current page
		//12)Get Page Source (HTML Source code) and Page Source length
		//13)Print Page Source and length on Eclipse Console.
		//14)Close the Browser.
		

		//Launching the Browser
		driver = new ChromeDriver();
		
		// Launch the ToolsQA Website or Open URL http://www.toolsqa.com/automation-practice-form/
		driver.get("http://www.toolsqa.com/Automation-practice-form/");
		
		// Click on the Link “Partial Link Test” (Use ‘patialLinkTest’ locator and search by ‘Partial’ word)
		driver.findElement(By.partialLinkText("partialLinkTest")).click();
		
		// Type Name   
		WebElement firstname= driver.findElement(By.name("firstname"));
		firstname.sendKeys("Sonam");
		
		WebElement lastname=driver.findElement(By.name("lastname"));
		lastname.sendKeys("Kalia");
		
		//5) Click on Submit button (Use ID locator)
		
		WebElement button=driver.findElement(By.id("submit"));
		button.click();
		          //OR
		//Identify Submit button with ‘tagName’, convert it in to string and print it on the console
		
		String button1=driver.findElement(By.tagName("button")).toString();
		System.out.println("Submit Button with the tag name"+button1);
		
		//Click on the Link “Link Test” (Use ‘linkTest’ locator)
		driver.findElement(By.linkText("linktext")).click();
		
		//Get Page Title name and Title length
		String title=driver.getTitle();
		int titlelength =driver.getTitle().length();
		
		//Print Page Title and Title length on the Eclipse Console.
		
		System.out.println("Page title is "+title);
		System.out.println("Page length is "+titlelength);
		
		//Refresh current page
		//Refresing the Page in 5 ways:
		driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		driver.findElement(By.name("sonam")).sendKeys(Keys.F5);
		driver.navigate().to(driver.getCurrentUrl());
		driver.findElement(By.name("sonam")).sendKeys("\uE035");
		
		// Get Page Source (HTML Source code) and Page Source length
		
		String pagesource=driver.getPageSource();
		System.out.println("pagesource is "+pagesource);
		
		int pagesourcelength=driver.getPageSource().length();
		System.out.println("Page Source Length is "+pagesourcelength);
		
		//close the browser
		
		driver.close();
		
		//Browser Navigation Commands
		
		//1) Launch new Browser
		//2) Open Toolsqa.com website 
		//3) Click on About link ( On top navigation) 
		//4) Come back to Home page (Use ‘Back’ command) 
		//5) Again go back to About page (This time use ‘Forward’ command)
		//6) Again come back to Home page (This time use ‘To’ command) 
		//7)vRefresh the Browser (Use ‘Refresh’ command) 
		//8) Close the Browser
		
		//Launch new Browser
		
		driver=new ChromeDriver();
		
		// Open Toolsqa.com website 
		driver.navigate().to("http:www.google.com");
		
		//Click on About link ( On top navigation) 
		driver.findElement(By.linkText("About")).click();

		//Come back to Home page (Use ‘Back’ command)
		
		driver.navigate().back();
		
		//Again go back to About page (This time use ‘Forward’ command)
		
		driver.navigate().forward();
		
		// Go back to Home page
		
		driver.navigate().to("http::google.com");
		
		//Refresh the browser
		
		driver.navigate().refresh();
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
				
	}

}
