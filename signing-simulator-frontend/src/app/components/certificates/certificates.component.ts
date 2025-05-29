import { Component, OnInit } from '@angular/core';
import { CertificatesService } from '../../services/certificates.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-certificates',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './certificates.component.html',
  styleUrl: './certificates.component.scss'
})
export class CertificatesComponent implements OnInit {

  uploadedCertificates = [];
  navg: any = {};
  uploadedMsg = "";
  signMsg = "";
  user = {
    id : null
  };
  certificates: any[] = [];

  certificatesMocked = [{
    id: 1000,
    name: "Certificado de Pepe Mocked"
  }]
  loaded: boolean = false;
  

  constructor(
    private certificatesService: CertificatesService,
    private router: Router
  ) {
    const navigation = this.router.getCurrentNavigation();
    console.log('constructor certificateService', navigation?.extras.state)
    this.navg = navigation?.extras.state;
  }

  ngOnInit(): void {
    this.certificates = this.getUploadedCertificates();
    if (!this.loaded && this.certificates.length == 0) {
      this.loaded = true;
      this.certificates = this.certificatesMocked;
    }
    
  }

  
  getUploadedMsg = ''
  getUploadedCertificates(): any[] {
    console.log('getUploadedCertificates', this.navg);

    this.certificatesService.getUploadedCertificates(this.navg.user.id).subscribe({
      next: certificatesResponse => { 
        console.log(certificatesResponse);
        this.certificates = certificatesResponse.certificates
        this.getUploadedMsg = '';
      },
      error: (err) => {
        this.getUploadedMsg = err.error.message;
        console.log(this.getUploadedMsg);
      }
    })


    return this.certificates;
  }
  

  certificate = {
    name: null,
    certificate: null,
    password: null,
    userId: null
  }
  certificateUploading = null;
  onUploadFile(event: any) {

    if (!event || !event.target) {
      return;
    }

    const file: File = event.target.files[0];

    if (!file) {
      return;
    }

    this.getBase64(file).then((result) => {

        var certificate = {
          name: file.name,
          certificate: result as string,
          password: this.certificate.password,
          userId: this.navg.user.id
        }

        this.certificatesService.uploadCertificate(certificate, this.navg.user.id).subscribe({
          next: certificate => { 
            console.log(certificate);
            this.uploadedMsg = '';
            this.certificateUploading = null;
            this.certificates = this.getUploadedCertificates();
            
          },
          error: (err) => {
            this.uploadedMsg = err.error.message;
            console.log(this.uploadedMsg);
            this.certificateUploading = null;
            this.certificates = this.getUploadedCertificates();
          }
        });
      }, (error) => {
        console.log('Error: ', error);
      }
      
    );

  }


  documentToSign = {
    documentBytes: null,
    certificatePassword: null
  }


  documentSigning = null;

  onSignSelected(event: any) {

    if (!event || !event.target) {
      return;
    }
    const file: File = event.target.files[0];

    if (!file) {
      return;
    }
    
    this.getBase64(file).then((result) => {

      var documentToSign = {
        documentBytes: result as string,
        certificatePassword: this.documentToSign.certificatePassword
      }

        this.certificatesService.signDocument(documentToSign, this.navg.user.id).subscribe({
          next: documentSigned => { 
            var document: any = documentSigned;
            console.log(documentSigned );
            this.signMsg = document.document.documentBytes;
            this.documentSigning = null;
          },
          error: (err) => {
            this.signMsg = err.error.message;
            console.log(this.signMsg);
            this.documentSigning = null;
          }
        });
        this.certificates = this.getUploadedCertificates();
      }, (error) => {
        console.log('Error: ', error);
      }
      
    );
  }


  getBase64(file: File) : Promise<String> {
    return new Promise<string>((resolve, reject) => {
      var reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function () {
        console.log(reader.result);
        resolve(reader.result as string);
      };
      reader.onerror = function (error) {
        reject('Error: '+ error);
        console.log('Error: ', error);
      };
    });
  }
 

 


}
