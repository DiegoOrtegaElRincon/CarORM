import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { CarAddPageRoutingModule } from './car-add-routing.module';

import { CarAddPage } from './car-add.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    HttpClientModule,
    CarAddPageRoutingModule
  ],
  declarations: [CarAddPage]
})
export class CarAddPageModule {}
