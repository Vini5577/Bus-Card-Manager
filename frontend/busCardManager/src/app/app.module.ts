import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/pages/home/home.component';
import { UserListComponentComponent } from './components/user-list-component/user-list-component.component';
import { HttpClientModule } from '@angular/common/http';
import { UserFormComponent } from './components/forms/user-form/user-form.component'
import { ionClose, ionPencilSharp, ionTrashSharp, ionCheckmarkCircle, ionCloseCircle, ionArrowBack } from '@ng-icons/ionicons';
import { NgIconsModule } from '@ng-icons/core';
import { FormsModule } from '@angular/forms';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { UpdateUserFormComponent } from './components/forms/update-user-form/update-user-form.component';
import { CardComponent } from './components/pages/card/card.component';
import { CardListComponentComponent } from './components/card-list-component/card-list-component.component';
import { CardFormComponent } from './components/forms/card-form/card-form.component';
import { BackHomeComponent } from './components/back-home/back-home.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    UserListComponentComponent,
    UserFormComponent,
    ConfirmDialogComponent,
    UpdateUserFormComponent,
    CardComponent,
    CardListComponentComponent,
    CardFormComponent,
    BackHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgIconsModule.withIcons({
      ionClose,
      ionPencilSharp,
      ionTrashSharp,
      ionCheckmarkCircle,
      ionCloseCircle,
      ionArrowBack
    }),
    FormsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
