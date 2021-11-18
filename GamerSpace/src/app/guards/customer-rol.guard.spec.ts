import { TestBed } from '@angular/core/testing';

import { CustomerRolGuard } from './customer-rol.guard';

describe('CustomerRolGuard', () => {
  let guard: CustomerRolGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CustomerRolGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
