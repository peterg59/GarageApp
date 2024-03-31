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

  // Déclarez un objet pour stocker les données du formulaire d'ajout d'une voiture
  carData: any;
  years: number[] = [];

  constructor(private garageService: GarageService, private customerService: CustomerService) {
    this.cars = []
    this.customers = []
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

  // Utilisez cette fonction pour ajouter une voiture
  addCar(): void {
    console.log('Debut addCar', this.carData);
    // Utilisez l'objet carData pour passer les données du formulaire à la fonction addCar du service
    this.garageService.addCar(this.carData).subscribe(
      response => {
        console.log('Voiture ajoutée avec succès:', response);
        // Réinitialiser les données du formulaire après l'ajout
        this.carData = { brand: '', model: '', year: null, color: '' };
      },
      error => {
        console.error('Erreur lors de l\'ajout de la voiture:', error);
      }
    );
    console.log('Fin addCar');
  }
}
