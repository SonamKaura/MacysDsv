package Juniper;

import java.util.List;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Iterator;

import java.util.NoSuchElementException;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver.Navigation;

import org.openqa.selenium.WebDriver.Options;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.support.ui.*;

import com.google.common.base.Function;

import com.google.common.base.Predicate;


// To check all  broken links using HTTP Request as per the Example"http://www.toolsqa.com/selenium-webdriver/finding-broken-links-selenium-automation/"
public class allbrokenlinks {
	
	public static List findAllLinks(WebDriver driver)

	 {
	  // Creating a object elementList of the List Class
	  //List elementList = new ArrayList();
		
	  List <WebElement> elementList = driver.findElements(By.tagName("a"));
	  elementList.addAll(driver.findElements(By.tagName("img")));

	  // Creating a object finalList of the ArrayList Class
	  List<WebElement> finalList = new ArrayList<WebElement>();

	  for (WebElement element : elementList)
	  {
	   if(element.getAttribute("href") != null)
	   {
	    finalList.add(element);
	   }    
	  } 
	  return finalList;
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
	 public static void main(String[] args) throws Exception {
	  // TODO Auto-generated method stub

	  FirefoxDriver ff = new FirefoxDriver();
	  ff.get("http://www.toolsqa.com/automation-practice-switch-windows/");
	  //ff.get("http://www.yahoo.com/");

	  List<WebElement> allImages = findAllLinks(ff);    
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
	 }
	}

