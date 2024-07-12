import { Component, OnInit } from '@angular/core';
import { DemoService } from '../../services/demo.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Demo } from '../../modals/demo.model';

@Component({
  selector: 'ngx-update-demo',
  templateUrl: './update-demo.component.html',
  styleUrls: ['./update-demo.component.scss']
})
export class UpdateDemoComponent implements OnInit {
  id = '669019f2b2b147200accaa7e'; // Example ID
  demo: Demo | null = null;
  demoForm: FormGroup;
  DemoForm = new FormGroup({
    s1_FS_Title: new FormControl(''),
    s1_FS_Description: new FormControl(''),
    s1_SS_Introduction: new FormControl(''),

  

  });

  constructor(private demoService: DemoService, private router: Router,private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getDemoById(this.id);
    this.fetchDemoData(this.id);

  

  }

  fetchDemoData(id: string): void {
    this.demoService.getDemobyID(id).subscribe(
      (data: Demo) => {
        this.demo = data;
        this.demoForm.patchValue(data); // Populate form with demo data
      },
      (error) => {
        console.error('Error fetching demo', error);
      }
    );
  }
  
  getDemoById(id: string): void {
    this.demoService.getDemobyID(id).subscribe(
      (data: Demo) => {
        this.demo = data;
      },
      (error) => {
        console.error('Error fetching demo', error);
      }
    );
  }

  updateDemo1(): void {
    if (this.demo) {
      this.demoService.updateDemoById(this.id, this.demo).subscribe(
        (response) => {
          console.log('Update successful:', response);
          this.router.navigate(['/pages/safe/agile']);
        },
        (error) => {
          console.error('Error during update:', error);
          // Handle errors, display messages to the user
        }
      );
    } else {
      console.error('Demo data not loaded.');
      // Handle case where demo data is not loaded or available
    }
  }

  updateDemo2(): void {
    if (this.demoForm.valid) {
      const updatedDemo = {
        ...this.demo,
        ...this.demoForm.value
      };

      this.demoService.updateDemoById(this.id, updatedDemo).subscribe(
        (response) => {
          console.log('Update successful:', response);
          this.router.navigate(['/pages/safe/agile']);
        },
        (error) => {
          console.error('Error during update:', error);
          // Handle errors, display messages to the user
        }
      );
    } else {
      console.error('Form is not valid');
      // Handle form validation errors
    }
  }
  

updateDemo() {
  this.demoService
    .updateDemoById(this.id,this.DemoForm.value)
    .subscribe(
      (data: any) => {
        alert("demo a été mise à jour avec succès.");
        this.router.navigate(['/pages/safe/agile']);
      },
      (error: any) => {
        console.error("Erreur lors de la mise à jour de demo :", error);
        alert("Une erreur est survenue lors de la mise à jour de demo.");
      }
    );
}


}
