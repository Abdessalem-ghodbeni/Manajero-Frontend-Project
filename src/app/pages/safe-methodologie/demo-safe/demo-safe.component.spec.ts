import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoSAFeComponent } from './demo-safe.component';

describe('DemoSAFeComponent', () => {
  let component: DemoSAFeComponent;
  let fixture: ComponentFixture<DemoSAFeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemoSAFeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemoSAFeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
