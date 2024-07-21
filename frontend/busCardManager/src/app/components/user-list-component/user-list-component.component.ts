import { UserService } from './../../services/user.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/app/interfaces/user';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { UpdateUserFormComponent } from '../forms/update-user-form/update-user-form.component';

@Component({
  selector: 'app-user-list-component',
  templateUrl: './user-list-component.component.html',
  styleUrls: ['./user-list-component.component.css']
})
export class UserListComponentComponent implements OnInit {
  users: User[] = [];
  @ViewChild(UpdateUserFormComponent) updateUserFormComponent!: UpdateUserFormComponent;

  constructor(private userService: UserService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe((data) => {
      this.users = data;
    });
  }

  deleteUser(userId: any): void {
    const dialogRef = this.dialog.open(ConfirmDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.userService.deleteUser(userId).subscribe(() => {
          this.users = this.users.filter(user => user.id !== userId);
          this.loadUsers()
        });
      }
    });
  }

  loadUsers(): void {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
    });
  }

  openUpdateModal(id: any) {
    this.updateUserFormComponent.showUpdateModal = true;
    this.updateUserFormComponent.id = id;
    this.updateUserFormComponent.loadUser();
  }
}
