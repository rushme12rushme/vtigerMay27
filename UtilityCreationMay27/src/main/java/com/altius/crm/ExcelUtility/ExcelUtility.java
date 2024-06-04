package com.altius.crm.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/testScirptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		 Row row = sheet.getRow(rownum);
		 Cell cell = row.getCell(cellnum);
		String data= cell.getStringCellValue();
			wb.close();
		return data;
	}
	
	public void setDatainExcelFile(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/testScirptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		 Row row = sheet.getRow(rownum);
		 Cell cell = row.createCell(cellnum);
		 cell.setCellValue(data);
				
		FileOutputStream fos=new FileOutputStream("./TestData/testScirptdata.xlsx");
		 wb.write(fos);
		 wb.close();
	}
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/testScirptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		return rowcount;
	}
}
