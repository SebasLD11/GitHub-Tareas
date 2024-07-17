import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  imports: [RouterLink]  // Importando los módulos necesarios
})
export class RegisterComponent {
  username: string = '';
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  register(): void {
    this.authService.register({ username: this.username, email: this.email, password: this.password }).subscribe(response => {
      localStorage.setItem('token', response.token);
      this.router.navigate(['/']);
    });
  }
}
