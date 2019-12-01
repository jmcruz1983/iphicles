import { browser, by, element, protractor } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('app-root #title')).getText() as Promise<string>;
  }

  setPriceAmount(price: string) {
    return element(by.css('input#amount')).sendKeys(price) as Promise<any>;
  }

  clickAmountButton() {
    return element(by.css('input#amount')).click() as Promise<any>;
  }

  clickFormatButton() {
    return element(by.css('button#format')).click() as Promise<any>;
  }

  getFormattedPrice() {
    return element(by.css('div#result')).getText() as Promise<string>;
  }
}
