import {Component, OnInit} from '@angular/core';
import {PersonService} from "../../Services/person.service";
import {Person} from "../../Domain/Person";

@Component({
  selector: 't-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  public persons: Person[] = [];

  constructor(private _personService: PersonService) {
  }

  ngOnInit() {
    this._personService.persons().subscribe(it => {
      this.persons = it;
    })
  }

}
