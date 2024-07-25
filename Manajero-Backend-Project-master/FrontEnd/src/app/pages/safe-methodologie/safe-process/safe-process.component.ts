import { Component, OnInit } from "@angular/core";
import { CdkDragDrop, moveItemInArray, transferArrayItem } from "@angular/cdk/drag-drop";
import { HttpClient } from "@angular/common/http";
import { BacklogService } from "../../../@core/Services/Backlog/backlog.service";
import { TaskService } from "../../../@core/Services/task.service";
import Swal from "sweetalert2";

@Component({
  selector: "ngx-safe-process",
  templateUrl: "./safe-process.component.html",
  styleUrls: ["./safe-process.component.scss"],
})
export class SafeProcessComponent implements OnInit {
  selectedTab: number = 1;
  isEditing: boolean = false;
  startDate: string = "";
  endDate: string = "";
  newTaskTitle = "";
  newTaskDescription = "";
  newTaskStatus = "TO_IMPROVE";
  newTaskAssignee = "Utilisateur 2";
  backlogTasks: any[] = [];
  sprint1Tasks: any[] = [];
  inProgressTasks: any[] = [];
  doneTasks: any[] = [];
  inTestTasks: any[] = [];
  toRedoTasks: any[] = [];
  toImproveTasks: any[] = [];
  menuVisibility: { [key: string]: boolean } = {}; // Object to track visibility of menus
  editingTask: any = null; // Track the task being edited

  connectedDropLists = [
    "backlogTasks",
    "sprint1Tasks",
    "inProgressTasks",
    "doneTasks",
    "inTestTasks",
    "toRedoTasks",
    "toImproveTasks",
  ];

  constructor(
    private http: HttpClient,
    private _backlog_service: BacklogService,
    private _task_service: TaskService // Inject TaskService
  ) {}

  ngOnInit() {
    this.loadTasks();
  }

  toggleMenu(taskId: string) {
    this.menuVisibility[taskId] = !this.menuVisibility[taskId];
  }

  editTask(task: any) {
    // Populate form with the task details for editing
    this.editingTask = task;
    this.newTaskTitle = task.title;
    this.newTaskDescription = task.description;
    this.startDate = task.start_date;
    this.endDate = task.end_date;
    this.newTaskAssignee = task.assignee;
    this.isEditing = true;
  }

  saveTask() {
    if (this.isEditing && this.editingTask) {
      // Update existing task
      const updatedTask = {
        ...this.editingTask,
        title: this.newTaskTitle,
        description: this.newTaskDescription,
        start_date: this.startDate,
        end_date: this.endDate,
        assignee: this.newTaskAssignee
      };

      this._task_service.updateTask(this.editingTask._id, updatedTask).subscribe(
        (response: any) => {
          Swal.fire({
            icon: "success",
            title: "Task Updated",
            text: "The task was successfully updated.",
            showConfirmButton: false,
            timer: 1500
          });
          this.loadTasks();
          this.resetForm();
        },
        (error: any) => {
          Swal.fire({
            icon: "error",
            title: "Error",
            text: "An error occurred while updating the task.",
            footer: "Please try again"
          });
        }
      );
    } else {
      // Add new task
      if (this.newTaskTitle && this.newTaskDescription && this.startDate && this.endDate) {
        const newTask = {
          title: this.newTaskTitle,
          description: this.newTaskDescription,
          status: this.newTaskStatus,
          start_date: this.startDate,
          end_date: this.endDate,
          assignee: this.newTaskAssignee,
        };

        this._backlog_service.AjouterBacklog(newTask).subscribe(
          (response: any) => {
            const createdTask = {
              ...newTask,
              _id: response._id, // Use the ID from the backend response
            };
            this.backlogTasks.push(createdTask);
            this.saveTasks();
            Swal.fire({
              icon: "success",
              title: "Task Created",
              text: "The task was successfully created.",
              showConfirmButton: false,
              timer: 1500
            });
            this.resetForm();
          },
          (error: any) => {
            Swal.fire({
              icon: "error",
              title: "Error",
              text: "An error occurred while creating the task.",
              footer: "Please try again"
            });
          }
        );
      }
    }
  }

