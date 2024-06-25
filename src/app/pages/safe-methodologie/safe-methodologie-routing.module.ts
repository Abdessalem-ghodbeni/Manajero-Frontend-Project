import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';
import { SafeMethodologiePresentationComponent } from './safe-methodologie-presentation/safe-methodologie-presentation.component';

const routes: Routes = [
  {path:'agile/safe',component:DemoSAFeComponent},
  {path:'agile',component:SafeMethodologiePresentationComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SAFeMethodologieRoutingModule { }
