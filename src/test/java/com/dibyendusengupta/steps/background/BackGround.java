package com.dibyendusengupta.steps.background;


import com.dibyendusengupta.utils.ServiceFactory;

import cucumber.api.java.en.Given;

public class BackGround extends ServiceFactory {

	@Given("^User launches the application \"([^\"]*)\" in Browser \"([^\"]*)\" for testcase \"([^\"]*)\"$")
	public void user_launches_the_application_in_Browser(String URL, String browserName, String testName) {

		testcaseName = testName;

		ServiceFactory.getDriver(browserName.toUpperCase());

		capture.createFolder();

		driver.get(URL);

	}

}
