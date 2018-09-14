import {User} from "./user";
import {Addresses} from "./Addresses";

export class Agency extends User {
  agencyName: string;
  website: string;
  addresses: Addresses = new Addresses();
}
