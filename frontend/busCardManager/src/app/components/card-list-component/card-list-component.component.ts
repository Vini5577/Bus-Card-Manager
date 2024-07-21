import { Card } from '../../interfaces/card';
import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-card-list-component',
  templateUrl: './card-list-component.component.html',
  styleUrls: ['./card-list-component.component.css']
})
export class CardListComponentComponent implements OnInit {
 cards: Card[] = []

 constructor(
    private userService: UserService,
    private router: ActivatedRoute,
    private dialog: MatDialog) { }

  ngOnInit(): void {
   this.userService.getCards(this.router.snapshot.paramMap.get('id')).subscribe((data) => {
     this.cards = data
   })
  }

  changeStatus(cardId: any) {
    this.userService.changeCardStatus(this.router.snapshot.paramMap.get('id'), cardId).subscribe((data) => {
      this.loadCards()
    })
  }

  loadCards() {
    this.userService.getCards(this.router.snapshot.paramMap.get('id')).subscribe((data) => {
      this.cards = data
    })
  }

  deleteCard(cardId: any): void {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '300px',
      height: '200px',
      panelClass: 'custom-dialog-container'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.userService.removeCard(this.router.snapshot.paramMap.get('id'), cardId).subscribe(() => {
          this.cards = this.cards.filter(card => card.id !== cardId);
          this.loadCards()
        });
      }
    });
  }
}
