package com.project.objectRepo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
public class AmazonPage implements IFilePath {

	public static double actAmazonProductPrice;
	private WebDriver driver;
	private Actions act;
	private GenericLib lib;
	/**
	 * Initiate the Amazon page
	 * 
	 * @param driver
	 */
	PropertyReader pred;

	public AmazonPage(WebDriver driver) throws Throwable {
		driver.get(pred.getPropertyConfig(PROP, "URLAmazon"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		lib = new GenericLib(driver);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTextBox;
	@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	private WebElement IPhoneXRYellow;
	@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]/ancestor::div[@id='centerCol']//span[@id='priceblock_ourprice']")
	private WebElement productprice;

	public void amazonPriceCount() throws Throwable{
		searchTextBox.sendKeys(PropertyReader.getExcelDataConfig(EXCEL,"Sheet1",1,1), Keys.ENTER);
		IPhoneXRYellow.click();
		lib.switchToChildWindow();
		lib.waitForPageToLoad();
		String actPrice = productprice.getText();
		System.out.println(actPrice);

		actAmazonProductPrice =Double.parseDouble(actPrice.replace("₹", "").replace(",", "").trim());
		System.out.println(actAmazonProductPrice);

	}
}
