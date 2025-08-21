package com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.saucedemo.stepdefinitions",
        tags = "@SauceDemo",
        plugin = {
                "pretty",                                    // Formato bonito en consola
                "json:target/cucumber-reports/cucumber.json", // Para reportes de Serenity
                "html:target/cucumber-html-report"           // Reporte HTML básico
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,   // Genera métodos en camelCase
        dryRun = false,                                     // false = ejecuta los tests
        monochrome = true                                   // Output más legible en consola
)
public class TestRunner {
}