import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { carService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.page.html',
  styleUrls: ['./car-add.page.scss'],
})
export class CarAddPage{

  carForm: FormGroup;

  constructor(private router: Router, private CarService: carService, public formBuilder: FormBuilder) {
    this.carForm = this.formBuilder.group({
      marca: ['', [Validators.required, Validators.minLength(3)]],
      modelo: ['', [Validators.required, Validators.minLength(3)]],
      anoFabricacion: [
        '',
        [
          Validators.required,
          Validators.pattern(/^[0-9]{4}$/), // Requires a 4-digit year
          Validators.min(1900), // Minimum year allowed
          Validators.max(new Date().getFullYear()), // Maximum year allowed
        ],
      ],
      placa: ['', [Validators.required, Validators.minLength(3)]]
    })
  }


  ngOninit() {
  }

  get errorControl() {
    return this.carForm.controls;
  }

  submitForm() {
    if (this.carForm.valid) {
      const marca = this.carForm.value.marca;
      const modelo = this.carForm.value.modelo;
      const anoFabricacion = this.carForm.value.anoFabricacion;
      const placa = this.carForm.value.placa;

      let car = [
        marca,
        modelo,
        anoFabricacion,
        placa
      ]

      this.CarService.addCar(car).subscribe(() => {
        this.router.navigateByUrl("/car-list");
      });
    }
  }

  gotoHome() {
    this.router.navigateByUrl("/")
  }

}
