import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OpcionSecureComponent } from './opcion-secure.component';
import { OpcionSecureRoutingModule } from './opcion-secure-routing.module';

@NgModule({
  imports: [
    CommonModule,
    OpcionSecureRoutingModule,
  ],
  declarations: [OpcionSecureComponent]
})
export class OpcionSecureModule { }
