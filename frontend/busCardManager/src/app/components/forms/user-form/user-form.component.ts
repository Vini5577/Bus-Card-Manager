import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  showModal = false;

  userObj: User = {
    name: "",
    email: "",
    password: ""
  }

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void { }

  closeModal() {
    this.showModal = !this.showModal;
  }

  addUser() {
    this.userService.addUser(this.userObj).subscribe(() => {
      alert('Usuário cadastrado com sucesso!!');
      this.closeModal();
      window.location.reload();
    }, (error) => {
      console.error(error);
      alert('Erro ao cadastrar o usuário!!');
    });
  }
}
