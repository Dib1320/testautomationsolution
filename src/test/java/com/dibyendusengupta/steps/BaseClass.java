package com.dibyendusengupta.steps;

import com.dibyendusengupta.utils.ServiceFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class BaseClass extends ServiceFactory {

	@After
	public void afterScenario(Scenario scenario) {
		tearDown();
	}
}
