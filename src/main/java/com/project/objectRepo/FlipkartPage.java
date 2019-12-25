package com.project.objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.project.commonLib.GenericLib;
import com.project.commonLib.IFilePath;
import com.project.commonLib.PropertyReader;
/*
 * Tanvi
 */
public class FlipkartPage implements IFilePath {
	
		
		private WebDriver driver;
		private Actions act;
		private GenericLib lib;
		/**
		 * Initiate the Flipkart page
		 * @param driver
		 */
		
		PropertyReader pred;
		public FlipkartPage(WebDriver driver) throws Throwable {
			driver.get(pred.getPropertyConfig(PROP,"URLFlipKart"));
			PageFactory.initElements(driver, this);
			this.driver = driver;
			act = new Actions(driver);
			lib = new GenericLib(driver);
		}
		@FindBy(xpath="//button[text()='✕']")
		private WebElement crossBtn;
		@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
		private WebElement searchTextBox;
		@FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
		private WebElement IPhoneXRYellow;
		//Xpath for Firefox
		//@FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../../div[2]/div/div/div[1]")
		//Xpath for Chrome
		@FindBy(xpath="//span[text()='Apple iPhone XR (Yellow, 64 GB)']/../../../div[4]/div[1]/div/div[@xpath='1']")
		
		private WebElement productprice;
		public void flipkartPriceCount()
		{
			crossBtn.click();
			searchTextBox.sendKeys("iPhone XR (64GB) - Yellow",Keys.ENTER);
			IPhoneXRYellow.click();
			lib.switchToChildWindow();
			String actPrice=productprice.getText();
			System.out.println(actPrice);
			int actFlipkartProductPrice=Integer.parseInt(actPrice.replace(",","").replace("? ", ""));

			Reporter.log(actFlipkartProductPrice+"");
			
		}
}
