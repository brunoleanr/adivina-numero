import { NgModule, APP_INITIALIZER } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';

import { KeycloakGuard } from './keycloak.guard';
import { keycloakInit } from './keycloak-init';

import { environment } from '../../../environments/environment';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    KeycloakAngularModule,
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: keycloakInit,
      multi: true,
      deps: [KeycloakService],
    },
    {
      provide: KeycloakGuard,
      useClass: KeycloakGuard,
      deps: [KeycloakService, Router],
    },
  ],
  declarations: []
})
export class KeycloakModule { }
