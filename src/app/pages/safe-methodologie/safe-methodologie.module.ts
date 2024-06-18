import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SAFeMethodologieRoutingModule } from './safe-methodologie-routing.module';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';
 
import { NbThemeModule, NbLayoutModule, NbCardModule, NbButtonModule, NbIconModule ,NbStepperModule,NbAccordionModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
@NgModule({
  declarations: [
    DemoSAFeComponent
  ],
  imports: [
    CommonModule,NbButtonModule,NbCardModule,NbLayoutModule,
    NbCardModule,
    NbButtonModule,NbAccordionModule ,
    NbIconModule,
    NbEvaIconsModule,NbStepperModule ,
    SAFeMethodologieRoutingModule
  ]
})
export class SAFeMethodologieModule { }
