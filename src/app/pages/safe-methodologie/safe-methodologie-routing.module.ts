import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';

const routes: Routes = [
  {path:'agile/safe',component:DemoSAFeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SAFeMethodologieRoutingModule { }
