import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'car-list',
    loadChildren: () => import('./pages/car-list/car-list.module').then( m => m.CarListPageModule)
  },
  {
    path: 'car-add',
    loadChildren: () => import('./pages/car-add/car-add.module').then( m => m.CarAddPageModule)
  },
  {
    path: 'update-car/:id',
    loadChildren: () => import('./pages/update-car/update-car.module').then( m => m.UpdateCarPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
