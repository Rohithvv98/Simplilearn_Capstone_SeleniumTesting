package foodboxtest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FoodBoxAddtoCartandOrder {
	WebDriver driver=new ChromeDriver();
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	@Test(priority = 1)
	public void logintest()
	{
		WebElement Username=driver.findElement(By.xpath("//input[@name='name']"));
		WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement LoginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		
		Username.sendKeys("TestUser");
		Password.sendKeys("testuser");
		LoginButton.click();
	}
	
	@Test(priority = 2)
	public void clickCategory()
	{
		WebElement Category=driver.findElement(By.xpath("//a[@name='Indian']"));
		Category.click();
	}
	
	@Test(priority = 3)
	public void ViewProducts()
	{
		WebElement View=driver.findElement(By.xpath("//a[text()=\"View Food Items\"]"));
		View.click();
		
	}
	
	@Test(priority = 4)
	public void AddtoCart()
	{	
		WebElement Search=driver.findElement(By.xpath("//input[@type='search']"));
		Search.sendKeys("mexi");
		WebElement button = driver.findElement(By.xpath("//div/button[contains(text(),'add to cart')]"));
		button.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='About']")).click();;
	}
	
	
	@Test(priority = 5)
	public void CarttoOrder()
	{	

		WebElement cartSelect=driver.findElement(By.xpath("//a[@name='cart']"));
		cartSelect.click();
		WebElement Button=driver.findElement(By.xpath("//button[contains(text(),'Proceed to Checkout')]"));
		Button.click();
		
	}
	
	@Test(priority = 6)
	public void Checkout()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,7000)","");
		WebElement Button=driver.findElement(By.xpath("//button[@type='submit']"));
		Button.click();
	}
	
	@Test(priority=7)
	public void lastly()
	{
		WebElement Button=driver.findElement(By.xpath("//button[contains(text(),'Continue to Dashboard')]"));
		Button.click();
	}
}
