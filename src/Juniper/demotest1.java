package Juniper;
import java.awt.Label;
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

public class demotest1 {
	
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private DataFormatter formatter;
	//private String currentrowurl;
	List data = new ArrayList();
		
	@BeforeTest
	
	//Return Return type of this method is List  and it wll return List
	public List ReadExcel() throws IOException, InterruptedException
	{
			
		FileInputStream file=new FileInputStream("D:\\Idnentiy_policy_juniper.xlsx");
		System.out.println("File done");
		Thread.sleep(5000);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("IdentiStypolicy");//through getsheet we are able to access the sheet

		//Find number of rows in excel file
		
		int rowCount = sheet.getLastRowNum();
		//Creating a List "data"
		//List data = new ArrayList();
		//row count is 136 as in excel we count from index which is 0 so we used getLastRowNum
		System.out.println("Row Count is "+rowCount);
		//Create a loop over all the rows of excel file to read it ie we used rowCount+1 coz rowCount is 136 but total size of 
		//sheet is 137 ie loop will go for 137 times
		for (int i = 0; i < rowCount+1; i++) 
		{
			System.out.println("inside i loop"+i);
			if(sheet.getRow(i)!=null)
			{
				//with getRow = cusror is at row 
				//get cell()=cursor is at 0th column of the sheet
				//getStringValue= we are able to read the string placed in specific row and column (cell)
				System.out.println("row value is "+sheet.getRow(i).getCell(0).getStringCellValue());
				String currentrowurl;
				currentrowurl=sheet.getRow(i).getCell(0).getStringCellValue();
				System.out.println("Current row value"+currentrowurl);
				
				//Adding the data in the list
				System.out.println("Data added in the list is "+data.add(currentrowurl));
				
						 	}
					}
		return data;						
	}
	
	@Test
	public List Check_brokenlinks()throws InterruptedException
	{	
		//creating an object of brokenlink_Httprequest 
		demotest1 brokHttp=new demotest1();	
		//Since we want to use the List data that is defined in an ReadExcel Class so we have to create an object of  brokenlink_Httprequest
		List<WebElement> allImages =brokHttp.data; 
	
		 System.out.println("Total number of elements found " + allImages.size());
		  for( WebElement element : allImages){
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
		return allImages;
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
