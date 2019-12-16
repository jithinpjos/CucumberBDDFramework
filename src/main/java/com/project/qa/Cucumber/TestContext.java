package com.project.qa.Cucumber;

import java.net.MalformedURLException;

import com.project.qa.Managers.PageObjectManager;
import com.project.qa.Managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriverManager;
	 private PageObjectManager pageObjectManager;
	 public ScenarioContext scenarioContext;
	 
	 public TestContext() throws MalformedURLException{
	 webDriverManager = new WebDriverManager();
	 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	 scenarioContext = new ScenarioContext();
	 }
	 
	 public WebDriverManager getWebDriverManager() {
	 return webDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
	 return pageObjectManager;
	 }
	 
	 public ScenarioContext getScenarioContext() {
	 return scenarioContext;
	 }

}
