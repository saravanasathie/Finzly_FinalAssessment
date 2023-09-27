import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCustomerCsvComponent } from './add-customer-csv.component';

describe('AddCustomerCsvComponent', () => {
  let component: AddCustomerCsvComponent;
  let fixture: ComponentFixture<AddCustomerCsvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCustomerCsvComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCustomerCsvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
