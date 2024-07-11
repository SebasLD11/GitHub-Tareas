import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/header/header.component';
import { BodyComponent } from './pages/views/body/body.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { LoginComponent } from './pages/views/auth/login.component';
import { AuthService } from './pages/views/auth/auth.service';
import { ServiceListComponent } from './pages/views/services/service-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BodyComponent,
    FooterComponent,
    LoginComponent,
    ServiceListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClient,
    FormsModule,
    RouterModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
