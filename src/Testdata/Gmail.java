package Testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//Reading the Excel file and placing in the values of Username and Password in Gmail
//Install Jar:xmlbeans-2.3.0
public class Gmail {
	
		private FileInputStream file;
		private XSSFWorkbook workbook;
		private XSSFSheet sheet;
		private XSSFCell cell;
		private DataFormatter formatter;
		WebDriver driver;
		String gmail;
		
		@BeforeSuite
		void initialize()
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			gmail="https://www.gmail.com";
			
		}
		public void setExcel(String path,String sheetname)
		{
			try{
			
			file=new FileInputStream(path);
			System.out.println("Path ==="+path+" ==== sheetname ==== "+sheetname);
			workbook=new XSSFWorkbook(file);
			System.out.println("workbook : "+workbook);
			sheet=workbook.getSheet(sheetname);
			}
			catch (Exception e) {
				System.out.println("Exception : "+e.getMessage());
			}
		}
		
		public String getCellValue(int row,int col)
		{
			cell=sheet.getRow(row).getCell(col);
			formatter=new DataFormatter();
			return formatter.formatCellValue(cell);
		}	
		
		@Test
		public void initiate() throws IOException
		{
			driver.get(gmail);
			setExcel("D:\\Sonam.xlsx", "Sheet1");
			System.out.println("====Last row===="+sheet.getLastRowNum());
			int rows=sheet.getLastRowNum()+1;
			int cols=sheet.getRow(0).getLastCellNum();
			System.out.println(rows);
			System.out.println(cols);
			//loop for rows and started with 1 as in "0" position we dont want values we want values starting 
			//from 1st column
			for(int i=1;i<rows;i++)
			{
				//initialize an array with size 2
				String a[]=new String [2];
				System.out.println("Array initialized with"+cols);
				//j loop for columns and starting from 0 as 
				for(int j=0;j<cols;j++)
				{
					a[j]=getCellValue(i,j);
				}
				driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(a[0]);
				driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(a[1]);
			
			}
					}
}

