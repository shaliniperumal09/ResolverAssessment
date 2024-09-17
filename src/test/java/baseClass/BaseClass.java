package baseClass;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass {
	
	
	public static WebDriver driver;
	
	
	
	public BaseClass() {
		
		
	}
	public static void Initiation()
	{
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		 driver = new FirefoxDriver();

		driver.get("file:///Users/Desktop/QE-index.html");
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));;
		

}

}
