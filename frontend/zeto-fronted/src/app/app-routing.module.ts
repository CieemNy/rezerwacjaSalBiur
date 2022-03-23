import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GlownaComponent } from './glowna/glowna.component';
import { KontaktComponent } from './kontakt/kontakt.component';
import { LogowanieComponent } from './logowanie/logowanie.component';
import { RegulaminComponent } from './regulamin/regulamin.component';
import { RejestracjaComponent } from './rejestracja/rejestracja.component';

const routes: Routes = [
  {
    path: '',
    component: GlownaComponent
  },
  {
    path: 'logowanie',
    component: LogowanieComponent
  },
  {
    path: 'rejestracja',
    component: RejestracjaComponent
  },
  {
    path: 'kontakt',
    component: KontaktComponent
  },
  {
    path: 'regulamin',
    component: RegulaminComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
