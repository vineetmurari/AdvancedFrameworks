package com.automate.withme.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/java/com/automate/withme/Features",
		glue="com.automate.withme.stepdefs",
		strict=true,
		monochrome=true,
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-html-reports", 
				"json:target/cucumber-html-reports/cucumber.json"}
		,tags={"@ValidCredwithExcel"}
		)

public class Firstfeature_runner { // This is feature runner
}
