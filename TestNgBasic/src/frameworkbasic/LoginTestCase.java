package frameworkbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCase {
	WebDriver driver = null;

	@BeforeMethod
	public void openBrowser() {
		driver = SeleniumCommonFunction.openBrowser("chrome");

		SeleniumCommonFunction.openUrl(driver,
				"C:/Users/dell/Downloads/selenium/Selenium Softwares/Offline Website/index.html");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void checkSubTitle() {
		String actsubTitle = SeleniumCommonFunction.getText(driver, "xpath", "/html/body/div/div[1]/a/h4");
		String ExptsubTitle = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actsubTitle, ExptsubTitle);
	}

	@Test
	public void checkTitle() {
		String actTitle = SeleniumCommonFunction.getTitle(driver);
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "JavaByKiran | Log in");

	}

	@Test
	public void checkSignInTitle() {
		// String
		// actsignInTextTitle=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
		String actsignInTextTitle = SeleniumCommonFunction.getText(driver, "xpath", "/html/body/div/div[2]/p");
		Assert.assertEquals(actsignInTextTitle, "Sign in to start your session");
	}

	@Test
	public void varifyPlaceholderEmail() {
		// WebElement
		// emailTextBox=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		String actPlaceholder = SeleniumCommonFunction.getPlaceholder(driver, "xpath", "//*[@id=\"email\"]",
				"placeholder");
		String exptPlaceholder = "Email";
		Assert.assertEquals(actPlaceholder, exptPlaceholder);
	}

	@Test
	public void varifyPlaceholderPassword() {// password placeholder

		String actPlaceholder = SeleniumCommonFunction.getPlaceholder(driver, "xpath",
				"/html/body/div/div[2]/form/div[2]/input", "placeholder");

		String exptPlaceholder = "Password";
		Assert.assertEquals(actPlaceholder, exptPlaceholder);
	}

	@Test
	public void checkEmailMsg() { // Check Incorrect Email Error msg

		SeleniumCommonFunction.enterText(driver, "id", "email", "Madhuri@gmail.com");
		SeleniumCommonFunction.clickButton(driver, "xpath", "/html/body/div/div[2]/form/div[3]/div/button");

		String EmailError = SeleniumCommonFunction.getText(driver, "id", "email_error");
		Assert.assertEquals(EmailError, "Please enter email as kiran@gmail.com");
	}

	@Test
	public void checkPasswordMsg() { // Check Incorrect Password Error msg
		SeleniumCommonFunction.enterText(driver, "id", "password", "123456");
		SeleniumCommonFunction.clickButton(driver, "xpath", "/html/body/div/div[2]/form/div[3]/div/button");

		String PasswordError = SeleniumCommonFunction.getText(driver, "id", "password_error");
		Assert.assertEquals(PasswordError, "Please enter password 123456");
	}

	@Test
	public void checkErrorMessage() {
		SeleniumCommonFunction.enterText(driver, "id", "email", " ");
		SeleniumCommonFunction.enterText(driver, "id", "password", " ");
		SeleniumCommonFunction.clickButton(driver, "xpath", "/html/body/div/div[2]/form/div[3]/div/button");
		String actMessage = SeleniumCommonFunction.getText(driver, "xpath", "/html/body/div/div[2]/p[2]");

		Assert.assertEquals(actMessage, "Logout successfully");
	}

	@Test
	public void checkErrorMessage_1() {
		SeleniumCommonFunction.enterText(driver, "id", "email", "asdf@gmail.com ");
		SeleniumCommonFunction.enterText(driver, "id", "password", "asbdft ");
		SeleniumCommonFunction.clickButton(driver, "xpath", "/html/body/div/div[2]/form/div[3]/div/button");
		String actMessage = SeleniumCommonFunction.getText(driver, "xpath", "/html/body/div/div[2]/p[2]");

		Assert.assertEquals(actMessage, "Please Enter Valid Email");
	}

	@Test
	public void checkLogin() {
		SeleniumCommonFunction.enterText(driver, "id", "email", "kiran@gmail.com");
		SeleniumCommonFunction.enterText(driver, "id", "password", "123456");
		SeleniumCommonFunction.clickButton(driver, "xpath", "/html/body/div/div[2]/form/div[3]/div/button");

		String checkTitle = driver.getTitle();
		Assert.assertEquals(checkTitle, "JavaByKiran | Dashboard");
	}
}
