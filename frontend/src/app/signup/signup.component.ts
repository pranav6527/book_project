import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  form: any = {
    username: null,
    email:null,
    password: null
  };
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit()
  {

  }

}
