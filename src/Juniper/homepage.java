package Juniper;

import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class homepage {
	public static RemoteControlConfiguration rc;
	public static WebDriver driver;
	// declaration of class variable
	private int rowCount;
	private int rowCount1;
	private int rowCount2;
	private int rowCount3;
	
	
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
	public void homepagetest()throws InterruptedException
	{
		/*System.out.println("inside test");
		WebElement search= driver.findElement(By.xpath("//div[@class='header-search-wrapper']/form/div/a/div"));
		search.click();
		Thread.sleep(6000);
		WebElement search1= driver.findElement(By.xpath("//input[@class='header-search-input']"));
		search1.click();
		search1.sendKeys("support");
		search.click();
		Thread.sleep(8000);
		
	    int rowCount1=driver.findElements(By.xpath("//div[@class='wrapper']/div/div/div[2]/div[1]/div[@class='slider-control-inner-wrapper']/span")).size();
	    System.out.println("Row Count is "+rowCount1);
	    
	    for (int j=1;j<=rowCount1;j++)
	    {
	    	WebElement slidercontrol=driver.findElement(By.xpath("//div[@class='wrapper']/div/div/div[2]/div[1]/div[@class='slider-control-inner-wrapper']/span["+j+"]"));
	    	slidercontrol.click();
			Thread.sleep(5000);

			WebElement learnmorelink=driver.findElement(By.xpath("//div[@class='wrapper']/div/div[1]/div[1]/div["+j+"]/div/a"));
			learnmorelink.click();
			System.out.println("LearnMore link 1 is clicked");
			Thread.sleep(5000);
		
			// We are taking all the window handle in array list (Code to switch in newwindow)
			ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
			// through this we are switching it to tab 2( the url from where learn more is opened).
			driver.switchTo().window(windowHandle.get(1));
			//closing tab 2 
			driver.close();
			// sswitching to tab 1 ie original url
	    	driver.switchTo().window(windowHandle.get(0));
	    
	    }
	    
		WebElement help=driver.findElement(By.xpath("//a[contains(text(),'How can we help')]"));
		help.click();
		System.out.println("Help is clicked");
		Thread.sleep(8000);
		
		WebElement juniperlogo=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
		juniperlogo.click();
		System.out.println("Juniper logo is clicked");
		Thread.sleep(8000);
	
		WebElement starthere=driver.findElement(By.xpath("//a[contains(text(),'Start Here')]"));
		starthere.click();
		System.out.println("starthere is clicked");
		Thread.sleep(8000);
		
		WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
		juniperlogo1.click();
		System.out.println("Juniper logo is clicked");
		Thread.sleep(8000);
		
		int rowCount2=driver.findElements(By.xpath("//div[@class='swipe jnpr-slider jnpr-slider-dots jnpr-slider-arrows-none clearfix']/div[2]/div[1]/div/span")).size();
		System.out.println("Row Count is "+rowCount2);
		for (int k=1;k<=rowCount2;k++)
		{
			WebElement promo2sledercontrol=driver.findElement( By.xpath("//div[@class='swipe jnpr-slider jnpr-slider-dots jnpr-slider-arrows-none clearfix']/div[2]/div[1]/div/span["+k+"]"));
			promo2sledercontrol.click();
			Thread.sleep(8000);
			WebElement Readnow= driver.findElement(By.xpath("//div[@class='slice-item cf homepage-promos']/div/div/div[1]/div["+k+"]/a/div"));
			Readnow.click();
			System.out.println("readnow is clicked");
			Thread.sleep(8000);
			
			ArrayList<String> windowHandle4 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(windowHandle4.get(1));
		    driver.close();
		    driver.switchTo().window(windowHandle4.get(0));
			}
		int rowCount = driver.findElements(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[2]/div/div/div")).size();
		System.out.println("row Count is"+rowCount);
		
		if (rowCount>0)
		{
			WebElement news=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[1]/div/a"));
			news.click();
			 WebElement juniperlogo2=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			 juniperlogo2.click();
			 System.out.println("Juniper logo is clicked");
			 Thread.sleep(8000);
			 for (int i=1;i<=rowCount;i++)
			 	{
				System.out.println("the value of i is "+i);
					try
					{
						if(i==3)
						{
							WebElement navigate=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
							navigate.click();
							Thread.sleep(3000);	
						}
						if(i==4)
						{
							WebElement navigate1=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
							navigate1.click();
							Thread.sleep(3000);	
							WebElement navigate2=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
							navigate2.click();
							Thread.sleep(3000);	
						}
						if(i==5)
						{
							WebElement navigate1=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
							navigate1.click();
							Thread.sleep(3000);	
							WebElement navigate2=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
							navigate2.click();
							Thread.sleep(3000);	
							WebElement navigate3=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
							navigate3.click();
							Thread.sleep(3000);	
						}
					//dynamic xpath of the media advisory link
					String xpathForMediaAdv="//div[@class='news-ticker-wrapper']/ul/li[2]/div/div/div[" + i+ "]/a";
					System.out.println("xpathForMediaAdv : "+xpathForMediaAdv);
					WebElement mediaadvisory=driver.findElement(By.xpath(xpathForMediaAdv));
					mediaadvisory.click();
					Thread.sleep(6000);
					}
					catch(Exception e)
					{
						System.out.println("Exception is "+e);
					}
					WebElement juniperlogo3=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
					juniperlogo3.click();
					System.out.println("Juniper logo is clicked");
					Thread.sleep(8000);
					WebElement navigate=driver.findElement(By.xpath("//div[@class='news-ticker-wrapper']/ul/li[3]/a[2]/i"));
					navigate.click();
					Thread.sleep(3000);
									}
		}
	    //Mouse Over over Product and Services	 
		Actions action = new Actions(driver);
		WebElement productservices= driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
		action.moveToElement(productservices);
		action.perform();
		System.out.println("product and services mouse over done ");
		
		//Mouse Over Support
		WebElement Support= driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[2]/a"));
		action.moveToElement(Support);
		action.perform();
		System.out.println("Support mouse over done");
		
		//Mouse Over Traning
		WebElement Traning= driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[3]/a"));
		action.moveToElement(Traning);
		action.perform();
		System.out.println("Traning mouse over done");
		
		Thread.sleep(8000);
		solutions();
		Thread.sleep(7000);
		solutions();
		AbtJuniper();
		Patners();
		community();*/
		
		//footer();
		header();
	}
	
	/*
	//Solution Footer
	public void solutions()throws InterruptedException
	{
		WebElement solutions=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[1]/a"));
		solutions.click();
		Thread.sleep(4000);
		int rowCount3=driver.findElements(By.xpath("//div[@class='pas-list-container slice-3col']/div[1]/div/ul[1]/li")).size();
		System.out.println("Row Count 3 is "+rowCount3);
		Thread.sleep(8000);
		for (int l=1;l<=rowCount3;l++)
		{
		
			WebElement soln1=driver.findElement(By.xpath("//div[@class='pas-list-container slice-3col']/div[1]/div/ul[1]/li["+l+"]/a"));
			soln1.click();
			System.out.println("soln1 is "+soln1);
			Thread.sleep(5000);
			WebElement juniperlogo3=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo3.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(6000);
			WebElement solutions1=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[1]/a"));
			solutions1.click();
			Thread.sleep(4000);
		}
		
		int rowCount4=driver.findElements(By.xpath("//div[@class='pas-list-container slice-3col']/div[1]/div/ul[2]/li")).size();
		System.out.println("Row Count 4 is "+rowCount4);
		Thread.sleep(6000);
		
		for (int m=1;m<=rowCount4;m++)
		{
			WebElement soln2=driver.findElement(By.xpath("//div[@class='pas-list-container slice-3col']/div[1]/div/ul[2]/li["+m+"]/a"));
			soln2.click();
			System.out.println("soln2 is "+soln2);
			Thread.sleep(5000);
			WebElement juniperlogo4=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo4.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(6000);
			WebElement solutions1=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[1]/a"));
			solutions1.click();
			Thread.sleep(4000);
			
		}
		
		//Solutions footer
		int rowCount5=driver.findElements(By.xpath("//div[@class='pas-list-container slice-3col']/div[1]/div/ul[2]")).size();
		System.out.println("Row Count 5 is "+rowCount5);
		for (int n=1;n<=rowCount5;n++)
		{
			//dynamic xpath after we click on solution footer
			WebElement soln3=driver.findElement(By.xpath("//div[@class='pas-list-container slice-3col']/div[2]/div/ul/li["+n+"]/a"));
			System.out.println("soln3 is "+soln3);
			soln3.click();
			Thread.sleep(5000);
			WebElement juniperlogo5=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo5.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(6000);
			WebElement solutions1=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[1]/a"));
			solutions1.click();
			Thread.sleep(4000);		
			}
		
		int rowCount6=driver.findElements(By.xpath("//div[@class='pas-list-container slice-3col']/div[2]/div/ul")).size();
		System.out.println("row Count 6 is "+rowCount6);
		Thread.sleep(5000);
		for (int p=1;p<=rowCount6;p++)
		{
			WebElement soln4=driver.findElement(By.xpath("//div[@class='pas-list-container slice-3col']/div[2]/div/ul/li["+p+"]/a"));
			soln4.click();
			System.out.println("Soln 4 is "+soln4);
			Thread.sleep(5000);
			WebElement juniperlogo5=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo5.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(6000);
			WebElement solutions1=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[1]/a"));
			solutions1.click();
			Thread.sleep(4000);
					}
					}	
	
	//About Juniper Footer
	public  void AbtJuniper()throws InterruptedException 
	{
		WebElement abtjuniper=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[2]/a"));
		abtjuniper.click();
		System.out.println("abtjuniper is clicked");
		Thread.sleep(8000);
		int rowCount7=driver.findElements(By.xpath("//div[@class='wrapper']/div[2]/div[1]/ul/li")).size();
		System.out.println("Row Count7 is "+rowCount7);
		Thread.sleep(8000);
		for(int q=1;q<=rowCount7;q++)
		{
			Thread.sleep(5000);
			WebElement abtjuniper1=driver.findElement(By.xpath("//div[@class='wrapper']/div[2]/div[1]/ul/li["+q+"]/a"));
			System.out.println("abtjuniper1 is "+abtjuniper1);
			abtjuniper1.click();
			Thread.sleep(8000);
			System.out.println();
			WebElement juniperlogo5=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo5.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(6000);
			WebElement abtjuniper2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[2]/a"));
			abtjuniper2.click();
			System.out.println("abtjuniperis clicked");
			WebElement video=driver.findElement(By.xpath("//div[@class='media-preview']/div/div/i"));
			video.click();
			System.out.println();
			Thread.sleep(8000);
			
			int rowCount=driver.findElements(By.xpath("//div[@class='drawer drawer-blue']/ul/li")).size();
			System.out.println("rowCount is "+rowCount);
			for(int i=1;i<=rowCount;i++)
			{
				WebElement footer= driver.findElement(By.xpath("//div[@class='drawer drawer-blue']/ul/li["+i+"]/a"));
				System.out.println("Footer is "+footer.getText());
				footer.click();
				Thread.sleep(7000);
				WebElement juniperlogo6=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
				juniperlogo6.click();
				System.out.println("Juniper logo is clicked");
							}
				}
					}
	public void Patners()throws InterruptedException
	{
		WebElement patners=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
		patners.click();
		System.out.println("Patners is clicked");
		Thread.sleep(7000);
		WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Login to Partner')]"));
		login.click();
		System.out.println("login clicked");
		Thread.sleep(8000);
		WebElement juniperlogo=driver.findElement(By.xpath("//a[@id='logoHolder']"));
		juniperlogo.click();
		System.out.println("Juniper logo is clicked");
		Thread.sleep(5000);
		WebElement patners1=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
		patners1.click();
		Thread.sleep(7000);
		int findapatnercount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div/ul")).size();
		System.out.println("findapatnercount is "+findapatnercount);
		
		int finapatnercol1rowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div[1]/ul[1]/li")).size();
		System.out.println("findapatnercol1rowcount is"+findapatnercol1rowcount);
		for(int i=1;i<=findapatnercol1rowcount;i++)
		{
			WebElement column1=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div[1]/ul[1]/li["+i+"]/a"));
			column1.click();
			Thread.sleep(5000);
			System.out.println("column 1 is clicked");
			//clicking on left navigation
			WebElement leftnav1=driver.findElement(By.xpath("//a[contains(text(),'Locate a Partner')]"));
			leftnav1.click();
			System.out.println("Left navigation clicked");
			WebElement arrow=driver.findElement(By.xpath("//a[contains(text(),'Locate a Partner')]/ancestor::div[1]/following-sibling::div"));
			arrow.clicdk();
			System.out.println("arrow navigation clicked");
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(5000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
					}
				int findapatnercol2rowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div[1]/ul[2]/li")).size();
		System.out.println("findapatnercol1rowcount is"+findapatnercol2rowcount);
		for(int i=1;i<=findapatnercol2rowcount;i++)
		{
			WebElement column2=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div[1]/ul[2]/li["+i+"]/a"));
			column2.click();
			Thread.sleep(5000);
			System.out.println("column 2 is clicked");
			//clicking on left navigation
			WebElement leftnav=driver.findElement(By.xpath("//a[contains(text(),'Locate a Partner')]"));
			leftnav.click();
			System.out.println("Left navigation clicked");
			WebElement arrow=driver.findElement(By.xpath("//a[contains(text(),'Locate a Partner')]/ancestor::div[1]/following-sibling::div"));
			arrow.click();
			System.out.println("arrow navigation clicked");
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(5000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
					
		}
		
		int findapatnercolumn3rowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div[1]/ul[3]/li")).size();
		System.out.println("Find a Patnercolumn3rowcount size is "+findapatnercolumn3rowcount);
		for (int i=1; i<=findapatnercolumn3rowcount;i++)
		{
			WebElement column3=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[1]/div[2]/div/div[1]/ul[3]/li["+i+"]/a"));
			column3.click();
			Thread.sleep(5000);
			System.out.println("column3 is"+column3);
			
			if(i==1)
			{
				//clicking on left navigation
				WebElement leftnav=driver.findElement(By.xpath("//a[contains(text(),'Locate a Partner')]"));
				leftnav.click();
				System.out.println("Left navigation clicked");
				WebElement arrow=driver.findElement(By.xpath("//a[contains(text(),'Locate a Partner')]/ancestor::div[1]/following-sibling::div"));
				arrow.click();
				System.out.println("arrow navigation clicked");
				WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
				juniperlogo1.click();
				System.out.println("Juniper logo1 is clicked");
				Thread.sleep(8000);
				WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
				patners2.click();
				Thread.sleep(8000);
			}
			
			if(i==2)
			{
				// We are taking all the window handle in array list
				ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
				// through this we are switching it to tab 2( the url from where learn more is opened).
				driver.switchTo().window(windowHandle.get(1));
				//closing tab 2 
				driver.close();
				// sswitching to tab 1 ie original url
		    	driver.switchTo().window(windowHandle.get(0));
			}
		}
		
		int becomeapatnerrowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul")).size();
		System.out.println( "Become a Patner Row Count is" +becomeapatnerrowcount); 
		
		int  becomeapatnercoln1rowcount =driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul[1]/li")).size();
		System.out.println("Become a Patner column1 is "+becomeapatnercoln1rowcount);
		for (int i=1;i<=becomeapatnercoln1rowcount;i++)
		{
			WebElement column1=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul[1]/li["+i+"]/a"));
			column1.click();
			Thread.sleep(5000);
			System.out.println("BCP column 1 is clicked");
			//clicking on left navigation
			WebElement leftnav=driver.findElement(By.xpath("//a[contains(text(),'Become a Partner')]"));
			leftnav.click();
			System.out.println("Left navigation clicked");
			WebElement arrow=driver.findElement(By.xpath("//a[contains(text(),'Become a Partner')]/ancestor::div[1]/following-sibling::div"));
			arrow.click();
			System.out.println("arrow navigation clicked");
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(5000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
				}
		
		int  becomeapatnercoln2rowcount =driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul[2]/li")).size();
		System.out.println("Become a Patner column1 is "+becomeapatnercoln2rowcount);
		for (int i=1;i<=becomeapatnercoln2rowcount;i++)
		{
			WebElement column2=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul[2]/li["+i+"]/a"));
			column2.click();
			Thread.sleep(5000);
			//clicking on left navigation
			WebElement leftnav=driver.findElement(By.xpath("//a[contains(text(),'Become a Partner')]"));
			leftnav.click();
			System.out.println("Left navigation clicked");
			WebElement arrow=driver.findElement(By.xpath("//a[contains(text(),'Become a Partner')]/ancestor::div[1]/following-sibling::div"));
			arrow.click();
			System.out.println("arrow navigation clicked");
			System.out.println("BCP column 2 is clicked");
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(5000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
		
			}
		
		
		int  becomeapatnercoln3rowcount =driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul[3]/li")).size();
		System.out.println("Become a Patner column1 is "+becomeapatnercoln3rowcount);
		for (int i=1;i<=becomeapatnercoln3rowcount;i++)
		{
			WebElement column3=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[2]/div[2]/div/div/ul[3]/li["+i+"]/a"));
			column3.click();
			Thread.sleep(5000);
			System.out.println("BCP column 3 is clicked");
			
			if (i==1)
			{
				//clicking on left navigation
				WebElement leftnav=driver.findElement(By.xpath("//a[contains(text(),'Become a Partner')]"));
				leftnav.click();
				System.out.println("Left navigation clicked");
				WebElement arrow=driver.findElement(By.xpath("//a[contains(text(),'Become a Partner')]/ancestor::div[1]/following-sibling::div"));
				arrow.click();
				System.out.println("arrow navigation clicked");
				WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
				juniperlogo1.click();
				System.out.println("Juniper logo1 is clicked");
				Thread.sleep(5000);
				WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
				patners2.click();
				Thread.sleep(7000);
			}
			
			if(i==2)
			{
				// We are taking all the window handle in array list
				ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
				// through this we are switching it to tab 2( the url from where learn more is opened).
				driver.switchTo().window(windowHandle.get(1));
				//closing tab 2 
				driver.close();
				// sswitching to tab 1 ie original url
		    	driver.switchTo().window(windowHandle.get(0));
			}
					}		
			
		int  existingpatnercoln1rowcount =driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul")).size();
		System.out.println("Existing a Patner size is "+existingpatnercoln1rowcount);
		
		int exisingpatnercoln1rowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul[1]/li")).size();
		System.out.println("Existing Patner coln1 is "+exisingpatnercoln1rowcount);
		
		for (int i = 1;i<=exisingpatnercoln1rowcount;i++)
		{
			WebElement column1=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul[1]/li["+i+"]/a"));
			column1.click();
			Thread.sleep(8000);
			System.out.println("ExP column 1 is clicked");
					
				// We are taking all the window handle in array list
				ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
				// through this we are switching it to tab 2( the url from where learn more is opened).
				driver.switchTo().window(windowHandle.get(1));
				Thread.sleep(5000);
				
				//closing tab 2 
				driver.close();
				Thread.sleep(5000);
				// sswitching to tab 1 ie original url
		    	driver.switchTo().window(windowHandle.get(0));
		    	Thread.sleep(5000);
		
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(8000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
		}
		
		int exisingpatnercoln2rowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul[2]/li")).size();
		System.out.println("Existing Patner coln2 is "+exisingpatnercoln2rowcount);
		for (int i = 1;i<=exisingpatnercoln2rowcount;i++)
		{
			WebElement column2=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul[2]/li["+i+"]/a"));
			column2.click();
			Thread.sleep(8000);
			System.out.println("ExP column 2 is clicked");
					
				// We are taking all the window handle in array list
				ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
				// through this we are switching it to tab 2( the url from where learn more is opened).
				driver.switchTo().window(windowHandle.get(1));
				Thread.sleep(5000);
				
				//closing tab 2 
				driver.close();
				Thread.sleep(5000);
				// sswitching to tab 1 ie original url
		    	driver.switchTo().window(windowHandle.get(0));
		    	Thread.sleep(5000);
		
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(8000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
		}
		
		int exisingpatnercoln3rowcount=driver.findElements(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul[3]/li")).size();
		System.out.println("Existing Patner coln2 is "+exisingpatnercoln3rowcount);
		for (int i = 1;i<=exisingpatnercoln3rowcount;i++)
		{
			WebElement column3=driver.findElement(By.xpath("//div[@class='slice-table full spaced-bottom']/div[3]/div[2]/div/div/ul[3]/li["+i+"]/a"));
			column3.click();
			Thread.sleep(8000);
			System.out.println("ExP column3  is clicked");
					
				// We are taking all the window handle in array list
				ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
				// through this we are switching it to tab 2( the url from where learn more is opened).
				driver.switchTo().window(windowHandle.get(1));
				Thread.sleep(5000);
				
				//closing tab 2 
				driver.close();
				Thread.sleep(5000);
				// sswitching to tab 1 ie original url
		    	driver.switchTo().window(windowHandle.get(0));
		    	Thread.sleep(5000);
		
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo1 is clicked");
			Thread.sleep(8000);
			WebElement patners2=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[3]/a"));
			patners2.click();
			Thread.sleep(7000);
		
		}
	}

	public void community() throws InterruptedException
	{
		WebElement community=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[1]/li[4]/a"));
		community.click();
		Thread.sleep(6000);
		WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
		juniperlogo1.click();
		System.out.println("Juniper logo1 is clicked");
	}*/
	
/*	public void footer() throws InterruptedException
	{
		int footervalue1=driver.findElements(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[1]/ul/li")).size();
		System.out.println("The Footer values size is "+footervalue1);
		for(int i=1;i<=footervalue1;i++)
		{
			if(i==5)
			{
				break;
			}
			//WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li["+i+"]/ul/li"));
			WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[1]/ul/li["+i+"]/a"));
			//div[@class='wrapper wrapper-medium']/ul[2]/li[1]/ul/li[1]
			values.click();
			System.out.println("Vaues are clciked "+values);
			Thread.sleep(6000);
			WebElement juniperlogo=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo.click();
			System.out.println("Juniper logo is clicked");
				
		}
		
		int footervalue2=driver.findElements(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[2]/ul/li")).size();
		System.out.println("The Footer values size is "+footervalue2);
		for(int i=1;i<=footervalue2;i++)
		{
			//WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li["+i+"]/ul/li"));
			WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[2]/ul/li["+i+"]/a"));
			//div[@class='wrapper wrapper-medium']/ul[2]/li[1]/ul/li[1]
			values.click();
			System.out.println("Vaues are clciked "+values);
			Thread.sleep(6000);
			WebElement juniperlogo=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo.click();
			System.out.println("Juniper logo is clicked");
				}
		
		int footervalue3=driver.findElements(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[3]/ul/li")).size();
		System.out.println("The Footer values size is "+footervalue2);
		for(int i=1;i<=footervalue3;i++)
		{
			//WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li["+i+"]/ul/li"));
			WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[2]/ul/li["+i+"]/a"));
			//div[@class='wrapper wrapper-medium']/ul[2]/li[1]/ul/li[1]
			values.click();
			System.out.println("Vaues are clciked "+values);
			Thread.sleep(6000);

			WebElement juniperlogo=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo.click();
			System.out.println("Juniper logo is clicked");
	
	     }
		
		int footervalue4=driver.findElements(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[4]/ul[1]/li")).size();
		System.out.println("Footervalue 4 size is"+footervalue4);
		for ( int i=1;i<=footervalue4;i++)
		{
			WebElement values=driver.findElement(By.xpath("//div[@class='wrapper wrapper-medium']/ul[2]/li[4]/ul/li["+i+"]/a"));
			values.click();
			System.out.println("values are cliecked"+values);
			Thread.sleep(3000);
			
			// We are taking all the window handle in array list
			ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
			// through this we are switching it to tab 2( the url from where learn more is opened).
			driver.switchTo().window(windowHandle.get(1));
			//closing tab 2 
			driver.close();
			// sswitching to tab 1 ie original url
	    	driver.switchTo().window(windowHandle.get(0));
		
		}
		
		//Select countryselector=Select(driver.findElement(By.className("country-select select icon-select-down select-91 select-ff")));
		Select countryselector=Select(driver.findElements(By.xpath("//ul[@class='footer-select-wrapper']/li/select/option")));
		Thread.sleep(9000);
		countryselector.selectByVisibleText("France");
		Thread.sleep(6000);
		System.out.println("Country Selector is selected");
	}
	*/
	 public void header()throws InterruptedException
	 {
		 //Product and Services mouse over
		 	Actions action = new Actions(driver);
			WebElement product=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
			action.moveToElement(product).build().perform();
			System.out.println("Mouse Over done");
			
			//Clicking on Products
			WebElement productclick=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/a"));
			Thread.sleep(7000);
			productclick.click();
			System.out.println("Products clicked");
			Thread.sleep(9000);
			
			WebElement juniperlogo=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(8000);
			
			//Product and Services mouse over
		 	Actions action1 = new Actions(driver);
			WebElement product1=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
			action1.moveToElement(product1).build().perform();
			System.out.println("Mouse Over done");
			Thread.sleep(8000);
			
			//xpath of the size of the product of the column 1
			int productsize1=driver.findElements(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li")).size();
			System.out.println("Size of the Product is "+productsize1);
			
			//loop for 5 products
			for (int i=1;i<=productsize1;i++)
			{
			System.out.println("value of i is"+i);	
			Thread.sleep(6000);
			//xpath of the items under product like "Identity Policy Control", "Network Edge Services" etc..
			WebElement items_under_product1=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li["+i+"]/a"));
			Thread.sleep(7000);
			items_under_product1.click();
			Thread.sleep(7000);
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(10000);
			if(i==productsize1)
			{
				break;
				
			}
			
			//Product and Services mouse over
		 	Actions action2 = new Actions(driver);
		 	WebElement product11=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
			action2.moveToElement(product11).build().perform();
			System.out.println("Mouse Over done");
			Thread.sleep(8000);
						}
			
			//xpath of the size of the product of the column 2
			int productsize2=driver.findElements(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[2]/ul/li")).size();
			System.out.println("Size of the Product is "+productsize2);
			
			//loop for 4 products
			for (int i=1;i<=productsize2;i++)
			{
			System.out.println("value of i is"+i);	
			Thread.sleep(6000);
			
			//xpath of the items under product like "Identity Policy Control", "Network Edge Services" etc..
			WebElement items_under_product2=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[2]/ul/li["+i+"]/a"));
			Thread.sleep(7000);
			items_under_product2.click();
			Thread.sleep(7000);
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(10000);
			if(i==productsize2)
			{
				break;
			}
			
			//Product and Services mouse over
		 	Actions action2 = new Actions(driver);
		 	WebElement product11=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
			action2.moveToElement(product11).build().perform();
			System.out.println("Mouse Over done");
			Thread.sleep(8000);
						}
			
			//All the Products A-Z and End of Life link xpath 
			int productsize3=driver.findElements(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[2]/ul/li")).size();
			System.out.println("Size of the Product is "+productsize3);//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[2]/ul/li//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[2]/ul/li//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[2]/ul/li
			
			//loop for A-Z products and End of Life link
			for (int i=1;i<=productsize3;i++)
			{
			System.out.println("value of i is"+i);	
			Thread.sleep(6000);
			//xpath of the items under product like "Identity Policy Control", "Network Edge Services" etc..
			WebElement items_under_product3=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[2]/ul/li["+i+"]/a"));
			Thread.sleep(7000);
			items_under_product3.click();
			Thread.sleep(7000);
			
			if (i==2)
			{
				
				//  To close the new tab which is opened ie here We are taking all the window handle in array list
				ArrayList<String> windowHandle = new ArrayList<String> (driver.getWindowHandles());
				// through this we are switching it to tab 2( the url from where learn more is opened).
				driver.switchTo().window(windowHandle.get(1));
				//closing tab 2 
				driver.close();
				// switching to tab 1 ie original url
		    	driver.switchTo().window(windowHandle.get(0));
			}
			WebElement juniperlogo1=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
			juniperlogo1.click();
			System.out.println("Juniper logo is clicked");
			Thread.sleep(10000);
			if(i==productsize3)
			{
				break;
			}
			
			//Product and Services mouse over
		 	Actions action2 = new Actions(driver);
		 	WebElement product11=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
			action2.moveToElement(product11).build().perform();
			System.out.println("Mouse Over done");
			Thread.sleep(8000);
						}
			
			
				 }
	 
	private Select Select(List<WebElement> list) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

	/*public void identitypolicy() throws InterruptedException 
	{
//Mouse Over on Product and Services and Identity policy 
	    
	    Actions action = new Actions(driver);
		WebElement productservices= driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/a"));
		System.out.println("product and services mouse over");
		WebElement idntypolicy=driver.findElement(By.xpath("//ul[@class='top-menu nav-link-list']/li[1]/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		System.out.println("Idntypolicy mouse over");
		action.moveToElement(productservices);
		action.perform();
		action.moveToElement(idntypolicy);
		action.perform();
		//Thread.sleep(7000);
		idntypolicy.click();
		WebElement juniperlogo4=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
		juniperlogo4.click();
		System.out.println("Juniper logo is clicked");
	}*/

