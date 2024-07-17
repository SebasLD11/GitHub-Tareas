import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AuthComponent } from './auth/auth.component';
import { ProfileComponent } from './pages/profile/profile.component'; 
import { SobreNosotrosComponent } from './pages/sobre-nosotros/sobre-nosotros.component';
import { ServiciosComponent } from './pages/servicios/servicios.component';
import { DigitalesComponent } from './pages/servicios/digitales/digitales.component';
import { FisicoDeportComponent } from './pages/servicios/fisico-deport/fisico-deport.component';
import { SocioculturalesComponent } from './pages/servicios/socio-cult/socio-cult.component';
import { TerapeuticosComponent } from './pages/servicios/terapeuticos/terapeuticos.component';
import { AdministrativosComponent } from './pages/servicios/administrativos/administrativos.component';
import { BookingComponent } from './pages/booking/booking.component'
import { ProductosComponent } from './pages/productos/productos.component';
import { ColaboradoresComponent } from './pages/colaboradores/colaboradores.component';
import { ComunidadComponent } from './pages/comunidad/comunidad.component'; 


 


export const routes: Routes = [
    {path: 'servicios', component: ServiciosComponent },
    {path: 'administrativos', component: AdministrativosComponent },
    {path: 'digitales', component: DigitalesComponent }, 
    {path: 'fisicodeport', component: FisicoDeportComponent }, 
    {path: 'socioculurales', component: SocioculturalesComponent },
    {path: 'terapeuticos', component: TerapeuticosComponent },
    {path: 'sobre-nosotros', component: SobreNosotrosComponent },
    {path: 'auth', component: AuthComponent },
    {path: 'colaboradores', component: ColaboradoresComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'login', component: LoginComponent },
    {path: 'register', component: RegisterComponent },
    {path: 'admin', component: AdminComponent },
    {path: 'booking', component: BookingComponent },
    {path: 'productos', component: ProductosComponent},
    {path: 'comunidad', component: ComunidadComponent},
    // {path: 'header', component: HeaderComponent},
    {path: '', component: HomeComponent},
    // {path: 'footer', component: FooterComponent},
    {path: 'login', component: LoginComponent},
    {path: 'home', redirectTo: '' , pathMatch: 'full'},

    { path: '**', redirectTo: '' },
];
