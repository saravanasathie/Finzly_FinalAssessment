import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCustomerManualComponent } from './add-customer-manual.component';

describe('AddCustomerManualComponent', () => {
  let component: AddCustomerManualComponent;
  let fixture: ComponentFixture<AddCustomerManualComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCustomerManualComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCustomerManualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
