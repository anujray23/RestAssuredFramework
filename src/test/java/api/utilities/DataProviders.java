package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="AllData")// dp returns 2d array and also need to give data provider name and annotan
	public String [][] AllDataProvider()
	{
		// now to read data from excel for row and col , we need total row and col for that we created ReadExcelFile so to access that
		
		String fName = System.getProperty("user.dir")+"//TestData//RestAssuredApi.xlsx";// here we get directory RestAssurredAut.Fr. path
	// in this string I append testdata folder and xlsx file
		// now to get total row count 
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");// this will retirn int value that contain total row and col
		int ttlColCnt = ReadExcelFile.getColCount(fName, "Sheet1");
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		// now to read data from every cell value by calling method getcell value of ReadExcelFile Class
		// here we need to use two for loop 1 for and another for column
		for(int rowNo =1; rowNo<ttlRowCnt; rowNo++)
		{
			for(int colNo=0;colNo<ttlColCnt;colNo++)
			{
				// from here we read data in above array that will be return
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
				// data filled
			}
		}
		
		// now we return it
		return userData;
	}
// this data provider complete and we provide all data in 2d array now we will create an another dataProvider
	// where we provide user name bec in few test case we need only user name like get user , delete user
	
	
	
	
	
	// here we have created two dapro. one dp reads all data and another dp has only username return in string array and after dp we created test case for dp testing
	// where by dp use we fetch data no fake data here 
	






	@DataProvider(name="UserNamesData")// dp returns 2d array and also need to give data provider name and annotan
	public String [] UserNamesDataProvider()
	{
		// now to read data from excel for row and col , we need total row and col for that we created ReadExcelFile so to access that
		
		String fName = System.getProperty("user.dir")+"//TestData//RestAssuredApi.xlsx";// here we get directory RestAssurredAut.Fr. path
	// in this string I append testdata folder and xlsx file
		// now to get total row count 
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");// this will retirn int value that contain total row and col
		//int ttlColCnt = ReadExcelFile.getColCount(fName, "Sheet1");
		String userNamesData[] = new String[ttlRowCnt-1];
		// now to read data from every cell value by calling method getcell value of ReadExcelFile Class
		// here we need to use two for loop 1 for and another for column
		for(int rowNo =1; rowNo<ttlRowCnt; rowNo++)
		{
			userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, 1);
		}
		
		// now we return it
		return userNamesData;
	}
// this data provider complete and we provide all data in 2d array now we will create an another dataProvider
	// where we provide user name bec in few test case we need only user name like get user , delete user
	
	}
// here we get user name 