import { Component } from '@angular/core';

@Component({
  selector: 'ngx-safe-methodologie-presentation',
  templateUrl: './safe-methodologie-presentation.component.html',
  styleUrls: ['./safe-methodologie-presentation.component.scss']
})
export class SafeMethodologiePresentationComponent {
  isEditing: boolean = false;
  text: string = `In an increasingly complex and competitive business environment,
    large organizations must demonstrate unprecedented agility to meet
    market demands and changing customer needs. While traditional agile
    methodologies like Scrum and Kanban have proven effective at the
    small team level, large companies face unique challenges when it
    comes to applying them at scale. It is in this context that the
    Scaled Agile Framework (SAFe) stands out as a powerful and proven
    framework for adopting agile principles across the entire
    organization. By integrating Lean, Agile and DevOps concepts, SAFe
    helps transform complex organizational structures into fluid and
    responsive systems, while ensuring strategic alignment, operational
    efficiency, and continuous improvement. This methodology not only
    addresses immediate needs, but also establishes a solid foundation
    for sustainable growth and constant innovation. By providing a
    structured overview that integrates the team, program, broad
    solution, and portfolio levels, SAFe ensures that all participants,
    from developers to executives, work in harmony toward common goals.
    Adopting the SAFe method not only means embracing a new way of
    working, but also paving the way for a deep and significant
    organizational transformation. In this article, we will explore in
    detail how the SAFe method, applied according to the Kolb learning
    model, can revolutionize the way you manage and deliver large-scale
    projects, ensuring quality, transparency, and responsiveness. Join
    us to discover why SAFe is the key to successfully navigating modern
    business complexity.`;
  editText: string = this.text;

  onEdit() {
    this.isEditing = true;
    this.editText = this.text; // Initialize editText with current text
  }

  onCancel() {
    this.isEditing = false;
  }

  onDone() {
    this.text = this.editText; // Update text with edited content
    this.isEditing = false;
  }
}
