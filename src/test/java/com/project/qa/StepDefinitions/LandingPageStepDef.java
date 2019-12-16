package com.project.qa.StepDefinitions;

import org.junit.Assert;

import com.project.qa.Cucumber.TestContext;
import com.project.qa.PageObjects.LandingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LandingPageStepDef {
	TestContext testContext;
	LandingPage LandingPage;

   
	
	public LandingPageStepDef(TestContext context) {
		testContext = context;
		LandingPage = testContext.getPageObjectManager().getLandingPage();
	}

	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{	
		LandingPage.navigateToHomePage();
	}
	@When("^Enter the Search text$")
	public void enter_the_Search_text() throws Throwable {
		LandingPage.searchInGoogle();
			   	}
	@When("^Click on the Search button$")
	public void click_on_the_Search_button() throws Throwable {
		LandingPage.navigateToWikiPage();
	    	} 
	@Then("^Click on the result and Validating the result page$")
	public void click_on_the_result_and_Validating_the_result_page() throws Throwable {
		
		String Expected="Software Testing";
	    String Actual=LandingPage.getFirstHeading();
	    Assert.assertEquals(Actual, Expected,"Actual and expected are not matching");
	}

}
