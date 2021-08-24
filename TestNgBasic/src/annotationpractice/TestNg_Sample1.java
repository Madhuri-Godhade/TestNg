package annotationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_Sample1 {

	WebDriver driver=null;

	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");
		//driver.manage().window().maximize();
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.close();

	}

	@BeforeMethod
	public void clearTextBoxes()
	{
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
	
	@Test(priority=1)
	public void checkUrl(){
		String actUrl=driver.getCurrentUrl();
		String exptUrl="C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html";
		Assert.assertEquals(actUrl, exptUrl);;
	}

	@Test
	public void checkTitle()
	{
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "JavaByKiran | Log in");	
	}

	@Test
	public void checkSubTitle()
	{
		String actsubTitle=	driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
		String ExptsubTitle="JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actsubTitle, ExptsubTitle);
	}
	
	@Test(priority=3)
	public void checkSignInTitle(){
		String actsignInTextTitle=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
		Assert.assertEquals(actsignInTextTitle, "Sign in to start your session");
	}

	@Test(priority=4)
	public void varifyPlaceholderEmail()
	{
		WebElement emailTextBox=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		String actPlaceholder=emailTextBox.getAttribute("placeholder");
		String exptPlaceholder="Email";
		Assert.assertEquals(actPlaceholder, exptPlaceholder);
	}
	@Test(priority=5)
	public void varifyPlaceholderPassword()
	{//password placeholder
		WebElement paswrdTextBox=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input"));
		String actPlaceholder=paswrdTextBox.getAttribute("placeholder");
		String exptPlaceholder="Password";
		Assert.assertEquals(actPlaceholder, exptPlaceholder);
	}


	@Test(priority=6)
	public void checkEmailMsg() { // Check Incorrect Email Error msg
		driver.findElement(By.id("email")).sendKeys("Madhuri@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		String EmailError = driver.findElement(By.id("email_error")).getText();
		Assert.assertEquals(EmailError, "Please enter email as kiran@gmail.com");
	}

	@Test(priority=7)
	public void checkPasswordMsg() { // Check Incorrect Password Error msg
		driver.findElement(By.id("password")).sendKeys("123123");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		String PasswordError = driver.findElement(By.id("password_error")).getText();
		Assert.assertEquals(PasswordError, "Please enter password 123456");
	}
	
	@Test(priority=8)
	public void checkErrorMessage() { 
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		String actMessage = driver.findElement(By.xpath("/html/body/div/div[2]/p[2]")).getText();
		Assert.assertEquals(actMessage, "Logout successfully");
	}
	
	@Test(priority=9)
	public void checkErrorMessage_1() { 
		driver.findElement(By.id("email")).sendKeys("asdg@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		String actMessage = driver.findElement(By.xpath("/html/body/div/div[2]/p[2]")).getText();
		Assert.assertEquals(actMessage, "Please Enter Valid Email");
	}

	@Test(priority=10)
	public void checklogin(){
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123123");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
        String checkTitle=driver.getTitle();
        Assert.assertEquals(checkTitle, "DashBoard");
	}
	
	@Test(priority=11)
	public void checkSignIn(){
		String actsignInText=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).getText();
		Assert.assertEquals(actsignInText, "Sign in");
	}
	
	@Test(priority=12)
	public void checkRedisterText(){
		String actsignInText=driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
		Assert.assertEquals(actsignInText, "Register a new membership");
	}

}
