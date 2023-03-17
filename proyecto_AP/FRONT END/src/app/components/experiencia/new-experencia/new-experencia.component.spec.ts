import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewExperenciaComponent } from './new-experencia.component';

describe('NewExperenciaComponent', () => {
  let component: NewExperenciaComponent;
  let fixture: ComponentFixture<NewExperenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewExperenciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewExperenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
