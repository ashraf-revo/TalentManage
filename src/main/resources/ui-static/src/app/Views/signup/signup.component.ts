import {Component, OnInit} from '@angular/core';
import {Person} from "../../Domain/Person";
import {Agency} from "../../Domain/Agency";
import {PersonService} from "../../Services/person.service";
import {AgencyService} from "../../Services/agency.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 't-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public person: Person = new Person();
  public agency: Agency = new Agency();
  errorMessage: string = '';

  constructor(private _personService: PersonService, private _agencyService: AgencyService) {
  }


  ngOnInit() {
  }

  registerPerson() {
    this.errorMessage = "";
    this._personService.save(this.person).subscribe(it => {
    }, error => {


        error.error.errors.forEach(it => {
          this.errorMessage += it.field + "  " + it.defaultMessage + "\n";
        });

    }, () => {
      this.errorMessage = "successfully created person";
    });
  }

  registerAgency() {
    this.errorMessage = "";
    this._agencyService.save(this.agency).subscribe(it => {
    }, (error) => {


      error.error.errors.forEach(it => {
        this.errorMessage += it.field + "  " + it.defaultMessage + "\n";
      });

    }, () => {
      this.errorMessage = "successfully created agency";
    });

  }

}
