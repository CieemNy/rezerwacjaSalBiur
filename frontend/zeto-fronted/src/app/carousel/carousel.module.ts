import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselComponent } from './carousel.component';
import { BrowserModule } from '@angular/platform-browser';
import { MatIconModule } from "@angular/material/icon";



@NgModule({
  declarations: [
    CarouselComponent
  ],
  imports: [
    CommonModule,
    MatIconModule
  ],
  exports: [
    CarouselComponent
  ]
})
export class CarouselModule { }
