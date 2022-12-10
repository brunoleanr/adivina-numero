import { Component, OnInit, Input, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-dialogo-aviso',
  templateUrl: './dialogo-aviso.component.html',
  styleUrls: ['./dialogo-aviso.component.css']
})
export class DialogoAvisoComponent implements OnInit {
  public descripcion: string;
  public header: string;

  constructor(public dialogRef: MatDialogRef<DialogoAvisoComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.descripcion = this.data.descripcion;
    this.header = this.data.header;
  }

  aceptar() {
    this.dialogRef.close();
  }

}
