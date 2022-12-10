import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DialogoConfirmacionComponent } from './dialogo-confirmacion/dialogo-confirmacion.component';
import { MensajeErrorComponent } from './mensaje-error/mensaje-error.component';
import { DialogoAvisoComponent } from './dialogo-aviso/dialogo-aviso.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    MensajeErrorComponent
  ],
  entryComponents: [
    DialogoConfirmacionComponent,
    DialogoAvisoComponent
  ]  ,
  declarations: [
    DialogoConfirmacionComponent,
    MensajeErrorComponent,
    DialogoAvisoComponent
  ]
})
export class ComponentesComunesModule { }
