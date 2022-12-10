import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

import { KeycloakGuard } from '../keycloak/keycloak.guard';
import { AutenticacionGuard } from './autenticacion.guard';

import { environment } from '../../../environments/environment';

export function getAutenticacionGuard(router: Router, keycloakService: KeycloakService) {
  if (environment.metodoAutenticacion === 'keycloak') {
    return new KeycloakGuard(router, keycloakService);
  } else if (environment.metodoAutenticacion === 'service') {
    return new AutenticacionGuard(router);
  } else {
    throw new Error('No se reconoce el método de autenticación ' + environment.metodoAutenticacion);
  }
}
