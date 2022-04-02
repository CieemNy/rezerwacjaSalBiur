import { TestBed } from '@angular/core/testing';

import { UzytkownikService } from './uzytkownik.service';

describe('UzytkownikService', () => {
  let service: UzytkownikService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UzytkownikService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
