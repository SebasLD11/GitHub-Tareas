import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  credentials = {
    email: '',
    password: ''
  };

  constructor(private authService: AuthService) { }

  login() {
    this.authService.login(this.credentials).subscribe(
      response => {
        console.log('User logged in:', response);
        // Guardar el token en localStorage o en el estado de la aplicación
        // Redirigir al usuario o mostrar un mensaje de éxito
      },
      error => {
        console.error('Error logging in:', error);
        // Mostrar mensaje de error
      }
    );
  }
}
