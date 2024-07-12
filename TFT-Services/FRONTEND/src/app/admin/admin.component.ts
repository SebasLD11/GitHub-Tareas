import { Component } from '@angular/core';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  users: any[] = [];
  services: any[] = [];
  bookings: any[] = [];

  constructor(private adminService: AdminService) {
    this.loadUsers();
    this.loadServices();
    this.loadBookings();
  }

  loadUsers() {
    this.adminService.getUsers().subscribe((users: any[]) => this.users = users);
  }

  loadServices() {
    this.adminService.getServices().subscribe((services: any[]) => this.services = services);
  }

  loadBookings() {
    this.adminService.getBookings().subscribe((bookings: any[]) => this.bookings = bookings);
  }
}