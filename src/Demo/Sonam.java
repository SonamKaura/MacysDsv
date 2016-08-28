package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Sonam {

	@Test
	public void testWebdriver(){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	}
}
