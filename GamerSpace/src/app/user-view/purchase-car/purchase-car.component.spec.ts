import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseCarComponent } from './purchase-car.component';

describe('PurchaseCarComponent', () => {
  let component: PurchaseCarComponent;
  let fixture: ComponentFixture<PurchaseCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PurchaseCarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
