import { inject, TestBed, async } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { CallApiService } from './call-api.service';


describe('CallApiService', () => {

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ CallApiService ],
      imports: [ HttpClientModule ]
    });
  });

  it('expect service to be defined', inject([CallApiService], (callApi) => {
        expect(callApi.post).toBeDefined();
        expect(callApi.handleResponse).toBeDefined();
    }));

  it('expect handleError to reject with undefined error', async(inject([CallApiService], (callApi) => {
        callApi.handleError().catch((err) => {
            expect(err).toBeUndefined();
        });
    })));

  it('expect handleError to reject with status code', async(inject([CallApiService], (callApi) => {
        callApi.handleError({ status: 404 }).catch((err) => {
            expect(err.status).toBe(404);
        });
    })));

  it('expect handleResponse to be defined and body not parsed', inject([CallApiService], (callApi) => {
    const result = callApi.handleResponse({body: 'bla'});
    expect(typeof result).toBe('object');
    expect(typeof result.body).toBe('string');
    expect(result.body.x).not.toBeDefined();
  }));

  it('expect handleResponse to be defined and body parsed from string to json', inject([CallApiService], (callApi) => {
        const result = callApi.handleResponse({ body: '{"x":"2"}' });
        expect(typeof result).toBe('object');
        expect(typeof result.body).toBe('object');
        expect(result.body.x).toBeDefined();
        expect(result.body.x).toBe('2');
    }));
});
