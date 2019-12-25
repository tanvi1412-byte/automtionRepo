package com.project.commonLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;





/**
 * 
 * @author Tanvi
 *
 */
public class BaseClass implements IAutoConstants, IFilePath  {
	

	/**
	 * Launch the selected browser
	 * @throws Throwable
	 */
	public static WebDriver driver;
	PropertyReader pred=new PropertyReader();
	
	@BeforeTest
	public void launchBrowserConfigTest() throws Throwable
	{
		String Browser=pred.getPropertyConfig(PROP,"BROWSER");
		
		if(Browser.equals("Chrome"))
		{
	driver=new ChromeDriver();
	}
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{	
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void closeBrowserConfigTest() throws Throwable
	{
//		driver.quit();
	}



}






