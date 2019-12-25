package com.project.objectRepo;

import com.project.objectRepo.AmazonPage;
import com.project.commonLib.PropertyReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.project.commonLib.GenericLib;
import com.project.commonLib.IFilePath;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;


/*
 * Tanvi
 */
public class FlipkartPage implements IFilePath {
	public static double actFlipkartProductPrice;
	
	private WebDriver driver;
	private Actions act;
	private GenericLib lib;
	
	/**
	 * Initiate the Flipkart page
	 * 
	 * @param driver
	 */

	PropertyReader pred;

	public FlipkartPage(WebDriver driver) throws Throwable {
		driver.get(pred.getPropertyConfig(PROP, "URLFlipKart"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		lib = new GenericLib(driver);
	}

	@FindBy(xpath = "//button[text()='✕']")
	private WebElement crossBtn;
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	private WebElement searchTextBox;
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	private WebElement IPhoneXRYellow;
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div/div/div/div")
	private WebElement productprice;
	@FindBy(xpath = "//span[text()='Apple iPhone XR (Yellow, 64 GB)']/..following-sibling::div/div/div/div")
	private WebElement productprice1;
	String actPrice;
	String actPrice1;

	public void flipkartPriceCount() throws Throwable {
		crossBtn.click();
		searchTextBox.sendKeys(PropertyReader.getExcelDataConfig(EXCEL,"Sheet1",1,1), Keys.ENTER);
		IPhoneXRYellow.click();
		lib.switchToChildWindow();
		lib.waitForPageToLoad();
		lib.waitForElemnetToAppear(productprice) ;
			actPrice = productprice.getText();
			System.out.println(actPrice);
			actFlipkartProductPrice = Double.parseDouble(actPrice.replace(",", "").replace("₹", "").trim());
	}

}
