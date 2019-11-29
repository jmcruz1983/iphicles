package com.pleo.uitest.specifications

import geb.spock.GebSpec
import com.pleo.uitest.fe.pages.MainPage

import spock.lang.Stepwise

@Stepwise
class FormatMoneySpec extends GebSpec {

    def "User formats money"() {
        when:
        to MainPage

        then:
        formatPrice('1234.367')
    }

    def "Money is correctly formatted"() {
        when:
        at MainPage

        then:
        checkPrice('1234.367')
    }
}
