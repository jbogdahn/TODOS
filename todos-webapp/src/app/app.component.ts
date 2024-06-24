import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {TodolistComponent} from "./todolist/todolist.component";
import {NewToDo, ToDoService} from "../api-client/todos";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NewToDoModalComponent} from "./new-to-do-modal/new-to-do-modal.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TodolistComponent,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'todos-webapp';

  constructor(private modalService: NgbModal, private todoService: ToDoService) {
  }

  getAllToDos(): void {
    location.reload();
  }

  openNewTodoModal() {
    const modalRef = this.modalService.open(NewToDoModalComponent);
    modalRef.componentInstance.passEntry.subscribe((newTodo: NewToDo) => {
      console.log(newTodo)
      this.createTodo(newTodo)
    });
  }

  createTodo(newTodo: NewToDo): void {
    this.todoService.createTodo(newTodo).subscribe(todo => this.getAllToDos());
  }
}
