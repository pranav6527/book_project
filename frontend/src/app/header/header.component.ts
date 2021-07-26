import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../book.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  search:string;
 
  constructor(private router:Router,bookService:BookService) { }

  ngOnInit(): void {
   
  }

  handleInput(event: KeyboardEvent) { 
    this.search = event.key;
    console.log(this.search);
    
  }
  redirectToHome()
  {
    this.router.navigate(['']);
  }

}
