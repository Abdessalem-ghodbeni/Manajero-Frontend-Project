import { Component } from '@angular/core';
import { NbButtonModule, NbCardModule } from '@nebular/theme';
@Component({
  selector: 'ngx-demo-safe',
  templateUrl: './demo-safe.component.html',
  styleUrls: ['./demo-safe.component.scss']
})
export class DemoSAFeComponent {
  showFullDescription = false;

  toggleDescription() {
    this.showFullDescription = !this.showFullDescription;
  }
}
