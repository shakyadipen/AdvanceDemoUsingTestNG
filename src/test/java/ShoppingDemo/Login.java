package ShoppingDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		String location =System.getProperty("user.dir");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",location+"/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		
	}
	@Test(description="Login Advantage Demo Site With Proper Data")
	@Parameters({"username","password"})
	public void loginWithData(String username,String password) throws InterruptedException {
		driver.findElement(By.id("menuUser")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id=\"sign_in_btnundefined\"]")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
