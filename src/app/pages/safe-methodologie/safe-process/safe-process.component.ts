import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';

@Component({
  selector: 'ngx-safe-process',
  templateUrl: './safe-process.component.html',
  styleUrls: ['./safe-process.component.scss']
})
export class SafeProcessComponent implements OnInit {
  selectedTab: number = 1;
  isEditing: boolean = false;
  startDate: string;
  endDate: string;
  newTask = '';
  backlogTasks: any[] = [];
  sprint1Tasks: any[] = [];
  inProgressTasks: any[] = [];
  doneTasks: any[] = [];
  inTestTasks: any[] = [];
  toRedoTasks: any[] = [];
  toImproveTasks: any[] = [];

  connectedDropLists = [
    'backlogTasks',
    'sprint1Tasks',
    'inProgressTasks',
    'doneTasks',
    'inTestTasks',
    'toRedoTasks',
    'toImproveTasks'
  ];

  ngOnInit() {
    this.loadTasks();
  }

  drop(event: CdkDragDrop<any[]>) {
    const previousContainerData = this.getTasks(event.previousContainer.id);
    const currentContainerData = this.getTasks(event.container.id);

    if (event.previousContainer === event.container) {
      moveItemInArray(currentContainerData, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        previousContainerData,
        currentContainerData,
        event.previousIndex,
        event.currentIndex
      );
    }

    this.saveTasks(); // Save task state to local storage after a drop
  }

  addTask() {
    if (this.newTask) {
      this.backlogTasks.push({ title: this.newTask });
      this.newTask = '';
      this.saveTasks(); // Save task state to local storage after adding a task
    }
  }

  saveTasks() {
    localStorage.setItem('backlogTasks', JSON.stringify(this.backlogTasks));
    localStorage.setItem('sprint1Tasks', JSON.stringify(this.sprint1Tasks));
    localStorage.setItem('inProgressTasks', JSON.stringify(this.inProgressTasks));
    localStorage.setItem('doneTasks', JSON.stringify(this.doneTasks));
    localStorage.setItem('inTestTasks', JSON.stringify(this.inTestTasks));
    localStorage.setItem('toRedoTasks', JSON.stringify(this.toRedoTasks));
    localStorage.setItem('toImproveTasks', JSON.stringify(this.toImproveTasks));
  }

  loadTasks() {
    this.backlogTasks = JSON.parse(localStorage.getItem('backlogTasks')) || [];
    this.sprint1Tasks = JSON.parse(localStorage.getItem('sprint1Tasks')) || [];
    this.inProgressTasks = JSON.parse(localStorage.getItem('inProgressTasks')) || [];
    this.doneTasks = JSON.parse(localStorage.getItem('doneTasks')) || [];
    this.inTestTasks = JSON.parse(localStorage.getItem('inTestTasks')) || [];
    this.toRedoTasks = JSON.parse(localStorage.getItem('toRedoTasks')) || [];
    this.toImproveTasks = JSON.parse(localStorage.getItem('toImproveTasks')) || [];
  }

  selectTab(tab: number) {
    this.selectedTab = tab;
  }

  editSprint(sprintId: number, event: MouseEvent) {
    event.stopPropagation();
    this.isEditing = !this.isEditing;
  }

  getTasks(listId: string) {
    switch (listId) {
      case 'backlogTasks': return this.backlogTasks;
      case 'sprint1Tasks': return this.sprint1Tasks;
      case 'inProgressTasks': return this.inProgressTasks;
      case 'doneTasks': return this.doneTasks;
      case 'inTestTasks': return this.inTestTasks;
      case 'toRedoTasks': return this.toRedoTasks;
      case 'toImproveTasks': return this.toImproveTasks;
      default: return [];
    }
  }
}
