package com.pleo.uitest.fe.pages

class GooglePage extends BasePage {

    static at = {
        logo
    }

    static content = {
        logo { $('img#hplogo') }
        input { $('#tsf > div:nth-child(2) > div > div > div > div > input') }
        searchButton { $('#tsf > div:nth-child(2) > div > div > center > input') }
    }

    boolean step1(){
        println 'step1'
        check(logo)
    }

    boolean step2(String search){
        println 'step2'
        check(input)
        input.value search
    }

    boolean step3(){
        println 'step3'
        check(input)
        searchButton.click()
    }
}