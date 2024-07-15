import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UserService } from '../../services/user.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  imports: [FormsModule, CommonModule,RouterModule]
})
export class ProfileComponent {
  user = {
    username: '',
    email: '',
    password: ''
  };

  constructor(private userService: UserService) {
    this.loadUserProfile();
  }

  loadUserProfile(): void {
    this.userService.getProfile().subscribe(
      (data) => this.user = data,
      (error) => console.error('Error fetching profile', error)
    );
  }

  updateProfile(): void {
    this.userService.updateProfile(this.user).subscribe(
      (data) => console.log('Profile updated successfully', data),
      (error) => console.error('Error updating profile', error)
    );
  }
}
