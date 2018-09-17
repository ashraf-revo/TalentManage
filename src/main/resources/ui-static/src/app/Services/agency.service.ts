import {Injectable} from '@angular/core';
import {Observable} from "rxjs/index";
import {Agency} from "../Domain/Agency";
import {HttpClient} from "@angular/common/http";
import {DefaultService} from "./default.service";
import {Interview} from "../Domain/interview";

@Injectable({
  providedIn: 'root'
})
export class AgencyService {

  private url = '/api/agency';

  constructor(private _http: HttpClient, private _defaultService: DefaultService) {
    this.url = this._defaultService.url + this.url;
  }


  save(agency: Agency): Observable<Object> {
    return this._http.post(this.url, agency);
  }

  profile(it: string): Observable<Agency> {
    return this._http.get<Agency>(this.url + "/profile/" + it)
  }

  saveInterview(interview: Interview): Observable<any> {
    return this._http.post(this.url + "/interview", interview);
  }

}
