import { Component, OnInit } from '@angular/core';

import { AutenticacionService } from '../../autenticacion/autenticacion.service';

@Component({
  selector: 'app-usuario-no-autorizado',
  templateUrl: './usuario-no-autorizado.component.html',
  styleUrls: ['./usuario-no-autorizado.component.css']
})
export class UsuarioNoAutorizadoComponent implements OnInit {

  constructor(private autenticacionService: AutenticacionService) { }

  ngOnInit() {
  }

  cerrarSesion() {
    this.autenticacionService.cerrarSesion();
  }

}
