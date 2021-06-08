package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		String driverPath = "C:\\Users\\Vineeta Chaudhary\\Downloads\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html");		
	}
	
	@Test
	
	public void VerifyElementsPresent() {
		
		//verify query input and search button
		driver.findElement(By.xpath("//input[@id='search-input']"));
		driver.findElement(By.xpath("//input[@id='search-input']")).isDisplayed();
		driver.findElement(By.xpath("//button[@id='search-button']"));
		driver.findElement(By.xpath("//button[@id='search-button']")).isDisplayed();
		driver.close();
	}
	
	@Test
	
	public void VerifyEmptyQueryIsForbidden() throws InterruptedException {
	
		//Check to see if searching with empty query is forbidden
		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("");
		driver.findElement(By.xpath("//button[@id='search-button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='error-empty-query']")).isDisplayed();
		driver.close();
		
	}
	
	@Test
	
	public void  VerifyIfQueryIsReturned() throws InterruptedException {
		
		//check if at least one island is returned
		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("isl");
		driver.findElement(By.xpath("//button[@id='search-button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='output-container']//ul/li[1]")).isDisplayed();
		
		driver.close();
		
		
	}

}
