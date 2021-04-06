import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './book/book';
@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseUrl:string = "http://localhost:8080/book"

  constructor(private http: HttpClient) { }

  getAllBooks():Observable<Book>
  {
    return this.http.get<Book>(this.baseUrl+"/all-books");
  }
}
