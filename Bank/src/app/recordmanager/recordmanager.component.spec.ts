import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordmanagerComponent } from './recordmanager.component';

describe('RecordmanagerComponent', () => {
  let component: RecordmanagerComponent;
  let fixture: ComponentFixture<RecordmanagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecordmanagerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecordmanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
