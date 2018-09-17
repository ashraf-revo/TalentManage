import {Agency} from "./Agency";
import {Person} from "./Person";

export class Interview {
  id: string;
  createdDate: string;
  agency: Agency=new Agency();
  person: Person=new Person();
  interviewDate: string;
  createdBy: number;
}
