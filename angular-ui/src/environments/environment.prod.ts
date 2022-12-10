export const environment = {
  production: true,
  // Método de autenticación:
  // 'keycloak': Autenticación con Keycloak.
  // 'service': Autenticación con el usuario configurado en el service.
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
