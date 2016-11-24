package com.manoj.cucumber.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json", "junit:target/junit.xml",
    "html:target/cucumber" }, features = "src/test/resources/features/1.feature")
public class CucumberTest {

}
