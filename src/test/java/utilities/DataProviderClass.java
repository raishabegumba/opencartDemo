package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="LoginData")
	
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\data.xlsx";
		ExcelUtities ex= new ExcelUtities(path);
		int totalRows= ex.getRowCount("Sheet1");
		int totalCols=ex.getcellcount("Sheet1", 1);
		
		String loginData[][]= new String [totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++)//ignore heading at row 0
		{
			for(int j=0;j<totalCols;j++)
			{
				loginData[i-1][j]=ex.getcelldata("Sheet1", i, j);
			}
		}
		
		return loginData;
	}
	

}
