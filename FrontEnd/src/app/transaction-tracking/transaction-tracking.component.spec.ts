import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionTrackingComponent } from './transaction-tracking.component';

describe('TransactionTrackingComponent', () => {
  let component: TransactionTrackingComponent;
  let fixture: ComponentFixture<TransactionTrackingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionTrackingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionTrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
