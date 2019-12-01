import {Injectable} from '@angular/core';
import { CallApiService } from '../call-api/call-api.service';
import { environment } from '../../../environments/environment';
import { PriceResponse } from '../../model/price.interfaces';

@Injectable({
  providedIn: 'root'
})
export class MoneyFormatterService {

  constructor(private callApi: CallApiService) {}

  public formatPrice(price: string): Promise<PriceResponse> {
    if (price) {
      return this.callApi
        .post(`${environment.baseUrl}${environment.formatPriceUrl}`, price)
        .then(res => res.body.price);
    }
    return Promise.reject(new Error('missing parameter'));
  }
}
