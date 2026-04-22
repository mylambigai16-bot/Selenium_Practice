package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DPExcelData {
	
	public String[][] getData(String File,String SheetName){
		String[][] data=null;
		try {
			FileInputStream fis=new FileInputStream(File);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(SheetName);
			XSSFRow row=sheet.getRow(0);
			int rowCount=sheet.getPhysicalNumberOfRows();
			int colmCount=row.getLastCellNum();
			Cell cell;
			data=new String[rowCount-1][colmCount];
			for(int i=1;i<rowCount;i++) {
				for(int j=0;j<colmCount;j++) {
					row=sheet.getRow(i);
					cell=row.getCell(j);
					DataFormatter formatter = new DataFormatter();
					data[i-1][j] = formatter.formatCellValue(cell);

				}
			}
			workbook.close();
	        fis.close(); 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	@DataProvider(name="validlogin", parallel=true)
	public Object[][] excel1(){
		Object[][] ExcelData=getData("src\\test\\resources\\TestDataFile.xlsx","Sheet1");
		return new Object[][] {
			ExcelData[0]
					
		};
		
	}
	@DataProvider(name="invalidlogin",parallel=true)
	public Object[][] excel2(){
		Object[][] ExcelData=getData("src\\test\\resources\\TestDataFile.xlsx","Sheet1");
		return new Object[][] {
			ExcelData[1],ExcelData[2]
		};
	}
	@DataProvider(name="validsearch",parallel=true)
	public Object[][] excel3(){
		Object[][] ExcelData=getData("src\\test\\resources\\TestDataFile.xlsx","Sheet2");
		return  ExcelData;
	}
	@DataProvider(name="invalidsearch",parallel=true)
	public Object[][] excel4(){
		Object[][] ExcelData=getData("src\\test\\resources\\TestDataFile.xlsx","Sheet3");
		return ExcelData;
	}
	

}
