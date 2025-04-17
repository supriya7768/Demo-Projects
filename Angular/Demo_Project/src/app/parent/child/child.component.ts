import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.sass']
})
export class ChildComponent {

  @Input() name: string = ''

  @Output() sendmsg = new EventEmitter<string>();

  onClick(){
    this.sendmsg.emit("This is from Child")
  }




  @Input() iplTeam: string = ''
  @Output() sendTeamName = new EventEmitter<string>();

  onCapitalizeClick(){
    this.sendTeamName.emit(this.iplTeam.toUpperCase())
  }
}
