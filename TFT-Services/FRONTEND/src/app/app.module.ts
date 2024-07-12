import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserService } from './services/user.service';
import { AuthService } from './services/auth.service';
import { routes } from './app.routes';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { AuthComponent } from './auth/auth.component';  // Verifica esta ruta
import { ServicesComponent } from './services/services.component';
import { ProfileComponent } from './pages/profile/profile.component';  // Verifica esta ruta
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    AuthComponent,
    ServicesComponent,
    ProfileComponent,
    LoginComponent,
    RegisterComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClient,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [AuthService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
export { routes };
