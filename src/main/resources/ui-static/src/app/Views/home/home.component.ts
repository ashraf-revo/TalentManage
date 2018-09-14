import {Component, OnInit} from '@angular/core';
import {BaseUserService} from "../../Services/BaseUser.service";
import {Interview} from "../../Domain/interview";
import {AuthService} from "../../Services/auth.service";
import {filter, mergeMap} from "rxjs/internal/operators";
import {AuthUser} from "../../Domain/auth-user";

@Component({
  selector: 't-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public interviews: Interview[] = [];

  constructor(private personService: BaseUserService, private _authService: AuthService) {

  }

  ngOnInit() {
    this._authService.onChange().asObservable().pipe(filter((it: AuthUser) => it.isAuth === 'true'), mergeMap(it => this.personService.interviews())).subscribe(it => this.interviews = it);
  }

}
