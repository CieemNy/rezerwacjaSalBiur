import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-rejestracja',
  templateUrl: './rejestracja.component.html',
  styleUrls: ['./rejestracja.component.css']
})
export class RejestracjaComponent implements OnInit {

  rejestracja = new FormGroup({
    imie: new FormControl('', Validators.required),
    nazwisko: new FormControl('', Validators.required),
    login: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    haslo: new FormControl('', Validators.required),
    telefon: new FormControl('', Validators.required)
  });

  constructor() { }

  ngOnInit(): void {
  }

}
