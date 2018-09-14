import {Component, OnInit} from '@angular/core';
import {PersonService} from "../../Services/person.service";
import {AgencyService} from "../../Services/agency.service";
import {AuthService} from "../../Services/auth.service";
import {AuthUser} from "../../Domain/auth-user";
import {filter, map, mergeMap, tap} from "rxjs/internal/operators";
import {Person} from "../../Domain/Person";
import {Agency} from "../../Domain/Agency";
import {User} from "../../Domain/user";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 't-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  person: Person = null;
  agency: Agency = null;
  user: User = null;

  constructor(private _authService: AuthService, private _personService: PersonService, private _agencyService: AgencyService,private _activatedRoute:ActivatedRoute) {
  }

  ngOnInit() {

    this._authService.onChange().asObservable().pipe(filter((it: AuthUser) => it.isAuth === 'true'),mergeMap(it=>this._activatedRoute.params.pipe(map((it: Params) => it['id']))))
      .subscribe(it=>{

        if (this._authService.getAuthUser().user.type == "010") this._personService.profile(it).subscribe(t => {
          this.person = t;
          this.user = t;
        });
        if (this._authService.getAuthUser().user.type == "001") this._agencyService.profile(it).subscribe(t => {
          this.agency = t;
          this.user = t;
        });

      })



    // this._activatedRoute.params.pipe(map((it: Params) => it['id']),(filter((it: AuthUser) => it.isAuth === 'true')))
    //
    // ;

/*
    this._authService.onChange().asObservable().pipe(filter((it: AuthUser) => it.isAuth === 'true'), tap(it => {
      if (it.user.type == "010") this._personService.profile().subscribe(t => {
        this.person = t;
        this.user = t;
      });
      if (it.user.type == "001") this._agencyService.profile().subscribe(t => {
        this.agency = t;
        this.user = t;
      });
    }))

      .subscribe(it => {

      });
*/



  }

}
