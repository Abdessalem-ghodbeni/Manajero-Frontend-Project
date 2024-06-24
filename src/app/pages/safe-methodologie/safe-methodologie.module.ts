import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NbWindowModule } from '@nebular/theme';
import { SAFeMethodologieRoutingModule } from './safe-methodologie-routing.module';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';
 
import { NbThemeModule, NbLayoutModule, NbCardModule, NbButtonModule, NbIconModule ,NbStepperModule,NbAccordionModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { SafeMethodologiePresentationComponent } from './safe-methodologie-presentation/safe-methodologie-presentation.component';
 
@NgModule({
  declarations: [
    DemoSAFeComponent,
    SafeMethodologiePresentationComponent,
 
  ],
  imports: [
    CommonModule,NbButtonModule,NbCardModule,NbLayoutModule,
    NbCardModule,
    NbButtonModule,NbAccordionModule ,
    NbIconModule,
    NbEvaIconsModule,NbStepperModule ,NbWindowModule,
    SAFeMethodologieRoutingModule
  ]
})
export class SAFeMethodologieModule { }
