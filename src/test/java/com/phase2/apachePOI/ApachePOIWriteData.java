package com.phase2.apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIWriteData {
	
	public static void main(String [] args) throws IOException {
	
	XSSFWorkbook workbook = new XSSFWorkbook();
	
	XSSFSheet sheetone = workbook.createSheet("SheetOne");
	
	Object [] [] data = {{"Name","Location","Experience"},
			{"Riya","Hyderabad","20"},
			{"Jaya","Bangalore","5"},
			{"Ravi","Delhi","10"}};
	
	int rows =  data.length;
	int columns = data[0].length;
	
	for(int r=0;r<rows;r++)
	{
		XSSFRow row = sheetone.createRow(r);
		
		for(int c=0;c<columns;c++)
		{
			XSSFCell cell = row.createCell(c);
			
			Object cellValue = data[r][c];
			
			if(cellValue instanceof String) {
				cell.setCellValue((String)cellValue);
			}
			else if(cellValue instanceof Integer) {
				
				cell.setCellValue((Integer)cellValue);
				
			}
		}
	}

	
	String excelFilepath = "C:\\Users\\sonal\\Desktop\\Excels\\Employees.xlsx";
	

	File excelfile = new File(excelFilepath);
	
	FileOutputStream fos = new FileOutputStream(excelfile);
	
	workbook.write(fos);
	
	workbook.close();
	
	System.out.println("task completed");
}
}





