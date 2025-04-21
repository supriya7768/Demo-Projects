import { Component } from '@angular/core';

@Component({
  selector: 'app-binding',
  templateUrl: './binding.component.html',
  styleUrls: ['./binding.component.sass']
})
export class BindingComponent {

  firstName : string = "Angular";

  angularVersion : string = "18";

  version : number = 18;

  isActive : boolean = true;

  CurrentDate : Date = new Date();

  input : string = "radio";

  selectedState : string = " ";
}
