import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { carService } from 'src/app/services/car.service';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.page.html',
  styleUrls: ['./update-car.page.scss'],
})
export class UpdateCarPage {
  id: String | null= "0";
  carForm: FormGroup;
  car: any = {};

  constructor(private router: Router, private CarService: carService, public formBuilder: FormBuilder, private activatedRoute: ActivatedRoute) {
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


  ionViewWillEnter() {
    this.id = this.activatedRoute.snapshot.paramMap.get('id')
    this.CarService.getOne(this.id).subscribe((data:any) =>{
      this.car = data
      console.log(data)
      this.carForm.controls["marca"].setValue(data.marca)
      this.carForm.controls["modelo"].setValue(data.modelo)
      this.carForm.controls["anoFabricacion"].setValue(data.anoFabricacion)
      this.carForm.controls["placa"].setValue(data.placa)
    })
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

      const id = this.CarService.currentCarId;

      let car = {
        marca: marca,
        modelo: modelo,
        anoFabricacion: anoFabricacion,
        placa: placa
      }

      this.CarService.updateCars(id, car).subscribe(() => {
        this.router.navigateByUrl("/car-list");
      });
    }
  }

  gotoHome() {
    this.router.navigateByUrl("/")
  }

}