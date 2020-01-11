package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\DataDrivenFramework\\excelfile\\datafile.xlsx");
		int row_count_Val = reader.getRowCount("Readdata");
		System.out.println(row_count_Val);
		
		String first_val = reader.getCellData("Readdata", "firstname", 2);
		System.out.println(first_val);
		
		/*String first_val2 = reader.getCellData("Readdata", "firstname", 3);
		System.out.println(first_val2);*/
		
		String lastname = reader.getCellData("Readdata", "lastname", 2);
		System.out.println(lastname);
		
		String mobilenumber = reader.getCellData("Readdata", "mobilenumber", 2);
		System.out.println(mobilenumber);
		
		String password = reader.getCellData("Readdata", "password", 2);
		System.out.println(password);
		
		driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys(first_val);

		//driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys(first_val2);
		
		
		driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys(mobilenumber);
		driver.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys(password);
		
		
		
		
		
		
		
	}

}
