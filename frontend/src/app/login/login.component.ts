import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators} from '@angular/forms';
import { Login } from './login';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  constructor(private fb:FormBuilder) { }
  loginForm = this.fb.group(
    {
      username: ['',[Validators.required,Validators.minLength(3)]],
      password:['',[Validators.required,Validators.minLength(3)]]
    }
  )

  ngOnInit(): void {
  }

  onSubmit(login:Login)
  {

  }

}
