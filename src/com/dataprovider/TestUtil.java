package com.dataprovider;

import java.util.ArrayList;

import com.util.Xls_Reader;

public class TestUtil 
{
	static Xls_Reader reader;
	//static int rowcount ;
	
	public static ArrayList<Object[]> getArrayData()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try
		{
			reader = new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\DataDrivenFramework\\excelfile\\datafile.xlsx");
			//rowcount = reader.getRowCount("Readdata");
			//System.out.println(rowcount);
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		for(int i = 2; i <= reader.getRowCount("Readdata"); i++)
		{
			 String firstname = reader.getCellData("Readdata", "firstname", i);
			 String lastname = reader.getCellData("Readdata", "lastname", i);
			 String mobnumber = reader.getCellData("Readdata", "mobilenumber", i);
			 String password = reader.getCellData("Readdata", "password", i);
			 
			 Object obj[] = {firstname,lastname,mobnumber,password};
			 mydata.add(obj);
		}
		
		return mydata;
		
	}

}
