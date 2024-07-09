import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  formData = {
    username: '',
    email: '',
    password: ''
  };

  constructor(private authService: AuthService) { }

  register() {
    this.authService.register(this.formData).subscribe(
      response => {
        console.log('User registered:', response);
        // Redirigir al usuario o mostrar un mensaje de éxito
      },
      error => {
        console.error('Error registering user:', error);
        // Mostrar mensaje de error
      }
    );
  }
}
