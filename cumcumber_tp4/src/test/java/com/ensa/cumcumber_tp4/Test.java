package com.ensa.cumcumber_tp4;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
/**
 * 
 * @author ayoub ghayati
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/Features",glue = "GlueTest.Steps")
public class Test {

	public static void main(String[] args) {

	}

}
