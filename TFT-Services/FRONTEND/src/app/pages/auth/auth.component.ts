import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {
  isLoginMode = true;
  username: string = '';
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit() {
    if (this.isLoginMode) {
      this.authService.login({ email: this.email, password: this.password }).subscribe(response => {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/']);
      });
    } else {
      this.authService.register({ username: this.username, email: this.email, password: this.password }).subscribe(response => {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/']);
      });
    }
  }
}
