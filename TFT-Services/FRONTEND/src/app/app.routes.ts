import { Routes } from '@angular/router';
import { ServicesComponent } from './pages/servicios/servicios.component';
import { HomeComponent } from './home/home.component';
import { SobreNosotrosComponent } from './pages/sobre-nosotros/sobre-nosotros.component';
import { ColaboradoresComponent } from './pages/colaboradores/colaboradores.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { AuthComponent } from './auth/auth.component';
import { ProfileComponent } from './pages/profile/profile.component';  
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { BookingComponent } from './pages/booking/booking.component'

export const routes: Routes = [
    {path: 'services', component: ServicesComponent },
    {path: 'home', component: HomeComponent },
    {path: 'sobre-nosotros', component: SobreNosotrosComponent },
    {path: 'productos', component: ProductosComponent},
    {path: 'auth', component: AuthComponent },
    {path: 'colaboradores', component: ColaboradoresComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'login', component: LoginComponent },
    {path: 'register', component: RegisterComponent },
    {path: 'admin', component: AdminComponent },
    {path: 'booking', component: BookingComponent }
];