  deleteTask(task: any) {
    const taskId = task._id;
    if (!taskId) {
      console.error("Task ID is missing");
      return;
    }
    this._task_service.deleteTask(taskId).subscribe(
      () => {
        Swal.fire({
          icon: "success",
          title: "Task Deleted",
          text: "The task was successfully deleted.",
          showConfirmButton: false,
          timer: 1500
        });
        this.removeTaskFromLocalList(taskId);
      },
      (error) => {
        Swal.fire({
          icon: "error",
          title: "Error",
          text: "An error occurred while deleting the task.",
          footer: "Please try again"
        });
      }
    );
  }

  removeTaskFromLocalList(taskId: string) {
    this.backlogTasks = this.backlogTasks.filter(task => task._id !== taskId);
    this.sprint1Tasks = this.sprint1Tasks.filter(task => task._id !== taskId);
    this.inProgressTasks = this.inProgressTasks.filter(task => task._id !== taskId);
    this.doneTasks = this.doneTasks.filter(task => task._id !== taskId);
    this.inTestTasks = this.inTestTasks.filter(task => task._id !== taskId);
    this.toRedoTasks = this.toRedoTasks.filter(task => task._id !== taskId);
    this.toImproveTasks = this.toImproveTasks.filter(task => task._id !== taskId);
    this.saveTasks();
  }

  drop(event: CdkDragDrop<any[]>) {
    const previousContainerData = this.getTasks(event.previousContainer.id);
    const currentContainerData = this.getTasks(event.container.id);

    if (event.previousContainer === event.container) {
      moveItemInArray(
        currentContainerData,
        event.previousIndex,
        event.currentIndex
      );
    } else {
      transferArrayItem(
        previousContainerData,
        currentContainerData,
        event.previousIndex,
        event.currentIndex
      );
    }

    this.saveTasks();
  }

  saveTasks() {
    localStorage.setItem("backlogTasks", JSON.stringify(this.backlogTasks));
    localStorage.setItem("sprint1Tasks", JSON.stringify(this.sprint1Tasks));
    localStorage.setItem("inProgressTasks", JSON.stringify(this.inProgressTasks));
    localStorage.setItem("doneTasks", JSON.stringify(this.doneTasks));
    localStorage.setItem("inTestTasks", JSON.stringify(this.inTestTasks));
    localStorage.setItem("toRedoTasks", JSON.stringify(this.toRedoTasks));
    localStorage.setItem("toImproveTasks", JSON.stringify(this.toImproveTasks));
  }

  loadTasks() {
    this.backlogTasks = JSON.parse(localStorage.getItem("backlogTasks")) || [];
    this.sprint1Tasks = JSON.parse(localStorage.getItem("sprint1Tasks")) || [];
    this.inProgressTasks = JSON.parse(localStorage.getItem("inProgressTasks")) || [];
    this.doneTasks = JSON.parse(localStorage.getItem("doneTasks")) || [];
    this.inTestTasks = JSON.parse(localStorage.getItem("inTestTasks")) || [];
    this.toRedoTasks = JSON.parse(localStorage.getItem("toRedoTasks")) || [];
    this.toImproveTasks = JSON.parse(localStorage.getItem("toImproveTasks")) || [];
  }

  sendTasksToApi() {
    const payload = { tasks: this.backlogTasks };
    this._backlog_service.AjouterBacklog(payload).subscribe(
      (response: any) => {
        Swal.fire({
          icon: "success",
          title: "Operation réussie",
          text: "Vous pouvez voir la liste des articles",
          showConfirmButton: false,
          timer: 1500,
        });
      },
      (error: any) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Une erreur est survenue lors de l'ajout de l'article",
          footer: "Veuillez réessayer",
        });
      }
    );
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
      case "backlogTasks":
        return this.backlogTasks;
      case "sprint1Tasks":
        return this.sprint1Tasks;
      case "inProgressTasks":
        return this.inProgressTasks;
      case "doneTasks":
        return this.doneTasks;
      case "inTestTasks":
        return this.inTestTasks;
      case "toRedoTasks":
        return this.toRedoTasks;
      case "toImproveTasks":
        return this.toImproveTasks;
      default:
        return [];
    }
  }

  resetForm() {
    this.newTaskTitle = "";
    this.newTaskDescription = "";
    this.startDate = "";
    this.endDate = "";
    this.newTaskAssignee = "Utilisateur 2";
    this.isEditing = false;
    this.editingTask = null;
  }
}
