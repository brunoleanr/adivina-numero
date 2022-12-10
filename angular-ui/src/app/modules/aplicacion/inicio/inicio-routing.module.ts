import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './inicio.component';

const rutasInicio: Routes = [
  { path: 'inicio', component: InicioComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(rutasInicio) ],
  exports: [ RouterModule ]
})
export class InicioRoutingModule { }
