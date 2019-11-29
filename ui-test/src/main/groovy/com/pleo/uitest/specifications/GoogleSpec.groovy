package com.pleo.uitest.specifications

import geb.spock.GebSpec
import com.pleo.uitest.fe.pages.GooglePage

import spock.lang.Ignore
import spock.lang.Stepwise

@Ignore
@Stepwise
class GoogleSpec extends GebSpec {

    def "step1"() {
        when:
        to GooglePage

        then:
        step1()
    }

    def "step2"() {
        when:
        at GooglePage

        then:
        step2('blabla')
    }

    def "step3"() {
        when:
        at GooglePage

        then:
        step3()
    }
}
