package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	private WebDriver driver;
	
	public WebDriver initializeDriver(String browserName){
		switch(browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			final ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			options.addArguments("--window-size=1280,800");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		return driver;
	} 
	
	
	public void tearDown(WebDriver driver) {
		
		driver.quit();
		
	}
	
	
	
	
}
