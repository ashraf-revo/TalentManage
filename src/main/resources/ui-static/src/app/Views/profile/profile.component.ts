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
import {UserService} from "../../Services/user.service";
import {Interview} from "../../Domain/interview";

@Component({
  selector: 't-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  person: Person = null;
  agency: Agency = null;
  user: User = null;
  public authService: AuthService;
  interview: Interview = new Interview();
  id: string = "-1";

  constructor(private _userService: UserService, private _authService: AuthService, private _personService: PersonService, private _agencyService: AgencyService, private _activatedRoute: ActivatedRoute) {
    this.authService = this._authService;
  }

  save() {

    this._agencyService.saveInterview(this.interview).subscribe(it => {
      this.interview = new Interview();
    })
  }

  ngOnInit() {

    this._authService.onChange().asObservable().pipe(filter((it: AuthUser) => it.isAuth === 'true'), mergeMap(it => this._activatedRoute.params.pipe(map((it: Params) => it['id']))),
      tap(it => {
        this.interview.person.id = it;
        this.interview.agency.id = this._authService.getAuthUser().user.id;
        this.id = it;
      }),

      mergeMap(it => this._userService.findOne(it)))
      .subscribe(it => {

        if (it.type == "010") this._personService.profile(it.id).subscribe(t => {
          this.person = t;
          this.user = t;
        });
        if (it.type == "001") this._agencyService.profile(it.id).subscribe(t => {
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
