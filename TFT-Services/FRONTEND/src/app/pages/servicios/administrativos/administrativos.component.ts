import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-administrativos',
  standalone: true,
  imports: [RouterModule,CommonModule,FormsModule],
  templateUrl: './administrativos.component.html',
  styleUrl: './administrativos.component.css'
})
export class AdministrativosComponent {

}