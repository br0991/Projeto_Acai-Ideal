package br.acai_ideal_runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "br.acai_ideal_steps",
		tags = {"@REQ0001-EscolherAcai, @REQ0002-PersonalizarAcai"},
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE
		)
public class Runner {

}
