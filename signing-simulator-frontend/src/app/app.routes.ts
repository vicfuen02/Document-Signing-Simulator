import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { CertificatesComponent } from './components/certificates/certificates.component';

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'certificate',
        component: CertificatesComponent
    }
];
