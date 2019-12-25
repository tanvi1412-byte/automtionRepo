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
import com.project.commonLib.PropertyReader;
import com.project.commonLib.GenericLib;
import com.project.commonLib.IFilePath;
/*
 * Tanvi
 */
public class TripAdvisorPage extends PropertyReader implements IFilePath{
	private WebDriver driver;
	private Actions act;
	private GenericLib lib;
	/**
	 * Initiate the TripAdvisor page
	 * @param driver
	 * @throws Throwable 
	 */
	
	public TripAdvisorPage(WebDriver driver) throws Throwable {
		
		driver.get(getPropertyConfig(PROP,"URLTripAdv"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		lib = new GenericLib(driver);
	}
	

@FindBy(xpath="//div[@title='Search']")
private WebElement search_TextBox;
@FindBy(xpath="//input[@title='Search']")
private WebElement search_TextBox1;
@FindBy(xpath="span[text()='Search']")
private WebElement search_TextBox2;

@FindBy(id="mainSearch")
private WebElement mainSearchTextBox;
@FindBy(id="SEARCH_BUTTON")
private WebElement searchButton;
@FindBy(xpath="//div[@class='result-title']/span[@xpath='1']")
private WebElement SearchOption;
public void submitReview() throws Throwable {
	try
	{

	lib.waitForElemetToBePresent(search_TextBox);
	search_TextBox.click();
	mainSearchTextBox.sendKeys(getExcelDataConfig(EXCEL,"Sheet1",1,0));
	searchButton.click();
}
	catch(NullPointerException e)
	{
		lib.waitForElemetToBePresent(search_TextBox1);
		search_TextBox1.sendKeys(getExcelDataConfig(EXCEL,"Sheet1",1,0),Keys.ENTER);
	}
	SearchOption.click();
	}
	}
