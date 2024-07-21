import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';
import { User } from '../interfaces/user';
import { Card } from '../interfaces/card';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseApiUrl = environment.baseApiUrl
  private apiUrl = `${this.baseApiUrl}/user`

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/get`)
  }

  getUser(userId: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/get/${userId}`)
  }

  addUser(user: User):Observable<User[]> {
    return this.http.post<User[]>(`${this.apiUrl}/add`, user)
  }

  deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${userId}`);
  }

  updateUser(user: User): Observable<User[]> {
    return this.http.put<User[]>(`${this.apiUrl}/update`, user)
  }

  addCard(userId: any, card: Card): Observable<Card[]> {
    return this.http.post<Card[]>(`${this.apiUrl}/${userId}/cards/add`, card)
  }

  getCards(userId: any): Observable<Card[]> {
    return this.http.get<Card[]>(`${this.apiUrl}/${userId}/cards/get`)
  }

  getCard(userId: any, cardId: any): Observable<Card> {
    return this.http.get<Card>(`${this.apiUrl}/${userId}/cards/get/${cardId}`)
  }

  removeCard(userId: any, cardId: any): Observable<Card[]> {
    return this.http.delete<Card[]>(`${this.apiUrl}/${userId}/cards/delete/${cardId}`)
  }

  changeCardStatus(userId: any, cardId: any): Observable<Card[]> {
    return this.http.put<Card[]>(`${this.apiUrl}/${userId}/cards/status/${cardId}`, {});
  }
}
