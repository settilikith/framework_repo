package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.Utilityclassobject;

import baseutility.Exampleclass;

public class Listener implements ITestListener ,ISuiteListener{
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		//spark report config
		String time =new Date().toString().replace(" ", "_").replace(":", " ");
		ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReport/"+time+"report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		//adds Env information & create test
	    report =new ExtentReports();
		report.attachReporter(spark);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
     	report.flush();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+">=====start===");
		 test =report.createTest(result.getMethod().getMethodName());
		 Utilityclassobject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+">====pass===>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+">=====end===");
		 test.log(Status.PASS,result.getMethod().getMethodName()+">===Success===>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		TakesScreenshot ts =(TakesScreenshot)Utilityclassobject.getDriver();
		String file =ts.getScreenshotAs(OutputType.BASE64);
		String time =new Date().toString().replace(" ", "_").replace(":", " ");
		test.addScreenCaptureFromBase64String(file,testname+" "+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+">==Fail==<");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
