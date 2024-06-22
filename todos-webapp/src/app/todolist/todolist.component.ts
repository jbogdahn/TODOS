import {Component} from '@angular/core';
import {ToDo, ToDoService} from "../../api-client/todos";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'todoList',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './todolist.component.html',
  styleUrl: './todolist.component.scss'
})

export class TodolistComponent {
  todos: ToDo[] | undefined;

  constructor(private todoService: ToDoService) {
  }

  ngOnInit(): void {
    this.getTodos();
  }

  getTodos(): void {
    this.todoService.getToDos().subscribe(todos => (this.todos = todos));
  }

  onSelect(todo: ToDo) {

  }
}
