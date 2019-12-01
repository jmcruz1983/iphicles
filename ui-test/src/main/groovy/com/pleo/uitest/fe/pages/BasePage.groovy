package com.pleo.uitest.fe.pages

import geb.Page
import geb.navigator.Navigator
import org.openqa.selenium.WebDriverException

class BasePage extends Page {

    static boolean clickAndRetry(Navigator element) {
        int retryCount = 30
        while(retryCount > 0){
            try{
                retryCount--
                element.click()
                break
            }catch (WebDriverException e){
                try {
                    Thread.sleep(200)
                } catch (InterruptedException e1) {
                    e1.printStackTrace()
                }
            }
        }
        return retryCount > 0
    }

    boolean check(Navigator element) {
        waitFor {
            element.displayed
        }
        return element.displayed
    }

    boolean checkTextEmpty(Navigator element) {
        waitFor {
            element.text().empty
        }
        return element.text().empty
    }

    boolean checkTextNotEmpty(Navigator element) {
        waitFor {
            element.text().length() > 0
        }
        return element.text().length() > 0
    }
}
