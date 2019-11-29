package com.pleo.uitest

import spock.util.EmbeddedSpecRunner
import com.caseyscarborough.colorizer.Colorizer

import org.junit.runner.Result
import org.junit.runner.Description
import org.junit.runner.notification.Failure
import org.junit.runner.notification.RunListener

import groovy.transform.CompileStatic

class TestRunner extends RunListener {

	static void main(String[] args) {

		Colorizer.initializeMixins()

		try {
			new TestRunner().executeTests(args as Set)
		} catch (RetryException e) {
			println 'Tests could not be executed due to check failure(s) above'.red()
			System.exit(1)
		}
	}

	@CompileStatic
	void executeTests(Set args) {

		Configuration config = Configuration.getInstance(args)

		EmbeddedSpecRunner specRunner = new EmbeddedSpecRunner()
		specRunner.listeners << this

		config.specifications.each {
			Result result = specRunner.runClass(it)

			println "${result.runCount} executed"
			if (result.failureCount) {
				println "${result.failures}"
			}
			println "Finished specification in ${result.runTime/1000}s"
		}
	}

	@Override
	void testRunStarted(Description description) {
		println "Executing specification: $description"
	}

	@Override
	void testStarted(Description description) {
		println " - $description"
	}

	@Override
	void testFailure(Failure failure) {
		println "Failed: ${failure.message}".red()
	}
}
