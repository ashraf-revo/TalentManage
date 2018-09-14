import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './Views/home/home.component';
import {LoginComponent} from './Views/login/login.component';
import {RouterModule} from '@angular/router';
import {routes} from './Views/routes';
import {BaseComponent} from './Views/base/base.component';
import {DashBoardComponent} from './Views/dash-board/dash-board.component';
import {DefaultService} from './Services/default.service';
import {AuthService} from './Services/auth.service';
import {UserService} from './Services/user.service';
import {HttpClientModule, HttpClientXsrfModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {BaseInComponent} from './Views/base-in/base-in.component';
import {BaseOutComponent} from './Views/base-out/base-out.component';
import {SignupComponent} from './Views/signup/signup.component';
import {ProfileComponent} from './Views/profile/profile.component';
import {AccountEditComponent} from './Views/account-edit/account-edit.component';
import {NavComponent} from './Component/nav/nav.component';
import {InterviewItemComponent} from './Component/interview-item/interview-item.component';
import {MomentModule} from "angular2-moment";
import {BaseUserService} from "./Services/BaseUser.service";
import {PersonService} from "./Services/person.service";
import {AgencyService} from "./Services/agency.service";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    BaseComponent,
    DashBoardComponent,
    BaseInComponent,
    BaseOutComponent,
    SignupComponent,
    ProfileComponent,
    AccountEditComponent,
    NavComponent,
    InterviewItemComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, MomentModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'X-CSRF-TOKEN',
      headerName: 'X-CSRF-TOKEN',
    }),
    FormsModule, RouterModule.forRoot(routes)
  ],
  providers: [DefaultService, AuthService, UserService, BaseUserService,PersonService,AgencyService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
