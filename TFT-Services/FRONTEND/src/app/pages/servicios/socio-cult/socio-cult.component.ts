import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-educativos-socioculturales',
  standalone: true,
  imports: [CommonModule,RouterModule,FormsModule],
  templateUrl: './socio-cult.component.html',
  styleUrl: './socio-cult.component.css'
})
export class EducativosSocioculturalesComponent {

}