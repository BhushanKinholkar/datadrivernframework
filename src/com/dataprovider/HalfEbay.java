package com.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class HalfEbay 
{
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
    ExtentHtmlReporter htmlReporter;


	
	@BeforeMethod
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		 ArrayList<Object[]> testdata = TestUtil.getArrayData();
		 return testdata.iterator();
		 
	}
	
	@Test(dataProvider="getTestData")
	public void Datacollect(String firstname, String lastname, String mobnumber, String password)
	{
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobnumber);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
	}
	
	@AfterMethod 
	public static void endTest()
	{
		driver.close();
	}

	
	
	
	
}
