import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service'; // Corrected path to services/user.service

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userProfile: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserProfile().subscribe(profile => {
      this.userProfile = profile;
    });
  }
}
