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
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.testng.annotations.BeforeTest;

public class Radiobuttons_checkboxes {
	
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	
	@BeforeTest
	public void initiate()throws InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver",
		"C://Program Files (x86)//Google//Chrome//chromedriver.exe");
		driver = new ChromeDriver();*/
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.toolsqa.com/automation-practice-form/");
		
	}
	
	@Test
	public void radiochecbox() throws InterruptedException
	{
		
	/*	1) Launch new Browser 
		2) Open “http://www.toolsqa.com/automation-practice-form/” 
		3) Select the deselected Radio button (female) for category Sex (Use IsSelected method) 
		4) Select the Third radio button for category ‘Years of Exp’ (Use Id attribute to select Radio button) 
		5) Check the checkbox ‘Automation Tester’ for category ‘Profession'( Use Value attribute to match the selection) 
		*/
		
		femaleradiobtn();
		yrsexpradiobtn();
		professionchkbx();
	}
	
	public void femaleradiobtn()throws InterruptedException
	{
		
		//3) Select the deselected Radio button (female) for category Sex (Use IsSelected method) 
		List <WebElement> radiobutton1= driver.findElements(By.name("sex"));
		for (WebElement radiobtns1:radiobutton1)
		{
			try{
				if (radiobtns1.getAttribute("Value").equals("Female"))
				//if(radiobtns.findElement(By.id("sex-1")).equals("sex-1"))
				{
					System.out.println("Inside if value=attribute");
					if(!radiobtns1.isSelected())
					{
						radiobtns1.click();
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
			}
				}
	}
	
	public void yrsexpradiobtn()throws InterruptedException
	{
		//4) Select the Third radio button for category ‘Years of Exp’ (Use Id attribute to select Radio button)
		List <WebElement> radiobutton2=driver.findElements(By.name("exp"));
		for(WebElement radiobtn2:radiobutton2)
		{
			if(radiobtn2.getAttribute("Value").equals("3"))
					{
						if (!radiobtn2.isSelected())
						{
							radiobtn2.click();
							break;
						}
					}
		}
	}
	
	public void professionchkbx()throws InterruptedException
	{
		try{
		//5)Check the checkbox ‘Automation Tester’ for category ‘Profession'( Use Value attribute to match the selection)
		List <WebElement> checkbox1=driver.findElements(By.name("profession"));
		for (WebElement chkbx1:checkbox1)
		{
			if(chkbx1.getAttribute("value").equals("Automation Tester"))
			{
				System.out.println("checkbox value is "+chkbx1);
				if(!chkbx1.isSelected())
				{
					chkbx1.click();
					break;
				}
			}
		}
		}
		
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
		}
		
	}
	
	
	}


