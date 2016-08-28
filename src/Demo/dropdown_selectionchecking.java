package Demo;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import java.awt.List;
import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 @Test
public class dropdown_selectionchecking {
	
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	


 @BeforeTest
 public void dropdown()throws InterruptedException
 {
	 System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http:macys.com");
	 
  }
 
 public void dropdown_checking() throws InterruptedException
 {

	    driver.findElement(By.id("globalMastheadSignIn"));
		WebElement signin = driver.findElement(By.id("globalMastheadSignIn"));
		signin.click();
		Thread.sleep(20000);
		WebElement create = driver.findElement(By.id("createProfileContainer"));
		create.click();
		Thread.sleep(5000);
		Select gen=new Select(driver.findElement(By.xpath("	//select[@id='gender']")));
		
		//verify drpdown doesnot supports multiple selection
		AssertJUnit.assertFalse(gen.isMultiple());
		
		//verify dropdown has 2 values for selection
		AssertJUnit.assertEquals(2,gen.getOptions().size());
		
		// Checking the Selected Option in Dropdown ie with Select class we can select an option in Dropdown using Visible Text
		//1.
		gen.selectByVisibleText("Female");
		AssertJUnit.assertEquals("Female", gen.getFirstSelectedOption().getText());

		//Checking the Selected Option in Dropdown ie or we can select an option in Dropdown using value attribute
		//2.
		gen.selectByValue("Female");
		AssertJUnit.assertEquals("Female", gen.getFirstSelectedOption().getText());
		
		//Checking the Selected Option in Dropdown ie or we can select an option in Dropdown using index
		//3.
		gen.selectByIndex(0);
		AssertJUnit.assertEquals("Female", gen.getFirstSelectedOption().getText());
		
		
		//we will verify dropdown has expected value listed in an array
		//List<String> expected_option=Arrays.asList (new String[]{"Male","Female"});
		
	
	 }

private void assertEquals(String string, String text) {
	// TODO Auto-generated method stub
	
}

private void assertTrue(int i, int size) {
	// TODO Auto-generated method stub
	
}

private void assertFalse(boolean multiple) {
	// TODO Auto-generated method stub
	
}
 }
