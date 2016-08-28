package Juniper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.opera.core.systems.scope.protos.UmsProtos.Command;

public class brokenlinks_HTTPResponse {
	
	private static final WebElement WebElement = null;
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	List <WebElement> links = new ArrayList();
	
	@BeforeTest
	public void initiate()
	{
		System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.juniper.net/us/en/");
		driver.manage().window().maximize();
	}
	
	@Test
	//Method will get all the links from Identity and Policy Control
	public void all_links_idntypolicy()throws Exception
	{
		//Product and Services mouse overbb
		Actions action = new Actions(driver);
		WebElement product=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
		action.moveToElement(product).build().perform();
		System.out.println("Mouse Over done");

		WebElement identypolicycontrol=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		identypolicycontrol.click();
		Thread.sleep(8000);

		//Getting all the links on a Webpage "Identity and Control" by driver.findElements(By.tagName("a")) and putting
		//them in a List named "links"
		links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of elements found " + links.size());
		
		try
		{
			Check_brokenlinks();
			System.out.println("Calling thecheck broken method");
		}
		
		catch(Exception e)
		{
			System.out.println("exception is"+e);
		}
	}

	
	public void Check_brokenlinks()
		
	{	
		System.out.println("inside checkvgbncgvnbgvnv nnh");
		for( WebElement element : links){
			try
			{
				//creatin new url
				URL url=new URL(element.getAttribute("href"));
				System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(url));
				//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
			}
			catch(Exception exp)
			{
				System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());       
			}
		}
	}
	
	public static String isLinkBroken(URL url) throws Exception
	{
		//url = new URL("http://yahoo.com");
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
			connection.connect();
			response = connection.getResponseMessage();         
			connection.disconnect();
			return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}      
	}

}

