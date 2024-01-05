import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })
export class CustomerService {

    readonly API_URL = "http://localhost:8080"

    readonly ENDPOINT_CUSTOMERS = "/customers"

    constructor(private httpClient: HttpClient) {

    }

    getCustomers() {
        return this.httpClient.get<any[]>(this.API_URL+this.ENDPOINT_CUSTOMERS)
    }
} 