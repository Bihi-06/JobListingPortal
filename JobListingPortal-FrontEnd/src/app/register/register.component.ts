import { Component } from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';


@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  user : any = {
    name:'',
    email:'',
    password:'',
    confirmPassword:'',
    pictureUrl: null,
    currentJob:'',
    role: ''
  };

  constructor(private authService: AuthService, private router: Router) {}

  register() {
    if(this.verifyPassword()){
      const {confirmPassword, ...userData} = this.user;
      this.authService.register(userData).subscribe(
        response => {
          console.log('User registered successfully');
          this.router.navigate(['/login']);
        },
        error => {
          console.error('Registration failed',error);
        }
      );
    } else {
      console.error('Passwords do not match');
    }
  }

  verifyPassword(): boolean {
   return this.user.password === this.user.confirmPassword;
  }



}
