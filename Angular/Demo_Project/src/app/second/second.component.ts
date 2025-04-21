import { Component } from '@angular/core';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.sass']
})
export class SecondComponent {

  color = 'Red'
  fontSize = 40

  isActive = true
  notActive = false
}
