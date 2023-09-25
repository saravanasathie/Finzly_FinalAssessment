import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCustomerCSVComponent } from './add-customer-csv.component';

describe('AddCustomerCSVComponent', () => {
  let component: AddCustomerCSVComponent;
  let fixture: ComponentFixture<AddCustomerCSVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCustomerCSVComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCustomerCSVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
