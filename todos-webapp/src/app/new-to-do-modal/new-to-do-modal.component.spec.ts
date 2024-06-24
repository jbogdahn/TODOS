import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewToDoModalComponent } from './new-to-do-modal.component';

describe('NewToDoModalComponent', () => {
  let component: NewToDoModalComponent;
  let fixture: ComponentFixture<NewToDoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewToDoModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewToDoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
