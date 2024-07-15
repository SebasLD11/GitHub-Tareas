import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AuthComponent } from './auth/auth.component';
import { ProfileComponent } from './pages/profile/profile.component'; 
import { SobreNosotrosComponent } from './pages/sobre-nosotros/sobre-nosotros.component';
import { ServicesComponent } from './pages/servicios/servicios.component';
import { BookingComponent } from './pages/booking/booking.component'
import { ProductosComponent } from './pages/productos/productos.component';
import { ColaboradoresComponent } from './pages/colaboradores/colaboradores.component';
import { ComunidadComponent } from './pages/comunidad/comunidad.component'; 
 


export const routes: Routes = [
    {path: 'services', component: ServicesComponent },  
    {path: 'sobre-nosotros', component: SobreNosotrosComponent },
    {path: 'auth', component: AuthComponent },
    {path: 'colaboradores', component: ColaboradoresComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'login', component: LoginComponent },
    {path: 'register', component: RegisterComponent },
    {path: 'admin', component: AdminComponent },
    {path: 'booking', component: BookingComponent },
    {path: 'productos', component: ProductosComponent},
    // {path: 'header', component: HeaderComponent},
    {path: '', component: HomeComponent},
    // {path: 'footer', component: FooterComponent},  
    {path: 'home', redirectTo: '' , pathMatch: 'full'},
    { path: '**', redirectTo: '' },  
    {path: 'comunidad', component: ComunidadComponent},
];
