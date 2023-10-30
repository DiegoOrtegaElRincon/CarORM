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


export class carService {

  currentCarId!: number;

  endpoint = "http://localhost:8080/vehiculo";


  constructor(public httpClient: HttpClient) { }

  setCurrentCarId(id: number) {
    this.currentCarId = id;
  }

  getCurrentCarId(): number {
    return this.currentCarId;
  }

  getCars() {
    return this.httpClient.get(this.endpoint);
  }

  getOne(id: number) {
    return this.httpClient.get(this.endpoint + `/${id}`)
  }

  addCar(Car: any) {
    let bodyEncoded = new URLSearchParams();
    bodyEncoded.append("marca", Car.marca);
    bodyEncoded.append("modelo", Car.modelo);
    bodyEncoded.append("anoFabricacion", Car.anoFabricacion);
    bodyEncoded.append("placa", Car.placa);
    let body = bodyEncoded.toString();

    return this.httpClient.post(this.endpoint, body, httpOptions);
  }

  deleteCar(id: number) {
    return this.httpClient.delete(this.endpoint + `/${id}`)
  }

  updateCars(id: number, Car: any) {
    let bodyEncoded = new URLSearchParams();
    bodyEncoded.append("marca", Car.marca);
    bodyEncoded.append("modelo", Car.modelo);
    bodyEncoded.append("anoFabricacion", Car.anoFabricacion);
    bodyEncoded.append("placa", Car.placa);
    let body = bodyEncoded.toString();

    return this.httpClient.put(this.endpoint + `/${id}`, body, httpOptions);
  }

}
