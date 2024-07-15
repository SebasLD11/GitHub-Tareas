import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fisico-deportivos',
  standalone: true,
  imports: [CommonModule,RouterModule,FormsModule],
  templateUrl: './fisico-deport.component.html',
  styleUrl: './fisico-deport.component.css'
})
export class FisicoDeportivosComponent {

}