import { Component, OnInit } from "@angular/core";
import {
  CdkDragDrop,
  moveItemInArray,
  transferArrayItem,
} from "@angular/cdk/drag-drop";
import { HttpClient } from "@angular/common/http"; // Importez HttpClient pour les appels API
import { BacklogService } from "../../../@core/Services/Backlog/backlog.service";
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
  newTaskStatus = "TO_IMPROVE"; // Statut par défaut
  newTaskAssignee = "Utilisateur 2"; // Assignee par défaut
  backlogTasks: any[] = [];
  sprint1Tasks: any[] = [];
  inProgressTasks: any[] = [];
  doneTasks: any[] = [];
  inTestTasks: any[] = [];
  toRedoTasks: any[] = [];
  toImproveTasks: any[] = [];

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
    private _backlog_service: BacklogService
  ) {} // Injectez HttpClient

  ngOnInit() {
    this.loadTasks();
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

    this.saveTasks(); // Save task state to local storage after a drop
  }

  addTask() {
    if (
      this.newTaskTitle &&
      this.newTaskDescription &&
      this.startDate &&
      this.endDate
    ) {
      const newTask = {
        title: this.newTaskTitle,
        description: this.newTaskDescription,
        status: this.newTaskStatus,
        start_date: this.startDate,
        end_date: this.endDate,
        assignee: this.newTaskAssignee,
      };

      this.backlogTasks.push(newTask);
      this.newTaskTitle = "";
      this.newTaskDescription = "";
      this.newTaskStatus = "TO_IMPROVE";
      this.startDate = "";
      this.endDate = "";
      this.newTaskAssignee = "Utilisateur 2";

      this.saveTasks(); // Sauvegarder l'état des tâches dans le localStorage

      // Envoyer la liste des tâches à l'API
      this.sendTasksToApi();
    }
  }

  saveTasks() {
    localStorage.setItem("backlogTasks", JSON.stringify(this.backlogTasks));
    localStorage.setItem("sprint1Tasks", JSON.stringify(this.sprint1Tasks));
    localStorage.setItem(
      "inProgressTasks",
      JSON.stringify(this.inProgressTasks)
    );
    localStorage.setItem("doneTasks", JSON.stringify(this.doneTasks));
    localStorage.setItem("inTestTasks", JSON.stringify(this.inTestTasks));
    localStorage.setItem("toRedoTasks", JSON.stringify(this.toRedoTasks));
    localStorage.setItem("toImproveTasks", JSON.stringify(this.toImproveTasks));
  }

  loadTasks() {
    this.backlogTasks = JSON.parse(localStorage.getItem("backlogTasks")) || [];
    this.sprint1Tasks = JSON.parse(localStorage.getItem("sprint1Tasks")) || [];
    this.inProgressTasks =
      JSON.parse(localStorage.getItem("inProgressTasks")) || [];
    this.doneTasks = JSON.parse(localStorage.getItem("doneTasks")) || [];
    this.inTestTasks = JSON.parse(localStorage.getItem("inTestTasks")) || [];
    this.toRedoTasks = JSON.parse(localStorage.getItem("toRedoTasks")) || [];
    this.toImproveTasks =
      JSON.parse(localStorage.getItem("toImproveTasks")) || [];
  }

  // sendTasksToApi() {
  //   const apiUrl = "https://your-api-endpoint.com/tasks"; // Remplacez par l'URL de votre API
  //   this.http.post(apiUrl, { tasks: this.backlogTasks }).subscribe(
  //     (response) => {
  //       console.log("Tasks successfully sent to the API", response);
  //     },
  //     (error) => {
  //       console.error("Error sending tasks to the API", error);
  //     }
  //   );
  // }
  sendTasksToApi() {
    const payload = { tasks: this.backlogTasks };
    this._backlog_service.AjouterBacklog(payload).subscribe(
      (response: any) => {
        Swal.fire({
          icon: "success",
          title: "operation  réussie",
          text: "Vous pouvez voir la liste des article",
          showConfirmButton: false,
          timer: 1500,
        });
      },
      (error: any) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Une erreur est survenue lors de l'ajout du article",
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
}
