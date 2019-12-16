package com.project.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.project.qa.DataProvider.ConfigFileReader;
import com.project.qa.Managers.FileReaderManager;


public class LandingPage {
	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(how=How.NAME,using="q")
	public WebElement SearchBox;
	
	@FindBy(how=How.NAME,using="btnK")
	public WebElement SearchButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='firstHeading']")
	public WebElement TestingWikihead;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="testing - Wikipedia")
	public WebElement TestingWikiLink;
	
	public void searchInGoogle() {
		
		SearchBox.sendKeys("testing");
		SearchButton.submit();
		
	}
	public void navigateToHomePage()
	{
		//driver.get("https://www.google.com/");
		driver.get(FileReaderManager.getInstance().getConfigReader().applicationURL());
	}
	public String getFirstHeading() {
		String Title=TestingWikihead.getText();
		return Title;
	}
	
	public void navigateToWikiPage() {
		TestingWikiLink.click();
	}
}
