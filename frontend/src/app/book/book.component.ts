import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from './book';
import { throwError } from 'rxjs';
import { provideRoutes } from '@angular/router';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  public books: Book[] = [];
  constructor(private bookService: BookService) {

  }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(res => {
      this.books = res;
      console.log(this.books);

    }, error => {
      throwError(error);
    });

  }

}
