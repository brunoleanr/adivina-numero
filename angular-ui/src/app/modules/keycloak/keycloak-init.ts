import { KeycloakService } from 'keycloak-angular';
import { environment } from '../../../environments/environment';

export function keycloakInit(keycloakService: KeycloakService): () => Promise<any> {
  if (environment.metodoAutenticacion === 'keycloak') {
    return (): Promise<any> => {
      return new Promise(async (resolve, reject) => {
        try {
          await keycloakService.init({
            config: environment.urlServicioBackend + environment.urlConfiguracionKeycloak,
            initOptions: {
              checkLoginIframe: false // TODO: cambiar a true
            },
            enableBearerInterceptor: true,
            bearerExcludedUrls: [
              '/assets'
            ],
          });
          resolve();
        } catch (error) {
          reject(error);
        }
      });
    };
  } else {
    return (): Promise<any> => {
      return new Promise((resolve) => { resolve(); });
    };
  }
}
