package testcasesbigin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAutomation {
	WebDriver driver=null;
	void browsersetup()
	{ 
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		
	}

	@Test
	public void checkTestOne()
	{  
		browsersetup();
		String act=driver.getCurrentUrl();
		System.out.println(act);
		String expt="file:///C:/Users/dell/Downloads/selenium/Selenium%20Softwares/Offline%20Website/pages/examples/dashboard.html";
		driver.close();
		Assert.assertEquals(act, expt);
		
		 
	}
	
	@Test
	public void checkTestTwo()
	{  
		browsersetup();
		String act=driver.getTitle();
		System.out.println(act);
		String expt="JavaByKiran | Dashboard";
		driver.close();
		Assert.assertEquals(act, expt);
		
		 }
	
	@Test
	public void checkTestThree()
	{
		browsersetup();
		String act=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		driver.close();
		Assert.assertEquals(act, "Dashboard Courses Offered");
	}
	
	@Test
	public void checkTestFour()
	{
		browsersetup();
		String act=driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).getText();
		driver.close();
		Assert.assertEquals(act, "Users");
	}
	
	@Test
	public void checkTestFive()
	{
		browsersetup();
		String act=driver.findElement(By.xpath("/html/body/div[1]/aside/section/div")).getText();
		driver.close();
		Assert.assertEquals(act, "Kiran");
	}
}
