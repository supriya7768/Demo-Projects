import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { PipesComponent } from './pipes/pipes.component';

const routes: Routes = [
  {
    path:"Dashboard", component:DashboardComponent
  },
  {
    path:"First", component:FirstComponent
  },
  {
    path:"Second", component:SecondComponent
  },
  {
    path:"Pipes", component:PipesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
