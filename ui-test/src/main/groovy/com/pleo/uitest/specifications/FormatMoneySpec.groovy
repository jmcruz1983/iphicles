package com.pleo.uitest.specifications

import geb.spock.GebSpec
import com.pleo.uitest.fe.pages.MainPage

import spock.lang.Stepwise

@Stepwise
class FormatMoneySpec extends GebSpec {

    def "User inserts a numeric amount"() {
        when:
        to MainPage

        then:
        formatPrice('1234.367')
    }

    def "Money is correctly formatted"() {
        when:
        at MainPage

        then:
        checkPrice('1 234.37')
    }

    def "User insert incorrect amount"() {
        when:
        to MainPage

        then:
        formatPrice('abcd.367')
    }

    def "Money is wrongly formatted"() {
        when:
        at MainPage

        then:
        checkPrice('NaN')
    }

    def "User clears the amount"() {
        when:
        to MainPage

        then:
        clearPrice()
    }

    def "Format is disabled"() {
        when:
        at MainPage

        then:
        checkDisabledFormatButton()
    }
}
