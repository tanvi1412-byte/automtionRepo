package com.project.commonLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PropertyReader implements IFilePath {
	private static Workbook workbook;
	private static Sheet sheet;
	private static String path;
	private static Properties prop;
	/**
	 * Get a property value
	 * @param key
	 * @return String with the key's value
	 */
	public static String getPropertyConfig(String filePath,String key) throws Throwable
	{
		prop=new Properties();
		prop.load(new FileInputStream(filePath));
		return prop.getProperty(key);
}
	/**
	 * @param filePath
	 * @param sheetName
	 * @return Sheet specified
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public static String getExcelDataConfig(String filePath,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, FileNotFoundException, IOException {
	workbook=WorkbookFactory.create(new FileInputStream(filePath));
	String cellValue=workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return cellValue;
		
	}
}
