import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BookComponent } from './book/book.component';
import { SignupComponent } from './signup/signup.component';
import { AddBookComponent } from './book/add-book/add-book.component';


const routes:Routes = [
  {path:'login',component:LoginComponent},
  {path:'book',component:BookComponent},
  {path:'addbook',component:AddBookComponent},
  {path:'',redirectTo:'book',pathMatch:'full'},
  {path:'signup',component:SignupComponent}
  // { path: '', redirectTo: 'home', pathMatch: 'full' }
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
