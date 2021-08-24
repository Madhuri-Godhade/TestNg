package testcasesbigin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoLoginTestCase {
	
	@Test
	public void checkTestOne()
	{      
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
	    String act=driver.getTitle();
		String expt="JavaByKiran | Log in";
		driver.close();
		Assert.assertEquals(act, expt);
	}


	@Test
	public void checkTestTwo()
	{
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
		 driver.findElement(By.id("email")).sendKeys("");
		 driver.findElement(By.xpath("//button")).click();
		 String errorMsg=driver.findElement(By.id("email_error")).getText();
		System.out.println("errorMsg >> "+errorMsg);
		String expMsg="Please enter email.";
		Assert.assertEquals(errorMsg,expMsg );
		driver.close();
	}

	
	@Test
	public void checkTestThree()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
		String s=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).getText();
		driver.close();
		Assert.assertEquals(s, "Sign In");
	}
	
	@Test
	public void checkTestFour()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
		String s=driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
		driver.close();
		Assert.assertEquals(s, "Register a new membership");
	}
	
	@Test
	public void checkTestFive()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
		String s=driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
		driver.close();
		Assert.assertEquals(s, "JAVA | SELENIUM | PYTHON");
	}
	
}
