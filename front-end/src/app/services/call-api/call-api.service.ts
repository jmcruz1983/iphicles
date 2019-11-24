import { Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CallApiService {

  constructor(private http: HttpClient) {}

  public post(url: string, body?: any, options?: HttpHeaders) {
    let opts = this.configureHeaders(options);
    return this.http
      .post(url, body ? body : '', {headers: opts, observe: 'response'})
      .toPromise()
      .then(this.handleResponse.bind(this))
      .catch(this.handleError.bind(this));
  }

  private handleResponse(res: any) {
    if (res && res.body && typeof res.body === 'string') {
      try {
        res.body = JSON.parse(res.body);
      } catch (e) {}
    }
    return typeof res === 'string' ? JSON.parse(res) : res;
  }

  private handleError(error: Response | any): Promise<any> {
    return Promise.reject(error);
  }

  private configureHeaders(options: HttpHeaders): HttpHeaders {
    if (!options) {
      options = new HttpHeaders({
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      });
    }
    return options;
  }
}
