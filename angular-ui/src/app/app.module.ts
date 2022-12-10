import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import { RouterModule } from '@angular/router';
import { APP_BASE_HREF } from '@angular/common';
import { CoreModule } from './modules/core/core.module';
import { URL_DATOS_LOCALES } from './modules/core/constantes';
import { environment } from '../environments/environment';
import { AppComponent } from './app.component';
import { RutasGenericasModule } from './modules/rutas-genericas/rutas-genericas.module';
import { InicioModule } from './modules/aplicacion/inicio/inicio.module';
import { OpcionSecureModule } from './modules/aplicacion/opcion-secure/opcion-secure.module';
import { KeycloakModule } from './modules/keycloak/keycloak.module';
import { HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CoreModule,
    RouterModule,
    KeycloakModule,
    InicioModule,
    OpcionSecureModule,
    RutasGenericasModule, // Va siempre al final, porque tiene la ruta **.
  ],
  providers: [
    { provide: 'urlConfiguracionKeycloak', useValue: environment.urlServicioBackend + environment.urlConfiguracionKeycloak },
    { provide: 'urlDatosLocales', useValue: URL_DATOS_LOCALES },
    { provide: 'urlServicioBackend', useValue: environment.urlServicioBackend },
    { provide: 'usarDatosLocales', useValue: environment.usarDatosLocales },
	{ provide: APP_BASE_HREF, useValue: '/'},
  ],
  bootstrap: [
    AppComponent,
  ],
})
export class AppModule { }
