package com.project.commonLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;

/**
 * 
 * @author Tanvi
 *
 */



	public class ListenerImpClass implements ITestListener{
		/**
		 * used to take screenshot whenever test is getting failed
		 */
		public String failedTestName;
		 public EventFiringWebDriver eDriver;
			public void onTestFailure(ITestResult result)
			{
			 failedTestName=result.getMethod().getMethodName();
				System.out.println("===FAIL==="+failedTestName);
				eDriver=new EventFiringWebDriver(BaseClass.driver);
				File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
				File destFile=new File("./sceenshot/"+failedTestName+".png");
			    try {
			    	FileUtils.copyFile(srcFile, destFile);
			    }
		catch(IOException e)
		{
			
		}}

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}}


