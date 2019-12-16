package com.project.qa.StepDefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.project.qa.Cucumber.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Team QA");
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
						.getScreenshotAs(OutputType.FILE);
				File theDir = new File("screenshots");

				// if the directory does not exist, create it
				if (!theDir.exists()) {
					System.out.println("creating directory: " + theDir.getName());
					boolean result = false;

					try {
						theDir.mkdirs();
						result = true;
					} catch (SecurityException se) {
						// handle it
					}
					if (result) {
						System.out.println("DIR created");
					}
				}

				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the com.project.qa.Cucumber-report
				// folder
				// File destinationPath = new File(System.getProperty("user.dir") +
				// "/target/com.project.qa.Cucumber-reports/screenshots/" + screenshotName + ".png");
				File destinationPath = new File(
						System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png");
				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
	}

	@After(order = 0)
	public void AfterSteps() throws IOException {
		testContext.getWebDriverManager().closeDriver();
	}

}