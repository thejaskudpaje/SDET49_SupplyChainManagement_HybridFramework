package com.scm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * get the data present in the perticular cell
	 * @param key
	 * @throws IOException 
	 * @throws IOException
	 */
public String getExcelCellData(String path,String sheet, int row,int cell) throws IOException  {
FileInputStream fis=new FileInputStream(path);
Workbook wb = WorkbookFactory.create(fis);
String celldata=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
System.out.println(wb.getSheet(sheet).getRow(9).getLastCellNum());
return celldata;

}

/**
 * read the excel cell data by mentioning test case ID and column name
 * @throws IOException 
 */
public String getExceldDataByTestIDAndColName(String path, String sheet, String expTC_ID, String expColName) throws IOException {
	
	FileInputStream fis=new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet actSheet = wb.getSheet(sheet);
	int rowCount=wb.getSheet(sheet).getLastRowNum();
	System.out.println(rowCount);
	int actRowNum=0;
	int cellCount=0;
	String expData="";
	String actTestID="";
	String actColName="";
	for(int i=0;i<=rowCount;i++) {
	try {
		actTestID=actSheet.getRow(i).getCell(0).toString();
	}
	catch(Exception e) {}
	if(actTestID.equalsIgnoreCase(expTC_ID)) {
		break;
	}
	actRowNum++;
	}
	
	
	System.out.println(actRowNum);
	int rowNumForColName=actRowNum-1;
	for(int i=0;i<=cellCount;i++) {
	try {actColName=actSheet.getRow(rowNumForColName).getCell(i).toString();
		
	}
	catch(Exception e) {
	}
	if(actColName.equalsIgnoreCase(expColName)) {
		break;
	}
	cellCount++;
	}
	System.out.println(cellCount);
	expData=actSheet.getRow(actRowNum).getCell(cellCount).toString();
	
	return expData;
	
}


}
