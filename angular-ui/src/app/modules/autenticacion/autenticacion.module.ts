import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

import { KeycloakModule } from '../keycloak/keycloak.module';
import { AutenticacionGuard } from './autenticacion.guard';
import { getAutenticacionGuard } from './autenticacion-guard-factory';
import { AutenticacionService } from './autenticacion.service';

@NgModule({
  imports: [
    CommonModule,
    KeycloakModule,
  ],
  declarations: [],
  providers: [
    AutenticacionService,
    {
      provide: AutenticacionGuard,
      useFactory: getAutenticacionGuard,
      deps: [Router, KeycloakService],
    },
  ],
})
export class AutenticacionModule { }
