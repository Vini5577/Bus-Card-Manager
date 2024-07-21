import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardListComponentComponent } from './card-list-component.component';

describe('CardListComponentComponent', () => {
  let component: CardListComponentComponent;
  let fixture: ComponentFixture<CardListComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CardListComponentComponent]
    });
    fixture = TestBed.createComponent(CardListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
