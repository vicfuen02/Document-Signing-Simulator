import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  userInfo = {
    user: null,
    password: null
  };

  errorMsg = "";

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }


  fetchLogin(): void {
    this.errorMsg = "";
    console.log(this.userInfo)
    this.loginService.getLogin(this.userInfo).subscribe({
      next: user => { 
        console.log(user);
        this.router.navigate(['/certificate'], { state: user })
      },
      error: (err) => {
        this.errorMsg = err.error.message;
        console.log(this.errorMsg);
      }
    })
    
  }




}