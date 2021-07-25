import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl ,FormBuilder,Validators} from '@angular/forms';
import { BookService } from 'src/app/book.service';
import { Book } from '../book';
import { Observable } from 'rxjs';
import {  Router } from '@angular/router';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private fb:FormBuilder,private bookService:BookService, private router: Router ) { }

  addBookForm = this.fb.group({
    book_name: ['',[Validators.required,Validators.minLength(3)]],
    author:['',[Validators.required,Validators.minLength(3)]],
    price:['',[Validators.required,Validators.pattern("^[0-9]*$")]] 
  });

  
  /* 
  name = new FormControl('');
  author = new FormControl('');
  price = new FormControl(''); */

  ngOnInit(): void {
  }

  onSubmit(book:Book)
  {
    this.bookService.addBooks(book).subscribe(result => this.bookList());
    
    
  }

  bookList()  {
    this.router.navigate(['/addbook']); 
  }

}
