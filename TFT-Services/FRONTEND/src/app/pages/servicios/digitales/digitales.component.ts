import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-digitales',
  standalone: true,
  imports: [CommonModule,RouterModule,FormsModule],
  templateUrl: './digitales.component.html',
  styleUrl: './digitales.component.css'
})
export class DigitalesComponent {

}