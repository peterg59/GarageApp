import { Component } from '@angular/core';

import { GarageService } from './garage.service';

import { OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  providers: [ GarageService ]
})
export class AppComponent implements OnInit{
  title = 'garage-app';
  cars: any[];

  constructor(private garageService: GarageService) {
    this.cars = []
  }

  ngOnInit(): void {
    console.log('On init ...')
    this.garageService.getCars().subscribe((datas) => {
      this.cars = datas;
    })
  }
}
