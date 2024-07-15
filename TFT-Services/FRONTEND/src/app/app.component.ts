import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { ServiciosComponent } from './pages/servicios/servicios.component';
import { TerapeuticosComponent } from './pages/servicios/terapeuticos/terapeuticos.component';
import { AdministrativosComponent } from './pages/servicios/administrativos/administrativos.component';
import { DigitalesComponent } from './pages/servicios/digitales/digitales.component';
import { FisicoDeportivosComponent } from './pages/servicios/fisico-deport/fisico-deport.component';
import { EducativosSocioculturalesComponent } from './pages/servicios/socio-cult/socio-cult.component';
import { ColaboradoresComponent } from './pages/colaboradores/colaboradores.component';
import { SobreNosotrosComponent } from './pages/sobre-nosotros/sobre-nosotros.component';
import { LoginComponent } from './login/login.component';
import { ProductosComponent } from './pages/productos/productos.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    ServiciosComponent,
        TerapeuticosComponent,
        AdministrativosComponent,
        DigitalesComponent,
      FisicoDeportivosComponent,
    EducativosSocioculturalesComponent,
    ColaboradoresComponent,
  SobreNosotrosComponent,
  LoginComponent,
ProductosComponent],

  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'tft-services';
}