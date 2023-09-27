import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaidbillsComponent } from './paidbills.component';

describe('PaidbillsComponent', () => {
  let component: PaidbillsComponent;
  let fixture: ComponentFixture<PaidbillsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaidbillsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaidbillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
