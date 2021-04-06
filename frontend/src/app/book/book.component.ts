import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from './book';
import { throwError } from 'rxjs';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books: Book;
  constructor(private bookService: BookService) {

  }

  ngOnInit(): void {
    console.log(this.getAllBooks());


  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(data => {
      this.books = data;
    }, error => {
      throwError(error);
    });

  }

}
