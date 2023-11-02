import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { UpdateCarPageRoutingModule } from './update-car-routing.module';

import { UpdateCarPage } from './update-car.page';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    HttpClientModule,
    UpdateCarPageRoutingModule
  ],
  declarations: [UpdateCarPage]
})
export class UpdateCarPageModule {}
