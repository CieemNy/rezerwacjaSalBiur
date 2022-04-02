import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UzytkownikService } from '../service/uzytkownik.service';

@Component({
  selector: 'app-rejestracja',
  templateUrl: './rejestracja.component.html',
  styleUrls: ['./rejestracja.component.css']
})
export class RejestracjaComponent implements OnInit {

  rejestracja = new FormGroup({
    login: new FormControl('', Validators.required),
    imie: new FormControl('', Validators.required),
    nazwisko: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    haslo: new FormControl('', Validators.required),
    telefon: new FormControl('', Validators.required)
  });

  constructor(private uzytkownikService:UzytkownikService) { }

  public uzytkownik={
    login:'',
    imie:'',
    nazwisko:'',
    email:'',
    haslo:'',
    telefon:''
  }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.uzytkownik);
    if(this.uzytkownik.imie=='' || this.uzytkownik.imie==null){
      alert('imie wymahene');
      return;
    }
    //dodajUzytkownik: userservice
    this.uzytkownikService.dodajUzytkownik(this.uzytkownik).subscribe(
      (data)=>{
        //wszystko git
        console.log(data);
        alert("sukces!");
      },
      (error)=>{
        // oj coś nie git :0
        console.log(error);
        alert("porażka!");
      }
    )

  }



}
