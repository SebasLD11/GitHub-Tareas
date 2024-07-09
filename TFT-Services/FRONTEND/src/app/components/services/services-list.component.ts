import { Component, OnInit } from '@angular/core';
import { ServiceService } from './service.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  services: any[] = [];

  constructor(private serviceService: ServiceService) { }

  ngOnInit(): void {
    this.serviceService.getServices().subscribe((data: any[]) => {
      this.services = data;
    });
  }
}
