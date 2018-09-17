import {Component, OnInit} from '@angular/core';
import {PersonService} from "../../Services/person.service";

@Component({
  selector: 't-account-edit',
  templateUrl: './account-edit.component.html',
  styleUrls: ['./account-edit.component.css']
})
export class AccountEditComponent implements OnInit {
  skills: string[] = [];
  skill: string = "";

  constructor(private _personService: PersonService) {
  }

  ngOnInit() {
    this._personService.skills().subscribe(it => {
      this.skills = it;
    });
  }

  append() {
    this.skills.push(this.skill);
  }
}
