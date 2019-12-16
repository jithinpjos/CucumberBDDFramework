package com.project.qa.Runners;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.project.qa.Managers.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@rerun/failed_scenarios.txt" }, 
					glue = { "com.project.qa.StepDefinitions" }, 
					plugin = { "pretty",
							"com.cucumber.listener.ExtentCucumberFormatter:rerun/com.project.qa.Cucumber-reports/report.html",
							 }, 
					monochrome = true)
public class FailureRerun {
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");

		
		Runtime.getRuntime().addShutdownHook(new Thread() {String Attachfile = "./rerun/com.project.qa.Cucumber-reports/report.html"; public void run() { try {
			  com.project.qa.Selenium.SendEmail.mailsend(Attachfile); } catch (IOException e) { e.printStackTrace();
			  } } });

	}
}