package com.qa.opencart.runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.qa.opencart.steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/Cucumber.json"
        },
        monochrome = true
)
public class TestRunner {
}
