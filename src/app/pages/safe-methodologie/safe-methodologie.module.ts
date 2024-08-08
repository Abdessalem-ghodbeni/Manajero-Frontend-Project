import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NbInputModule, NbWindowModule } from '@nebular/theme';
import { SAFeMethodologieRoutingModule } from './safe-methodologie-routing.module';
import { DemoSAFeComponent } from './demo-safe/demo-safe.component';
 
import { NbThemeModule, NbLayoutModule, NbCardModule, NbButtonModule, NbIconModule ,NbStepperModule,NbAccordionModule } from '@nebular/theme';
import { SafeMethodologiePresentationComponent } from './safe-methodologie-presentation/safe-methodologie-presentation.component';
import { UpdateDemoComponent } from './update-demo/update-demo.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SafeProcessComponent } from './safe-process/safe-process.component';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { SprintDetailsComponent } from './sprint-details/sprint-details.component';
 
@NgModule({
  declarations: [
    DemoSAFeComponent,
    SafeMethodologiePresentationComponent,
    UpdateDemoComponent,
    SafeProcessComponent,
    SprintDetailsComponent,
 
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
    NbStepperModule,
    NbWindowModule,
    SAFeMethodologieRoutingModule,
    NbInputModule ,
    FormsModule,
    ReactiveFormsModule,
    DragDropModule

  ]
})
export class SAFeMethodologieModule { }
