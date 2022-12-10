import { Component, OnInit } from '@angular/core';

import { AutenticacionService } from '../../autenticacion/autenticacion.service';

@Component({
  selector: 'app-opcion-secure',
  templateUrl: './opcion-secure.component.html',
  styleUrls: ['./opcion-secure.component.css']
})
export class OpcionSecureComponent implements OnInit {

  constructor(private autenticacionService: AutenticacionService) { }

  ngOnInit() {
  }

  cerrarSesion() {
    this.autenticacionService.cerrarSesion();
  }

}
