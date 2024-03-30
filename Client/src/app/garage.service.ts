import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GarageService {

  readonly API_URL = "http://localhost:8080"

  readonly ENDPOINT_CARS = "/cars"

  constructor(private httpClient: HttpClient) {

   }

   getCars() {
      return this.httpClient.get<any[]>(this.API_URL+this.ENDPOINT_CARS)
   }

   addCar(carData: any): Observable<any> {
    return this.httpClient.post(this.API_URL + this.ENDPOINT_CARS, carData);
  }
}
