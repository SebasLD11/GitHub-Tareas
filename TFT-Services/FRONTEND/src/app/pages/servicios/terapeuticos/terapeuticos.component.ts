import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-terapeuticos',
  standalone: true,
  imports: [CommonModule,RouterModule,FormsModule],
  templateUrl: './terapeuticos.component.html',
  styleUrl: './terapeuticos.component.css'
})
export class TerapeuticosComponent {

}