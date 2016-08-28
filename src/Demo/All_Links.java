package Demo;

import org.testng.annotations.Test;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.opera.core.systems.scope.protos.UmsProtos.Command;


public class All_Links {
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	
	@BeforeTest
	public void initiate()throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.toolsqa.com/");
		}
	
	@Test
	public static void links()throws InterruptedException
	{
		
		 /*1.Navigate to the interested webpage for e.g. www.toolsqa.com.
		 2) Create a list of type WebElement to store all the Link elements in to it.
		 3) Collect all the links from the webpage. All the links are associated with the Tag ‘a‘.
		 4) Now iterate through every link and print the Link Text on the console screen.*/
		 
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		int size=links.size();
		System.out.println("Size is "+size);
		//Now iterate through every link and print the Link Text on the console screen
		for(int i=0;i<size;i++)
		{
			System.out.println("Link Text on console is"+links.get(i).getText());
		}
		}
}
