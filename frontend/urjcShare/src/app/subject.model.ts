import {Degree} from "./degree.model";
import {Note} from "./note.model";

export interface Subject {
  id?: number;
  name: string;
  degree: Degree;
  notes: Note[];
}
