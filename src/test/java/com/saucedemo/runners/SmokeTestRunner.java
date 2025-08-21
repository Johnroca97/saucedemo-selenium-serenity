package com.saucedemo.runners;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "com.saucedemo.stepdefinitions")
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@smoke")
public class SmokeTestRunner {
}
