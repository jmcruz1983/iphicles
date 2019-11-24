import { anyString, instance, mock, reset, verify, when } from 'ts-mockito';
import { MoneyFormatterService } from './money-formatter.service';
import { CallApiService } from "../call-api/call-api.service";
import { HttpResponse } from "@angular/common/http";

describe('MoneyFormatterService', () => {
  let service;
  const callApiServiceMock: CallApiService = mock(CallApiService);

  beforeEach(() => {
    reset(callApiServiceMock);
  })

  it('price is missing', (() => {
    service = new MoneyFormatterService(instance(callApiServiceMock));
    service.formatPrice('').catch((err) => {
        expect(err.message).toBe('missing parameter')
    })
    verify(callApiServiceMock.post(anyString(), anyString())).never()
  }))

  it('price is correctly formatted', (() => {
    givenCallApiMockPost('1234');
    service = new MoneyFormatterService(instance(callApiServiceMock));
    service.formatPrice('1234')
      .then( price => expect(price).toEqual('1234'));
    verify(callApiServiceMock.post(anyString(), anyString())).once()
  }))

  function givenCallApiMockPost(mockedResponse: any) {
    const response: HttpResponse<any> = new HttpResponse({
        body: mockedResponse,
        status: 200
    })
    when(callApiServiceMock.post(anyString(), anyString()))
      .thenReturn(Promise.resolve(response));
  }
})
