package com.project.qa.Utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInExcel {
	 static String filePath = System.getProperty("user.dir") + "\\testData";
	 static	String fileName = "TestData.xlsx";

	public static String readExcel(String sheetName, int rowNum, int colNum) throws IOException {

	//	String filePath = System.getProperty("user.dir") + "\\testData";
	//	String fileName = "TestData.xlsx";
		File file = new File(filePath + "\\" + fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook Workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			Workbook = new XSSFWorkbook(inputStream);

		}

		else if (fileExtensionName.equals(".xls")) {

			Workbook = new HSSFWorkbook(inputStream);

		}

		Sheet Sheet_Name = Workbook.getSheet(sheetName);
		String CellData = (Sheet_Name.getRow(rowNum).getCell(colNum)).getStringCellValue();

		return CellData;

	}
	
	 public static void writeExcel(String sheetName, int rowNum, int colNum ,String dataToWrite) throws IOException{

	        //Create an object of File class to open xlsx file
		// String filePath = System.getProperty("user.dir") + "\\testData";
		//	String fileName = "TestData.xlsx";

	        File file =    new File(filePath+"\\"+fileName);

	        //Create an object of FileInputStream class to read excel file

	        FileInputStream inputStream = new FileInputStream(file);

	        Workbook guru99Workbook = null;

	        //Find the file extension by splitting  file name in substring and getting only extension name

	        String fileExtensionName = fileName.substring(fileName.indexOf("."));

	        //Check condition if the file is xlsx file

	        if(fileExtensionName.equals(".xlsx")){

	        //If it is xlsx file then create object of XSSFWorkbook class

	        guru99Workbook = new XSSFWorkbook(inputStream);

	        }
	        else if(fileExtensionName.equals(".xls")){

	            //If it is xls file then create object of XSSFWorkbook class

	            guru99Workbook = new HSSFWorkbook(inputStream);

	        }    

	        Sheet Sheet_Name = guru99Workbook.getSheet(sheetName);
			(Sheet_Name.createRow(rowNum).createCell(colNum)).setCellValue(dataToWrite);

	    //Close input stream

	    inputStream.close();

	    //Create an object of FileOutputStream class to create write data in excel file

	    FileOutputStream outputStream = new FileOutputStream(file);

	    //write data in the excel file

	    guru99Workbook.write(outputStream);

	    //close output stream

	    outputStream.close();

	}

}
