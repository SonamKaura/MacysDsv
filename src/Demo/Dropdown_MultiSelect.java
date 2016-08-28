package Demo;

import org.testng.annotations.Test;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Dropdown_MultiSelect {
	
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	
	@BeforeTest
	public void initiate()throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.toolsqa.com/automation-practice-form/");
		}
	
	
	@Test
	public void Excecution_DropdownMultiselect() throws InterruptedException
	{
		//dropdown();
		Thread.sleep(5000);
		multiselect();
	}
	
	public void dropdown()throws InterruptedException
	{
		/*1) Launch new Browser
		2) Open “http://www.toolsqa.com/automation-practice-form/”
		3) Select ‘Continents’ Drop down ( Use Id to identify the element )
		4) Select option ‘Europe’ (Use selectByIndex)
		5) Select option ‘Africa’ now (Use selectByVisibleText)
		6) Print all the options for the selected drop down and select one option of your choice
		7) Close the browser*/
		
		Select continent=new Select(driver.findElement(By.id("continents")));
		continent.selectByIndex(1);
		System.out.println("Europe is selected");
		Thread.sleep(4000);
		continent.selectByVisibleText("Africa");
		
		// Get the size of the Select element
		List continentsize=continent.getOptions();
		System.out.println("List is"+continentsize);
		int size=continentsize.size();
		System.out.println("Size is "+size);
		
		//setting the loop to print all the options for the selected drop down 
		for(int i=0;i<size;i++)
		{
			//storing the value in the string
			String alloptions=continent.getOptions().get(i).getText();
			System.out.println("All Options are"+alloptions);
			
			// Putting a check on each option that if any of the option is equal to 'Africa" then select it
			if (alloptions.equals("Africa"))
			{
				continent.selectByIndex(2);
				break;
			}
				}
		
	//Kill the Browser
		driver.close();
	}
	
	public static void multiselect()throws InterruptedException
	{
		/*1) Launch new Browser
		2) Open “http://www.toolsqa.com/automation-practice-form/”
		3) Select ‘Selenium Commands’ Multiple selection box ( Use Name locator to identify the element )
		4) Select option ‘Browser Commands’  and then deselect it (Use selectByIndex and deselectByIndex)
		5) Select option ‘Navigation Commands’  and then deselect it (Use selectByVisibleText and deselectByVisibleText)
		6) Print and select all the options for the selected Multiple selection list.
		7) Deselect all options
		8) Close the browser*/
		try
		{
		Select Commands=new Select (driver.findElement(By.name("selenium_commands")));
		Commands.selectByIndex(0);
		System.out.println("Browser Command is selected");
		Thread.sleep(4000);
		Commands.deselectByIndex(0);
		
		Commands.selectByVisibleText("Navigation Commands");
		System.out.println("Navigation Command is selected");
		Thread.sleep(4000);
		Commands.deselectByVisibleText("Navigation Commands");
		
		//Getting all the options in a List
		List sizeoption=Commands.getOptions();
		//Storing the size
		int size=sizeoption.size();
		for(int i=0;i<size;i++)
		{
			//Print all the options
			String alloptions=Commands.getOptions().get(i).getText();
			System.out.println("All options are :"+alloptions);
			//select all the options in the dropdown
			Commands.selectByIndex(i);
			Thread.sleep(4000);
			
		}
		Commands.deselectAll();
		System.out.println("Deselected all the Options");
		//Kill the Browser
		driver.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
		}
		
		 WebElement From = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[1]/a/span"));
		 WebElement To = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[4]/a/span"));
		 Actions builder = new Actions(driver);
		 Actions dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To);
		 dragAndDrop.build();
	}
	}
		
	

