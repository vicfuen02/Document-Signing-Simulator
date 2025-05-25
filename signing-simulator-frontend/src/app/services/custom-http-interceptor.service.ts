import { HttpEventType, HttpHeaders, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { tap } from 'rxjs';

export const customHttpInterceptor: HttpInterceptorFn = (req, next) => {
  const headerTokenName = 'X-User-Token';


  let headers = new HttpHeaders();
  let r = req.clone();
  console.log('Request URL: ' + req.url);
  return next(r).pipe(tap(event => {
    if (event.type === HttpEventType.Response) {
      console.log(req.url, 'returned a response with status', event.status);
      var token = (event.headers.get(headerTokenName) as string);
    }
  }));


}