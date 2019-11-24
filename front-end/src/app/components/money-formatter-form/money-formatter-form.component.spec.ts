import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { MoneyFormatterFormComponent } from './money-formatter-form.component';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import {anyString, instance, mock, reset, verify, when} from "ts-mockito";
import { MoneyFormatterService } from "../../services/money-formatter/money-formatter.service";
import { By } from "@angular/platform-browser";
import { DebugElement } from "@angular/core";

describe('MoneyFormatterFormComponent', () => {
  let component: MoneyFormatterFormComponent;
  let fixture: ComponentFixture<MoneyFormatterFormComponent>;
  let moneyFormatterServiceMock: MoneyFormatterService;

  beforeEach(async(() => {
    moneyFormatterServiceMock = mock(MoneyFormatterService);
    when(moneyFormatterServiceMock.formatPrice(anyString()))
      .thenReturn(Promise.resolve('54321'));
    TestBed.configureTestingModule({
      imports:[
        FormsModule,
        HttpClientModule
      ],
      providers: [
        { provide: MoneyFormatterService,
          useValue: instance(moneyFormatterServiceMock) }
      ],
      declarations: [ MoneyFormatterFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoneyFormatterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should have form elements', () => {
    const fixture = TestBed.createComponent(MoneyFormatterFormComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('input#amount')).toBeTruthy();
    expect(compiled.querySelector('div#result')).toBeTruthy();
    expect(compiled.querySelector('button#format')).toBeTruthy();
  });

  it('clean up clears the data', () => {
    const fixture = TestBed.createComponent(MoneyFormatterFormComponent);
    const component = fixture.componentInstance;
    component.cleanUp()
    fixture.detectChanges();
    expect(component.amount).toBe('')
    expect(component.result).toBe('')
  });

  it('format button calls service', () => {
    const fixture = TestBed.createComponent(MoneyFormatterFormComponent);
    let format: DebugElement = fixture.debugElement.query(By.css('button#format'));
    format.nativeElement.click();
    fixture.detectChanges();
    verify(moneyFormatterServiceMock.formatPrice(anyString())).once()
  });
});
