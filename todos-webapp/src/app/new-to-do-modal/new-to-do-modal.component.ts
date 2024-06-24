import {Component, EventEmitter, Output} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {NewToDo} from "../../api-client/todos";

@Component({
  selector: 'app-new-to-do-modal',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './new-to-do-modal.component.html',
  styleUrl: './new-to-do-modal.component.css'
})
export class NewToDoModalComponent {

  todo: NewToDo = {title: "", category: "", description: ""}
  @Output() passEntry: EventEmitter<any> = new EventEmitter();

  passBack(): void {
    this.passEntry.emit(this.todo);
  }
}
