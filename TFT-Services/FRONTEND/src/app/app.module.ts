import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common'; 

import { AppComponent } from './app.component';

import { AuthService } from './services/auth.service';
import { UserService } from './services/user.service';
import { AdminService } from './services/admin.service';
import { BookingService } from './services/booking.service'

import { routes } from './app.routes';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes),
    CommonModule
  ],
  providers: [ 
    provideHttpClient(withInterceptorsFromDi()),
    AuthService,
    UserService, 
    AdminService,
    BookingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }