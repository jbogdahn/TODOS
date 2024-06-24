import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {NewToDo} from "../../api-client/todos";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

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

  constructor(public activeModal: NgbActiveModal) {
  }

  todo: NewToDo = {title: "", category: "", description: ""}

  passBack(): void {
    this.activeModal.close(this.todo);
  }
}
