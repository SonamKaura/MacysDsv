package Juniper;
import org.testng.annotations.Test;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.opera.core.systems.scope.protos.UmsProtos.Command;


//Prog is to get all the links on a Webpage "Identity and Policy Control" and print/Write them on 
//Excel Sheet

public class Identity_Policycontrol {

	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFCell cell;
	private DataFormatter formatter;

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
	
	//Method will get all the links from the webpage "Identiy and Policy Control"
	public void all_links_idntypolicy()throws InterruptedException, IOException
	{
		//Product and Services mouse over
		Actions action = new Actions(driver);
		WebElement product=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
		action.moveToElement(product).build().perform();
		System.out.println("Mouse Over done");

		WebElement identypolicycontrol=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		identypolicycontrol.click();
		Thread.sleep(8000);

		//Getting all the links on a Webpage "Identity and Control" and printing them
		List <WebElement> links=driver.findElements(By.tagName("a"));
		int size=links.size();
		System.out.println("Links size is "+size);
		/*for (int i =1;i<=size;i++)
		{
			System.out.println("value of i is"+i);
			System.out.println(links.get(i).getAttribute("href"));
		}*/
		
		//By this method what all links we got now we are writing in an excel sheet
		SimpleExcelWriterExample();
		
	}

	//Method all the links will be written in an excel sheet
	public void SimpleExcelWriterExample() throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement product=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
		action.moveToElement(product).build().perform();
		System.out.println("Mouse Over done");

		WebElement identypolicycontrol=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		identypolicycontrol.click();
		Thread.sleep(8000);
		
		List <WebElement> links=driver.findElements(By.tagName("a"));
		int size=links.size();
		System.out.println("Size is "+size);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("IdentiStypolicy");
		 int rowCount = 0;
			   for (int i =1;i<=size;i++)
        	   {
        		   System.out.println("value of i"+i);
        		  
        		   int columnCount = 0;
        		   
        		   //By this each link will be added in a different row
        		   Row row = sheet.createRow(++rowCount);
        		   //by links.get(i).getAttrivute("href") =the link.get(1).getAtrribute("href) ie 1st links href value will be stored in a String href
        		   String href= links.get(i).getAttribute("href");
        		   //By this each link will be added in a column 1
        	       Cell cell = row.createCell(columnCount);
        	       //By this line we are writing a value in an excel sheet
        	       cell.setCellValue(href);
                   try  
                   {
                	FileOutputStream out = new FileOutputStream(new File("D:\\Idnentiy_policy_juniper.xlsx"));
                   	workbook.write(out);
                	                   }
                   	catch (Exception e)
                   {
                       e.printStackTrace();
                   }
        	   }      
	}
	
	}









