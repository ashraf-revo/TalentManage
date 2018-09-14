import {Component, Input, OnInit} from '@angular/core';
import {Interview} from "../../Domain/interview";
import {AuthService} from "../../Services/auth.service";
import {User} from "../../Domain/user";
import {AuthUser} from "../../Domain/auth-user";
import {filter} from "rxjs/internal/operators";

@Component({
  selector: 't-interview-item',
  templateUrl: './interview-item.component.html',
  styleUrls: ['./interview-item.component.css']
})
export class InterviewItemComponent implements OnInit {
  @Input()
  public interview: Interview;
  public user: User;

  constructor(private _authService: AuthService) {
  }

  ngOnInit() {
    this._authService.onChange().pipe(filter((it: AuthUser) => it.isAuth === 'true')).subscribe(it => {
      this.user = it.user;
    })
  }
}
