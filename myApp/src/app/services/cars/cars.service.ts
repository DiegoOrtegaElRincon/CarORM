import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  })
};

@Injectable({
  providedIn: 'root'
})

export class CarsService {

  currentCarId!: number;

  endpoint = "http://localhost:8080/vehiculo";


  constructor(private httpClient: HttpClient) { }

  setCurrenTCarId(id: number) {
    this.currentCarId = id;
  }

  getCurrentBicycleId(): number {
    return this.currentCarId;
  }

  getCar() {
    return this.httpClient.get(this.endpoint);
  }

  getOne(id: number) {
    return this.httpClient.get(this.endpoint + `/${id}`)
  }

  addCar(bicycle: any) {
    let bodyEncoded = new URLSearchParams();
    bodyEncoded.append("model", bicycle.model);
    bodyEncoded.append("year", bicycle.year);
    let body = bodyEncoded.toString();

    return this.httpClient.post(this.endpoint, body, httpOptions);
  }

  deleteBicycle(id: number) {
    return this.httpClient.delete(this.endpoint + `/${id}`)
  }

  updateCar(id: number, bicycle: any) {
    let bodyEncoded = new URLSearchParams();
    bodyEncoded.append("model", bicycle.model);
    bodyEncoded.append("year", bicycle.year);
    bodyEncoded.append("model", bicycle.model);
    bodyEncoded.append("year", bicycle.year);
    let body = bodyEncoded.toString();

    return this.httpClient.put(this.endpoint + `/${id}`, body, httpOptions);
  }

}
