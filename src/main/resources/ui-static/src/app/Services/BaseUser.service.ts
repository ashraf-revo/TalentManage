import {Injectable} from '@angular/core';
import {Interview} from "../Domain/interview";
import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";
import {DefaultService} from "./default.service";

@Injectable({
  providedIn: 'root'
})
export class BaseUserService {
  private url = '';

  constructor(private _http: HttpClient, private _defaultService: DefaultService) {
    this.url = this._defaultService.url + this.url;
  }

  interviews(): Observable<Interview[]> {
    return this._http.get<Interview[]>('/api' + "/interviews");

  }
}
