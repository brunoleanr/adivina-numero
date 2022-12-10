import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OpcionSecureComponent } from './opcion-secure.component';
import { AutenticacionGuard } from '../../autenticacion/autenticacion.guard';

const rutasOpcionSecure: Routes = [
  { path: 'opcion-secure', component: OpcionSecureComponent, canActivate: [AutenticacionGuard] },
];

@NgModule({
  imports: [ RouterModule.forRoot(rutasOpcionSecure) ],
  exports: [ RouterModule ]
})
export class OpcionSecureRoutingModule { }
