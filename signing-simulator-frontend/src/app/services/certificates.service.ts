import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CertificatesService {


  BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }


  getUploadedCertificates(userId: string) : Observable<any> {
    console.log('certificateService', userId);
    return this.http.get(this.BASE_URL + '/documents/' + userId
            );
  }


  uploadCertificate(certificate: any, userId: string) {
    console.log('certificateService', certificate);
    return this.http.post(this.BASE_URL + '/documents/upload/' + userId, 
      certificate
    );
  }

  signDocument(documentToSign: any, userId: string) {
    console.log('certificateService', documentToSign);
    return this.http.post(this.BASE_URL + '/sign/' + userId , 
      documentToSign
    );
  }


}
