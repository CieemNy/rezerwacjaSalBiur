import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogowanieComponent } from './logowanie/logowanie.component';
import { RejestracjaComponent } from './rejestracja/rejestracja.component';

const routes: Routes = [
  {
    path: 'logowanie',
    component: LogowanieComponent
  },
  {
    path: 'rejestracja',
    component: RejestracjaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
