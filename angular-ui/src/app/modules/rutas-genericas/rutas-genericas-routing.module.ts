import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PaginaNoEncontradaComponent } from '../rutas-genericas/pagina-no-encontrada/pagina-no-encontrada.component';
import { UsuarioNoAutorizadoComponent } from './usuario-no-autorizado/usuario-no-autorizado.component';
import { AutenticacionGuard } from '../autenticacion/autenticacion.guard';

const rutasGenericas: Routes = [
  { path: 'usuario-no-autorizado', component: UsuarioNoAutorizadoComponent, canActivate: [AutenticacionGuard] },
  /*{ path: 'ingreso-incorrecto', component: IngresoIncorrectoComponent },

  { path: 'servicio-no-disponible', component: ServicioNoDisponibleComponent },*/
  { path: '', pathMatch: 'full', redirectTo: 'inicio' },
  { path: '**', component: PaginaNoEncontradaComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(rutasGenericas) ],
  exports: [ RouterModule ]
})
export class RutasGenericasRoutingModule { }
