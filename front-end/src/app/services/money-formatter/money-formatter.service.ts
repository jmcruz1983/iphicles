import {Injectable} from "@angular/core";
import { CallApiService } from "../call-api/call-api.service";
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MoneyFormatterService {

  constructor(private callApi: CallApiService) {}

  public formatPrice(price: string) {
    if (price) {
      return this.callApi
        .post(`${environment.baseUrl}${environment.formatPriceUrl}`, price)
        .then(res => {
          return res.body });
    }
    return Promise.reject(new Error('missing parameter'))
  }
}
