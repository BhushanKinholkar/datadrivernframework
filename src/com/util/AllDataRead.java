package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllDataRead {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\DataDrivenFramework\\excelfile\\datafile.xlsx");
		int rowcount = reader.getRowCount("Readdata");
		System.out.println(rowcount);
		
		for(int i = 2 ; i <=rowcount ; i++)
		{
			 String firstname_val = reader.getCellData("Readdata", "firstname", i);
			 System.out.println(firstname_val);
			 
			 String lastname = reader.getCellData("Readdata", "lastname", i);
			 System.out.println(lastname);
			 
			 String mobilenumber = reader.getCellData("Readdata", "mobilenumber", i);
			 System.out.println(mobilenumber);
			 
			 String password = reader.getCellData("Readdata", "password", i);
			 System.out.println(password);
			 
				
			 driver.findElement(By.xpath("//input[@id='u_0_m']")).clear();
			 driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys(firstname_val);
			
			 
			 driver.findElement(By.xpath("//input[@id='u_0_o']")).clear();
			 driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys(lastname);
				
			 driver.findElement(By.xpath("//input[@id='u_0_r']")).clear();
			 driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys(mobilenumber);
				
			 driver.findElement(By.xpath("//input[@id='u_0_w']")).clear();
			 driver.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys(password);
			
		}
		
		
		
		

	}

}
