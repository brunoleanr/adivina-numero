import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-mensaje-error',
  templateUrl: './mensaje-error.component.html',
  styleUrls: ['./mensaje-error.component.css']
})
export class MensajeErrorComponent implements OnInit {

  @Input() errorMessage: string;

  constructor() { }

  ngOnInit() {
  }

  removeAlert() {
    this.errorMessage = null;
  }


}
