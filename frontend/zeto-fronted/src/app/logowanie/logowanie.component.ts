import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-logowanie',
  templateUrl: './logowanie.component.html',
  styleUrls: ['./logowanie.component.css']
})
export class LogowanieComponent implements OnInit {

  logowanie = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    haslo: new FormControl('', Validators.required)
  });

  constructor() { }

  ngOnInit(): void {
  }

}
