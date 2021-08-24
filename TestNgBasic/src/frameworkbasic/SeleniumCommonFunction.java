package frameworkbasic;

import java.util.spi.LocaleNameProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumCommonFunction {
	public static WebDriver openBrowser(String brName) {
		WebDriver driver = null;
		if ("chrome".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("firefox".equals(brName) || "mozilla".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", "firefoxdriver.exe");
			driver = new FirefoxDriver();
		} else if ("html".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new HtmlUnitDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	//For url 
	public static void openUrl(WebDriver driver,String urlToOpen) {
		driver.get(urlToOpen);
	}

	//foe login
	public static void enterText(WebDriver driver,String locName,String locValue,String DataToEnter)
	{ 
		if("id".equals(locName))
		{
			driver.findElement(By.id(locValue)).sendKeys(DataToEnter);
		}
		if("xpath".equals(locName))
		{
			driver.findElement(By.xpath(locValue)).sendKeys(DataToEnter);
		}

	}

	/**
	 * @param driver
	 * @param locName
	 * @param locValue
	 * this method is used to press button on webpage
	 */
	public static void clickButton(WebDriver driver,String locName,String locValue)
	{
		if("button".equals(locName))
		{
			driver.findElement(By.tagName(locValue)).click();
		}
		if("xpath".equals(locName))
		{
			driver.findElement(By.xpath(locValue)).click();
		}
	}

	//get title
	/**
	 * @param driver
	 * @return
	 * THIS methodgeves title of webpage
	 */
	public static String getTitle(WebDriver driver)
	{
		String s=driver.getTitle();
		return s;
	}

	/**
	 * @param driver
	 * @param locName
	 * @param locValue
	 * @return
	 * Used to get text of any webElement
	 */
	public static String getText(WebDriver driver,String locName,String locValue)
	{       String ss=null;
		if("xpath".equals(locName))
		{
			ss=driver.findElement(By.xpath(locValue)).getText();
			
		}
		if("id".equals(locName))
		{
			ss=driver.findElement(By.xpath(locValue)).getText();
		}
		return ss;
	}
	
	public static String getPlaceholder(WebDriver driver,String locName,String locValue,String attribute)
	{ String s=null;
		if("xpath".equals(locName))
		{
			s=driver.findElement(By.xpath(locValue)).getAttribute(attribute);
		}
		else if("id".equals(locName))
		{
			s=driver.findElement(By.id(locValue)).getAttribute(attribute);
		}
		return s;
	}
	

	public void pause(int timeToWait)
	{
		try {
			Thread.sleep(timeToWait);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
