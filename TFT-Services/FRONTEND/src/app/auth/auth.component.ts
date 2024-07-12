import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {
  username: string = '';
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService) { }

  register(): void {
    this.authService.register({ username: this.username, email: this.email, password: this.password }).subscribe(response => {
      console.log('User registered successfully', response);
    });
  }

  login(): void {
    this.authService.login({ email: this.email, password: this.password }).subscribe(response => {
      localStorage.setItem('token', response.token);
      console.log('User logged in successfully');
    });
  }
}