package testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FetchExcelData {

	@DataProvider(name = "TC1_Data")
	public static Object[][] getExcelTC1() throws IOException 
	{
		String sheetName ="Sheet1";
		String filePath ="/excel/testData1.xlsx" ;
		Object Data2[][]= readExcelData(filePath,sheetName);
		return Data2;
	}

	@DataProvider(name = "TC2_Data")
	public static Object[][] getExcelTC2() throws IOException 
	{
		String sheetName ="Sheet1";
		String filePath ="/excel/testData2.xlsx" ;
		Object Data2[][]= readExcelData(filePath,sheetName);
		return Data2;
	}

	public static Object[][] readExcelData(String filePath, String sheetName) throws IOException 
	{
		FileInputStream fileInputStream= new FileInputStream(System.getProperty("user.dir") + filePath);  
		XSSFWorkbook workbook = new XSSFWorkbook (fileInputStream);  
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		XSSFRow Row=worksheet.getRow(0);  

		int RowNum = worksheet.getPhysicalNumberOfRows();
		int ColNum= Row.getLastCellNum(); 

		Object Data[][]= new Object[RowNum-1][ColNum]; 

		for(int i=0; i<RowNum-1; i++) 
		{  
			XSSFRow row= worksheet.getRow(i+1);

			for (int j=0; j<ColNum; j++) 
			{
				if(row==null)
					Data[i][j]= "";
				else 
				{
					XSSFCell cell= row.getCell(j);
					if(cell==null)
						Data[i][j]= "";  
					else
					{
						DataFormatter formatter = new DataFormatter(); 
						String value=formatter.formatCellValue(cell);

						Data[i][j]=value; 
					}
				}
			}

		}
		workbook.close();
		return Data;



	}

}
