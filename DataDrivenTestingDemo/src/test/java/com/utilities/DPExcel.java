package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.DataProvider;

 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Cell;

public class DPExcel {
	
	@DataProvider(name="validData",parallel=true)
	public Object[][] excelDataprovider1() throws IOException{
		Object[][] arrobj=getExcelData("src\\test\\resources\\DataFile.xlsx","Sheet1");
		return new Object[][] {
		arrobj[0]
		};
	}

	@DataProvider(name="invalidData",parallel=true)
	public Object[][] excelDataprovider2() throws IOException{
		Object[][] arrobj=getExcelData("src\\test\\resources\\DataFile.xlsx","Sheet1");
		return new Object[][] {
		arrobj[1],
		arrobj[2]
		};
	}
	
	public String[][] getExcelData(String fileName,String sheetName) throws IOException{
		String[][] data=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(0);
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfCloms=row.getLastCellNum();
			Cell cell;
			data = new String[noOfRows -1][noOfCloms];
			
			for(int i=1;i<noOfRows;i++) {
				for(int j=0;j<noOfCloms;j++) {
					row = sheet.getRow(i);
					cell=row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();				}
			}
		}
		catch (Exception e){
			System.out.println("The exception is:"+e.getMessage());
		}
		return data;
	}

}
