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

  constructor(private garageService: GarageService, private customerService: CustomerService) {
    this.cars = []
    this.customers = []
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
}
