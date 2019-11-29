package com.pleo.uitest

import spock.lang.Ignore
import groovy.transform.CompileStatic

import geb.spock.GebSpec
import org.reflections.Reflections

@CompileStatic
class Configuration {

	static final String FE_URL = 'FE_URL'
	static final String DRIVER_URL = 'DRIVER_URL'

	static final String WAITING_TIMEOUT = 'WAITING_TIMEOUT'
	static final Integer DEFAULT_WAITING_TIMEOUT = 10

	static Configuration instance

	static Configuration getInstance(Set specs = null) {
		instance = instance ?: new Configuration(specs)
		return instance
	}

	String driverURL
	String frontEndURL
	Integer waitingTimeout

	Set<Class<?>> specifications
	Set<Class<?>> ignoredSpecifications

    Configuration(Set specs) {
		configureSettings()
		gatherSpecifications(specs)

		println 'Tests configuration is the following'
		println "FE_URL: [$frontEndURL]"
		println "DRIVER_URL: [$driverURL]"
		println "WAITING_TIMEOUT: [$waitingTimeout]"
		println "Specifications to be executed: ${specifications ?: 'none'}"
		println "Specifications ignored: ${ignoredSpecifications ?: 'none'}"
		println ''
	}

	private void configureSettings() {
		Map env = System.getenv()
		frontEndURL = env[FE_URL] ?: 'http://localhost:5000'
		driverURL = env[DRIVER_URL] ?: 'http://localhost:9515'
		waitingTimeout = env[WAITING_TIMEOUT] as Integer ?: DEFAULT_WAITING_TIMEOUT
	}

	private void gatherSpecifications(Set specs) {
		specifications = new Reflections('com.pleo.uitest.specifications').getSubTypesOf(GebSpec)
		if (specs) {
			specifications = specifications.findAll { Class it -> specs.contains(it.simpleName) }
		}
		ignoredSpecifications = specifications.findAll { Class it -> it.isAnnotationPresent(Ignore) }
		specifications = specifications - ignoredSpecifications
	}
}