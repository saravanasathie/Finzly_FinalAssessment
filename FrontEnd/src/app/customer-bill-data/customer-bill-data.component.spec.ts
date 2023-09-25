import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerBillDataComponent } from './customer-bill-data.component';

describe('CustomerBillDataComponent', () => {
  let component: CustomerBillDataComponent;
  let fixture: ComponentFixture<CustomerBillDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerBillDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerBillDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
