import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NbInputModule, NbWindowModule } from '@nebular/theme';
import { SAFeMethodologieRoutingModule } from './safe-methodologie-routing.module';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';
 
import { NbThemeModule, NbLayoutModule, NbCardModule, NbButtonModule, NbIconModule ,NbStepperModule,NbAccordionModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { SafeMethodologiePresentationComponent } from './safe-methodologie-presentation/safe-methodologie-presentation.component';
import { UpdateDemoComponent } from './update-demo/update-demo.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
 
@NgModule({
  declarations: [
    DemoSAFeComponent,
    SafeMethodologiePresentationComponent,
    UpdateDemoComponent,
 
  ],
  imports: [
    CommonModule,
    NbButtonModule,
    NbCardModule,
    NbLayoutModule,
    NbCardModule,
    NbButtonModule,
    NbAccordionModule ,
    NbIconModule,
    NbEvaIconsModule,
    NbStepperModule,
    NbWindowModule,
    SAFeMethodologieRoutingModule,
    NbInputModule ,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class SAFeMethodologieModule { }
