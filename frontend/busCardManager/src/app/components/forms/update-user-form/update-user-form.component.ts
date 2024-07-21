import { UpdateLogger } from './../../../../../node_modules/@angular/cdk/schematics/update-tool/logger.d';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-update-user-form',
  templateUrl: './update-user-form.component.html',
  styleUrls: ['./update-user-form.component.css']
})
export class UpdateUserFormComponent {
  showUpdateModal = false;
  id: number = 1;

  userObj: User = {
    id: 0,
    name: "",
    email: "",
    password: ""
  }

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.timeout;
  }

  closeModal() {
    this.showUpdateModal = !this.showUpdateModal;
  }

  updateUser() {
    this.userService.updateUser(this.userObj).subscribe(() => {
      alert('Usuário atualizado com sucesso!!');
      this.closeModal();
      window.location.reload();
    }, (error) => {
      console.error(error);
      alert('Erro ao atualizar o usuário!!');
    });
  }

  getUser(userId: any) {
    this.userService.getUser(userId).subscribe((data) => {
      this.userObj.id = data.id;
      this.userObj.name = data.name;
      this.userObj.email = data.email;
    });
  }

  loadUser() {
    if(this.showUpdateModal) {
      this.getUser(this.id);
      clearTimeout(this.timeout);
    }
  }

  timeout = setTimeout(() => {
    this.loadUser();
  }, 100);
}
