import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor() { }

  sendMsgToComponent() : string{
    return "I am company service."
  }
}
