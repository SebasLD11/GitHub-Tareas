import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../services/servicios.service';

@Component({
  selector: 'app-servicios',
  standalone: true,
  imports: [],
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css']
})
export class ServicesComponent implements OnInit {
  services: any[] = [];

  constructor(private serviceService: ServiceService) { }

  ngOnInit(): void {
    this.loadServices();
  }

 
  loadServices(): void {
    this.serviceService.getServices().subscribe(services => this.services = services);
  }
}