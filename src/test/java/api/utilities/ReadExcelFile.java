package api.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
public static FileInputStream inputStream;
public static XSSFWorkbook workBook;
public static XSSFSheet exceLSheet;
public static XSSFCell ceLL;

public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo/*column no.*/)
{
try 
{
	 inputStream = new FileInputStream(fileName);
	 workBook = new XSSFWorkbook(inputStream);
     exceLSheet = workBook.getSheet(sheetName);
	ceLL = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
	workBook.close();
	return ceLL.getStringCellValue();
	
}

catch (Exception e)	
{
 	return "";
}
}
public static int getRowCount (String fileName, String sheetName)
{
	try 
	{
	FileInputStream inputStream = new FileInputStream(fileName);
	// create XSSFWorkBook Class object for excel file manipulation
	XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
	exceLSheet = workBook.getSheet(sheetName);
	//get total no of rows
	int ttlRows = exceLSheet.getLastRowNum() + 1;
	workBook.close();
	return ttlRows;
	}
	catch (Exception e)
	{
		return 0;
	}
	}
public static int getColCount (String fileName, String sheetName)
{
	try {
	FileInputStream inputStream = new FileInputStream(fileName);
	// create XSSFWorkBook Class object for excel file manipulation
	XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
   exceLSheet = workBook.getSheet(sheetName);
	//get total no of rows
	int ttlRows = exceLSheet.getLastRowNum() + 1;
	workBook.close();
	return ttlRows;
	}
	catch(Exception e)
	{
		return 0;
	
	}
	}
}