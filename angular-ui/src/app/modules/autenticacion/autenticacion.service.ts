import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

import { environment } from '../../../environments/environment';

@Injectable()
export class AutenticacionService {

  constructor(private keycloakService: KeycloakService, private router: Router) {}

  cerrarSesion() {
    if (environment.metodoAutenticacion === 'keycloak') {
      this.keycloakService.logout(environment.urlBaseApp);
    } else if (environment.metodoAutenticacion === 'service') {
      this.router.navigate(['/inicio']);
    } else {
       throw new Error('No se reconoce el método de autenticación ' + environment.metodoAutenticacion);
    }
  }
}
