package com.project.qa.Selenium;

import java.io.IOException;

import com.project.qa.Utilities.DataInExcel;
import com.project.qa.Utilities.utility;

public class TestDataFromExcel {
	
	public static String getLineOfBusiness() throws IOException {
		return DataInExcel.readExcel("Sheet1", 0, 1);
	}
	public static String getShowNameFromExcel() throws IOException {
		return DataInExcel.readExcel("Sheet2", 0, 1);	
		
	}
	public static String getShowName() throws IOException {
		String ShowName=getShowNameFromExcel()+" "+utility.getCurrentDateWithTime();
		return ShowName;
	}
	public static String getJurisdictionState() throws IOException {
		return DataInExcel.readExcel("Sheet3", 1, 1);
	}

}
