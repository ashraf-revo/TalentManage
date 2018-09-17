import {Injectable} from '@angular/core';
import {Person} from "../Domain/Person";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {DefaultService} from "./default.service";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private url = '/api/person';

  constructor(private _http: HttpClient, private _defaultService: DefaultService) {
    this.url = this._defaultService.url + this.url;
  }


  save(person: Person): Observable<Object> {
    return this._http.post(this.url, person);
  }

  profile(it: string): Observable<Person> {
    return this._http.get<Person>(this.url + "/profile/" + it)
  }

  persons(): Observable<Person[]> {
    return this._http.get<Person[]>(this.url + "s");
  }

  skills(): Observable<string[]> {
    return this._http.get<string[]>(this.url + "/skills");
  }
}
