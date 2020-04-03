import {Subject} from "./subject.model";
import {User} from "./user.model";
import {Score} from "./score.model";

export interface Note {
  id?: number;
  name: string;
  professor: string;
  subject: Subject;
  user: User;
  scores: Score[];

}
