import { Component, Input, ViewChild } from '@angular/core';
import { UserFormComponent } from '../../forms/user-form/user-form.component';
import { UpdateUserFormComponent } from '../../forms/update-user-form/update-user-form.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  @ViewChild(UserFormComponent) userFormComponent!: UserFormComponent;

  openModal() {
    this.userFormComponent.showModal = true;
  }
}
