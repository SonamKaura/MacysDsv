package Juniper;
import org.testng.annotations.Test;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.opera.core.systems.scope.protos.UmsProtos.Command;

//Prog is to Read all the urls from the Excel Sheet
public class Read_identitypolicycontrol {


	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
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
	public void Read()throws InterruptedException, IOException
	{
		FileInputStream file=new FileInputStream("D:\\Idnentiy_policy_juniper.xlsx");
		System.out.println("File done");
		Thread.sleep(5000);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("IdentiStypolicy");//through getsheet we are able to access the sheet

		//Find number of rows in excel file
		
		int rowCount = sheet.getLastRowNum();
		//row count is 136 as in excel we count from index which is 0 so we used getLastRowNum
		System.out.println("Row Count is "+rowCount);

		//Create a loop over all the rows of excel file to read it ie we used rowCount+1 coz rowCount is 136 but total size of 
		//sheet is 137 ie loop will go for 137 times
		for (int i = 0; i < rowCount+1; i++) 
		{
			System.out.println("inside i loop");
			if(sheet.getRow(i)!=null)
			{
				//with getRow = cusror is at row 
				//get cell()=cursor is at 0th column of the sheet
				//getStringValue= we are able to read the string placed in specific row and column (cell)
				System.out.println("row value is "+sheet.getRow(i).getCell(0).getStringCellValue());
					
			}
			
		}
	}
}
