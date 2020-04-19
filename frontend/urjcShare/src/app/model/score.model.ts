import {User} from "./user.model";
import {Note} from "./note.model";

export interface Score {
  id?: number;
  score: number;
  user: User;
  note: Note;

}
