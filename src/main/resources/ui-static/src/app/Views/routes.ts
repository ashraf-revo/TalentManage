import {Routes} from "@angular/router";
import {BaseComponent} from "./base/base.component";
import {BaseInComponent} from "./base-in/base-in.component";
import {BaseOutComponent} from "./base-out/base-out.component";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {HomeComponent} from "./home/home.component";
import {ProfileComponent} from "./profile/profile.component";
import {AccountEditComponent} from "./account-edit/account-edit.component";
import {PersonsComponent} from "./persons/persons.component";


export const routes: Routes = [
  {
    path: '', component: BaseComponent, children: [
      {
        path: '', component: BaseOutComponent, children: [
          {path: '', component: LoginComponent},
          {path: 'login', component: LoginComponent},
          {path: 'signup', component: SignupComponent}
        ]
      }, {
        path: '', component: BaseInComponent, children: [
          {path: 'home', component: HomeComponent},
          {path: 'persons', component: PersonsComponent},
          {path: 'profile/:id', component: ProfileComponent},
          {path: 'account/edit', component: AccountEditComponent},
        ]
      }, {path: '**', redirectTo: ''}]
  },
];
