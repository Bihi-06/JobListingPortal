import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import {Router, RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  Email: string ='';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) { }
  login() {
    this.authService.login(this.Email, this.password).subscribe(
      response =>{
        localStorage.setItem('token', response.jwtToken);
        this.router.navigate(['/register']);
      },
      error => {
        console.error('Login failed', error);
      }
      );
  }
}
