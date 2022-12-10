import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InicioComponent } from './inicio/inicio.component';
import { EncabezadoComponent } from './encabezado/encabezado.component';
import { PieComponent } from './pie/pie.component';
import { CuerpoComponent } from './inicio/cuerpo/cuerpo.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { SeccionesComponent } from './inicio/cuerpo/secciones/secciones.component';
import { MenuLateralComponent } from './menu-lateral/menu-lateral.component';
import { MenuUsuarioComponent } from './menu-usuario/menu-usuario.component';

@NgModule({
  imports: [
    CommonModule,
  ],
  declarations: [
    BuscadorComponent,
    CuerpoComponent,
    EncabezadoComponent,
    InicioComponent,
    PieComponent,
    MenuLateralComponent,
    MenuUsuarioComponent,
    SeccionesComponent,
  ],
  exports: [
    BuscadorComponent,
    EncabezadoComponent,
    InicioComponent,
    MenuLateralComponent,
    MenuUsuarioComponent,
    PieComponent,
  ],
})
export class CoreModule { }
