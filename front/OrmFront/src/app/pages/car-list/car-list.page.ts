import { Component, OnInit } from '@angular/core';
import { Form } from '@angular/forms';
import { Router } from '@angular/router';
import { carService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.page.html',
  styleUrls: ['./car-list.page.scss'],
})
export class CarListPage implements OnInit {

  cars: any = []

  constructor(private router: Router, private carService: carService) { }

  ngOnInit() {
    this.getAllCars();
  }

  getAllCars() {
    this.carService.getCars().subscribe(response => {
      this.cars = response;
    });
  }

  postCar(marca:string, modelo:string, anoFabricacion: string, placa:string){

    let car = {
      marca:marca,
      modelo:modelo,
      anoFabricacion:anoFabricacion,
      placa:placa
    }

    this.carService.addCar(car).subscribe(response =>{
      this.cars=response
      this.getAllCars()
    })
  }

  insertCar() {
    this.router.navigateByUrl("/car-add");
  }

  deleteCar(id: number) {
    this.carService.deleteCar(id).subscribe(() => {
      this.getAllCars();
    })
  }

  updateCar(id: number) {
    this.carService.currentCarId = id;
    this.router.navigate(["/update-car", id]);
  }

  gotoHome() {
    this.router.navigateByUrl("/")
  }

}
