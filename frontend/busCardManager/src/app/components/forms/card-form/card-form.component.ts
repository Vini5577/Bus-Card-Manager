import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Card } from 'src/app/interfaces/card';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-card-form',
  templateUrl: './card-form.component.html',
  styleUrls: ['./card-form.component.css']
})
export class CardFormComponent {
  showModal = false;

  cardObj: Card = {
    number: "",
    status: false,
    type: ""
  }

  constructor(private userService: UserService, private router: ActivatedRoute) { }

  ngOnInit(): void { }

  closeModal() {
    this.showModal = !this.showModal;
  }

  addUser() {
    this.userService.addCard(this.router.snapshot.paramMap.get('id'), this.cardObj).subscribe(() => {
      alert('Cartão cadastrado com sucesso!!');
      this.closeModal();
      window.location.reload();
    }, (error) => {
      console.error(error);
      alert('Erro ao cadastrar o cartão!!');
    });
  }
}
