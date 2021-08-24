package annotationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseswithAnnotation {

	 WebDriver driver=new ChromeDriver();
	@Test
	public void checkTitleDashboard() { // Check Title after login
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "JavaByKiran | Dashboard");
	}


@Test
	public void checkTitleIfCorrectMessage() { // Check Title after login
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		String actDashBoardTitle = driver.getTitle();
		Assert.assertEquals(actDashBoardTitle, "dashboard");
	}

	@Test
	public void login() { // Check Text for Operator
		checkTitleDashboard();
		driver.findElement(By.cssSelector(".fa.fa-retweet")).click();
		String operator = driver.findElement(By.cssSelector(".box-title")).getText();
		System.out.println(operator);
		Assert.assertEquals(operator, "Operator List");
	}

}
	

