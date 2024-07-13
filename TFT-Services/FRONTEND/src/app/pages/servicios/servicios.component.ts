import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../services/servicios.service';

@Component({
  selector: 'app-service',
  standalone: true,
  imports: [],
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  services: any[] = [];

  constructor(private serviceService: ServiceService) { }

  ngOnInit(): void {
    this.getServices();
  }

  getServices(): void {
    this.serviceService.getServices().subscribe(
      (data: any[]) => {
        this.services = data;
      },
      (error: any) => {
        console.error('Error fetching services', error);
      }
    );
  }
}
