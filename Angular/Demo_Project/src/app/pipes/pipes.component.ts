import { Component } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.sass']
})
export class PipesComponent {

  today : Date = new Date();

  number = 1234;

  variable = 'Welcome'

  person =
  {
    name : 'Radha',
    age : 14
  }

  message = 'AngularIsAwesome'

  gender = ''
  genderMap = {
    'male' : 'him',
    'female' : 'her',
    'other' : 'them'
  }

  changeGender(gender : string){
    this.gender=gender
  }

  abc = "Pune"

  num1 = 10;
  
}
