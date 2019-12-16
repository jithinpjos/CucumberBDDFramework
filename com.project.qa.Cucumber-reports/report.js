$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/HomePage.feature");
formatter.feature({
  "line": 2,
  "name": "Validation of Google search result",
  "description": "",
  "id": "validation-of-google-search-result",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@RegressionTesting"
    }
  ]
});
formatter.before({
  "duration": 25561779100,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Google Page validation",
  "description": "",
  "id": "validation-of-google-search-result;google-page-validation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open chrome browser and enter url",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Enter the Search text",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Click on the Search button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on the result and Validating the result page",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageStepDef.open_chrome_browser_and_enter_url()"
});
formatter.result({
  "duration": 2487545600,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageStepDef.enter_the_Search_text()"
});
formatter.result({
  "duration": 2073859100,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageStepDef.click_on_the_Search_button()"
});
formatter.result({
  "duration": 4856249200,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageStepDef.click_on_the_result_and_Validating_the_result_page()"
});
formatter.result({
  "duration": 76636600,
  "error_message": "org.junit.ComparisonFailure: Software testing expected:\u003c[Software Test]ing\u003e but was:\u003c[Actual and expected are not match]ing\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat com.project.qa.StepDefinitions.LandingPageStepDef.click_on_the_result_and_Validating_the_result_page(LandingPageStepDef.java:41)\r\n\tat ✽.Then Click on the result and Validating the result page(src/test/resources/Features/HomePage.feature:7)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 554047800,
  "status": "passed"
});
formatter.after({
  "duration": 156213300,
  "status": "passed"
});
});