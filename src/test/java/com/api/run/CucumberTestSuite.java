package com.api.run;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" }, glue = { "com.api.stepdefinitions" }, features = "src/test/resources/features")

public class CucumberTestSuite {

}
