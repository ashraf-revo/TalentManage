import {Agency} from "./Agency";
import {Person} from "./Person";

export class Interview {
  id: string;
  createdDate: string;
  agency: Agency;
  person: Person;
  interviewDate: string;
  interViewState: string;
  createdBy: number;
}
