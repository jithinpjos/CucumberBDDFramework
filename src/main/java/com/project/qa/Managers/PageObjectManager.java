package com.project.qa.Managers;

import org.openqa.selenium.WebDriver;

import com.project.qa.PageObjects.LandingPage;



public class PageObjectManager {
	private WebDriver driver;
	 
	 
	 private LandingPage landingpage;
	 	 
	 public PageObjectManager(WebDriver driver) {
	 
	 this.driver = driver;
	 
	 }
	 		
    public LandingPage getLandingPage() {
		 
	 return (landingpage == null) ? landingpage = new LandingPage(driver) : landingpage;
		 
	 }
	 
}
