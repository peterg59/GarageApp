import { Component } from '@angular/core';

import { GarageService } from './garage.service';

import { OnInit } from '@angular/core';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  providers: [ GarageService, CustomerService ]
})
export class AppComponent implements OnInit{
  title = 'garage-app';
  cars: any[];
  customers: any[];
  carData: any;
  years: number[];

  constructor(private garageService: GarageService, private customerService: CustomerService) {
    this.cars = []
    this.customers = []
    this.years = []
    this.carData = { brand: '', model: '', year: null, color: '' };
    this.populateYears();
  }

  ngOnInit(): void {
    console.log('On init ...')
    this.garageService.getCars().subscribe((datas) => {
      this.cars = datas;
    })
    this.customerService.getCustomers().subscribe((datas) => {
      this.customers = datas;
    })
  }

  populateYears(): void {
    const currentYear = new Date().getFullYear();
    for (let i = currentYear; i >= 1900; i--) {
      this.years.push(i);
    }
  }

  addCar(): void {
    this.garageService.addCar(this.carData).subscribe(
      response => {
        console.log('Voiture ajoutée avec succès:', response);
        this.carData = { brand: '', model: '', year: null, color: '' };
      },
      error => {
        console.error('Erreur lors de l\'ajout de la voiture:', error);
      }
    );
  }
}
