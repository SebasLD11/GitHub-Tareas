import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private apiUrl = 'http://localhost:5000/api/admin'; // Asegúrate de que esta URL apunte a tu backend

  constructor(private http: HttpClient) { }

  // Métodos de usuario
  registerAdmin(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register-admin`, user);
  }

  getUsers(): Observable<any> {
    return this.http.get(`${this.apiUrl}/users`);
  }

  updateUser(id: string, user: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/users/${id}`, user);
  }

  deleteUser(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/users/${id}`);
  }

  // Métodos de servicio
  createService(service: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/services`, service);
  }

  getServices(): Observable<any> {
    return this.http.get(`${this.apiUrl}/services`);
  }

  updateService(id: string, service: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/services/${id}`, service);
  }

  deleteService(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/services/${id}`);
  }

  // Métodos de reserva
  getBookings(): Observable<any> {
    return this.http.get(`${this.apiUrl}/bookings`);
  }
  
  getBookingDetails(bookingId: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${bookingId}`);
  }


  createBooking(booking: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/bookings`, booking);
  }

  updateBooking(id: string, booking: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/bookings/${id}`, booking);
  }

  deleteBooking(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/bookings/${id}`);
  }
}
