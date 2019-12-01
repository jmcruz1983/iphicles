package com.pleo.uitest.fe.pages

class MainPage extends BasePage {

    static url = ''

    static at = {
        titleSpan
    }

    static content = {
        titleSpan { $('span#title') }
        amountInput { $('input#amount') }
        resultsDiv { $('div#result') }
        formatButton { $('button#format') }
        disabledFormatButton { $('button#format[disabled]') }
    }

    boolean formatPrice(String price){
        check(titleSpan)
        check(amountInput)
        amountInput.value price
        check(formatButton)
        return clickAndRetry(formatButton)
    }

    boolean clearPrice(){
        check(titleSpan)
        check(amountInput)
        return amountInput.value('')
    }

    boolean checkPrice(String price){
        check(resultsDiv)
        checkTextNotEmpty(resultsDiv)
        return resultsDiv.text().contains(price)
    }

    boolean checkDisabledFormatButton(){
        check(resultsDiv)
        checkTextEmpty(resultsDiv)
        return check(disabledFormatButton)
    }
}