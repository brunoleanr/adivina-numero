import { Component, OnInit } from '@angular/core';

import { AutenticacionService } from '../../autenticacion/autenticacion.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  constructor(private autenticacionService: AutenticacionService) { }

  ngOnInit() {
  }

  cerrarSesion() {
    this.autenticacionService.cerrarSesion();
  }

}
