package foodboxtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FoodBoxLoginandSignup {

	WebDriver driver=new ChromeDriver();
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver.get("http://localhost:4200/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		}
		@Test(priority = 1)
		public void logintest()
		{
			WebElement Username=driver.findElement(By.xpath("//input[@name='name']"));
			WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
			WebElement LoginButton=driver.findElement(By.xpath("//button[@type='submit']"));
			
			Username.sendKeys("abc@gmail.com");
			Password.sendKeys("abcdef");
			LoginButton.click();
		}
		
		@Test(priority = 2)
		public void RegisterPageTest() {
		WebElement SignUp=driver.findElement(By.xpath("//a[@name='signUp']"));
		SignUp.click();
		}
		
		@Test(priority = 3)
		public void Register() {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,5000)","");
			WebElement Username=driver.findElement(By.xpath("//input[@name='name']"));
			WebElement Email=driver.findElement(By.xpath("//input[@name='email']"));
			WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
			WebElement Phone=driver.findElement(By.xpath("//input[@name='phone']"));
			WebElement Address=driver.findElement(By.xpath("//input[@name='address']"));
			
			Username.sendKeys("abc");
			Email.sendKeys("abcd@xyz.com");
			Password.sendKeys("abcdefhg");
			Phone.sendKeys("0010020030");
			Address.sendKeys("abc villa,pqr");
			
			WebElement SubmitButton=driver.findElement(By.name("getstarted"));
			
			SubmitButton.click();
			
			driver.quit();
		}
}
		


