import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:5000/api/users';

  constructor(private http: HttpClient) { }

  getUserProfile(): Observable<any> {
    return this.http.get(`${this.apiUrl}/me`);
  }

  updateUserProfile(profile: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/profile`, profile);
  }
}
