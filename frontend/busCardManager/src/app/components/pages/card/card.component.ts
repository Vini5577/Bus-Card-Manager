import { Component, ViewChild } from '@angular/core';
import { CardFormComponent } from '../../forms/card-form/card-form.component';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  @ViewChild(CardFormComponent) cardFormComponent! : CardFormComponent;

  openModal() {
    this.cardFormComponent.showModal = true;
  }
}
