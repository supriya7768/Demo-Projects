import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customPipe'
})
export class CustomPipePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }
}

@Pipe({
  name: 'reverse'
})
export class Reverse implements PipeTransform {

  transform(abc :string ) {
    return abc.split('').reverse().join('');
  }
}

@Pipe({
  name: 'addition'
})
export class AdditionPipe implements PipeTransform {

  transform(num1 : number, num2 : number) {
    return num1 + num2;
  }
}