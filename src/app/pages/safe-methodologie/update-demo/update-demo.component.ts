import { Component, OnInit } from '@angular/core';
import { DemoService } from '../../services/demo.service';
import { Router } from '@angular/router';
import { Demo } from '../../models/demo.model'; // Ensure path is correct based on your project structure
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'ngx-update-demo',
  templateUrl: './update-demo.component.html',
  styleUrls: ['./update-demo.component.scss']
})
export class UpdateDemoComponent implements OnInit {
  id = '669019f2b2b147200accaa7e'; // Example ID
  demo: Demo | null = null;

  constructor(private demoService: DemoService, private router: Router) { }

  ngOnInit(): void {
    this.getDemoById(this.id);
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

  updateDemo(): void {
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

  
  
}
