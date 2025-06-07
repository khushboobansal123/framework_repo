package com.crm.generic.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.BaseClassUtility.BaseClass;
import com.crm.generic.webdriverutility.UtilityClassObject;


public class ListImp implements ITestListener, ISuiteListener {
	
	public ExtentReports report;
	public ExtentTest test;
	String time=new Date().toString().replace(" ","_").replace(":","_");
	
	public void onStart(ISuite suite)
	{
		System.out.println("Report Configuration");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Report");
		spark.config().setReportName("Vtiger CRM");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome");
		
	}
	
	public void onFinish(ISuite suite)
	{
		System.out.println("Report backup");
		report.flush();
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is started");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+" is started");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is success");
		test.log(Status.PASS, result.getMethod().getMethodName()+" is success");
	}
	
	public void onTestFailure(ITestResult result)
	{
		
		
		TakesScreenshot tks=(TakesScreenshot)UtilityClassObject.getDriver();
		String filepath=tks.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(filepath,result.getMethod().getMethodName()+""+time);
		
		System.out.println(result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
	}
	

}
