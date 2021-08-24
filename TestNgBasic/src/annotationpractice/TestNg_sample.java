package annotationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_sample {

	public class TestNG_Sample {

		WebDriver driver = null;

		@BeforeClass
		public void openBrowser() {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			//driver.manage().window().maximize();
		}

		@AfterClass // ctrl + shift + o
		public void closeBrowser() {
			driver.close();
		}
/*
		@BeforeMethod
		public void clearTextBoxes() {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("password")).clear();
		}*/

		@Test
		public void checkLink() { // Check link on login page
			String actLink = driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
			Assert.assertEquals(actLink, "Register a new membership");
		}

		@Test
		public void checkTitleDashboard() { // Check Title after login
			
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
			String actTitle = driver.getTitle();
			System.out.println(actTitle);
			Assert.assertEquals(actTitle, "JavaByKiran | Dashboard");
		}

		@Test
		public void checkErrorMessage() { 
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("password")).sendKeys("");
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
			String actMessage = driver.findElement(By.xpath("/html/body/div/div[2]/p[2]")).getText();
			Assert.assertEquals(actMessage, "Logout successfully");
		}
		@Test
		public void checkTitleMessage() { // Check Title after login
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
			String actDashBoardTitle =driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b")).getText();
			Assert.assertEquals(actDashBoardTitle, "Java By Kiran");
		}

		@Test
		public void checkDashBoard()

		{
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
			String  actdashboard= driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[2]/a")).getText();
			Assert.assertEquals(actdashboard, "Dashboard");

		}

		@Test
		public void checkUserDashBoard()
		{  
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
			String  actdashboard= driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).getText();
			Assert.assertEquals(actdashboard, "Users");

		}

	}

}
