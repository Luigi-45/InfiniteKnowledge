import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'Sistema - InfiniteKnowledge';
  rol:string;
  constructor(private cookieService: CookieService) {}

  ngOnInit(): void {
    this.rol = this.cookieService.get('rol');
  }

}
