import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';
import { SafeMethodologiePresentationComponent } from './safe-methodologie-presentation/safe-methodologie-presentation.component';
import { UpdateDemoComponent } from './update-demo/update-demo.component';

const routes: Routes = [
  {path:'agile/safe',component:DemoSAFeComponent},
  {path:'agile',component:SafeMethodologiePresentationComponent},
  {path:'update',component:UpdateDemoComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SAFeMethodologieRoutingModule { }
