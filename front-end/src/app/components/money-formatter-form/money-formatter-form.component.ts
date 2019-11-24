import { Component, OnInit } from '@angular/core';
import { MoneyFormatterService } from "../../services/money-formatter/money-formatter.service";

@Component({
  selector: 'money-formatter-form',
  templateUrl: './money-formatter-form.component.html',
  styleUrls: ['./money-formatter-form.component.css']
})
export class MoneyFormatterFormComponent implements OnInit {

  amount: string = '2310000.159897';
  result: string = '2 310 000.16';
  disabled: boolean = false;

  constructor(private moneyFormatter: MoneyFormatterService) { }

  ngOnInit() {}

  public cleanUp(): void {
    this.amount = '';
    this.result = '';
    this.disabled = true;
  }

  public valueChange(value: KeyboardEvent) {
    this.disabled = false;
  }

  public formatPrice(): void {
    if(this.amount) {
      this.moneyFormatter
        .formatPrice(this.amount.toString())
        .then(price => {
          this.result = price.toString()
        })
    }
  }
}
