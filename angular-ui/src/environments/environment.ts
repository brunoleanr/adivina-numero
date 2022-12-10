// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,

  // Método de autenticación:
  // 'keycloak': Autenticación con Keycloak (valor para producción)
  // 'service': Autenticación con el usuario configurado en el service. (valor sólo para desarrollo)
  metodoAutenticacion: 'keycloak',

  // URL del archivo JSON de configuración de Keycloak (se usa sólo con datos locales).
  urlConfiguracionKeycloak: 'public/keycloak.json',

  // URL base de la app.
  urlBaseApp: window.location.protocol + '//' + window.location.host,

    // BACKEND ----------------------------------------------------------

  // URL del servicio de backend.
  // urlServicioBackend: 'http://192.168.0.235:8380/iurix-plazos-services/api/',
  urlServicioBackend:'http://localhost:8080/',

  // Usar datos locales en JSON (true) o consultar servicios (false) (siempre false en producción).
  // Si no se usan datos locales, hace que se lean las demás properties desde el servicio remoto.
  // No se puede leer remotamente, porque justamente define si usar el servicio remoto o no.
  usarDatosLocales: false,
};

/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
