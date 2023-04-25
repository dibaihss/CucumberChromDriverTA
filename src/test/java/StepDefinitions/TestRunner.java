package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
glue={"StepDefinitions"},
monochrome= true,
publish = true,
plugin = {"pretty","junit:target/report.xml"}
)
public class TestRunner {
}

//{"pretty","junit:target/report.xml"}
//{"pretty","html:targets/HtmlReports.html"}
//{"pretty","json:target/JSONReports.json"}

