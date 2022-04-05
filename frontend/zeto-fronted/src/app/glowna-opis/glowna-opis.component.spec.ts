import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GlownaOpisComponent } from './glowna-opis.component';

describe('GlownaOpisComponent', () => {
  let component: GlownaOpisComponent;
  let fixture: ComponentFixture<GlownaOpisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GlownaOpisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GlownaOpisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
