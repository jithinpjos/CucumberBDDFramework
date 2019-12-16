package com.project.qa.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.project.qa.Enums.DriverType;
import com.project.qa.Enums.EnvironmentType;

public class ConfigFileReader {private Properties properties;
private final String propertyFilePath= "configs//Configuration.properties";

public ConfigFileReader(){
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties = new Properties();
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	}		
}

public DriverType getBrowser() {
	String browserName = properties.getProperty("browser");
	if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
	else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
	else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
	else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }
public EnvironmentType getEnvironment() {
	String environmentName = properties.getProperty("environment");
	if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
	else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
	else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }
public String getnodeURL(){
	String nodeURL = properties.getProperty("node_URL");
	if(nodeURL!= null) return nodeURL;
	else throw new RuntimeException("nodeURL not specified in the Configuration.properties file for the Key:driverPath");		
}
public String getDriverPath_Firefox(){
	String driverPath = properties.getProperty("driverPath_firefox");
	if(driverPath!= null) return driverPath;
	else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
}
public String getDriverPath_Chrome(){
	String driverPath = properties.getProperty("driverPath_chrome");
	if(driverPath!= null) return driverPath;
	else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
}
public Boolean getBrowserWindowSize() {
	String windowSize = properties.getProperty("windowMaximize");
	if(windowSize != null) return Boolean.valueOf(windowSize);
	return true;
	}
public long getImplicitlyWait() {		
	String implicitlyWait = properties.getProperty("implicitlyWait");
	if(implicitlyWait != null) {
		try{
			return Long.parseLong(implicitlyWait);
		}catch(NumberFormatException e) {
			throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
		}
	}
	return 30;		
}
public String applicationURL(){
	String driverPath = properties.getProperty("applicationURL");
	if(driverPath!= null) return driverPath;
	else throw new RuntimeException("Application URL not specified in the Configuration.properties file for the Key:applicationURL");		
}
public String getReportConfigPath(){
	 String reportConfigPath = properties.getProperty("reportConfigPath");
	 if(reportConfigPath!= null) return reportConfigPath;
	 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}
}