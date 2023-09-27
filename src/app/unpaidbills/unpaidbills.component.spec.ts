import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnpaidbillsComponent } from './unpaidbills.component';

describe('UnpaidbillsComponent', () => {
  let component: UnpaidbillsComponent;
  let fixture: ComponentFixture<UnpaidbillsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnpaidbillsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UnpaidbillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
