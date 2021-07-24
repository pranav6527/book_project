import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl ,FormBuilder,Validators} from '@angular/forms';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  addBookForm = this.fb.group({
    name: ['',Validators.required],
    author:['',Validators.required],
    price:['',Validators.required]
  });

 
  /* 
  name = new FormControl('');
  author = new FormControl('');
  price = new FormControl(''); */

  ngOnInit(): void {
  }

  onSubmit()
  {
    
    console.log(this.addBookForm.value);
    
    
  }

}
