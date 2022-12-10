import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RutasGenericasRoutingModule } from './rutas-genericas-routing.module';
import { AutenticacionModule } from '../autenticacion/autenticacion.module';

import { PaginaNoEncontradaComponent } from './pagina-no-encontrada/pagina-no-encontrada.component';
import { UsuarioNoAutorizadoComponent } from './usuario-no-autorizado/usuario-no-autorizado.component';

@NgModule({
  imports: [
    CommonModule,
    AutenticacionModule,
    RutasGenericasRoutingModule,
  ],
  declarations: [
    PaginaNoEncontradaComponent,
    UsuarioNoAutorizadoComponent,
  ]
})
export class RutasGenericasModule { }
