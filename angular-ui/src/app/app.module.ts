import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { APP_BASE_HREF } from '@angular/common';
import { environment } from '../environments/environment';
import { AppComponent } from './app.component';
import { InicioModule } from './modules/aplicacion/inicio/inicio.module';
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    InicioModule
  ],
  providers: [
    { provide: 'urlServicioBackend', useValue: environment.urlServicioBackend },
    { provide: APP_BASE_HREF, useValue: '/' },
  ],
  bootstrap: [
    AppComponent,
  ],
})
export class AppModule { }
