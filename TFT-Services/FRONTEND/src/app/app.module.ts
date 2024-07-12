import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { routes} from './app.routes';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { AuthService } from './services/auth.service';
import { ServicesComponent } from './services/services.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { UserService } from './services/user.service';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    AuthComponent,
    ServicesComponent
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    routes,
    HttpClient,
    FormsModule,
    RouterModule
  ],
  providers: [AuthService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
export { routes };

