import {Score} from "./score.model";
import {Note} from "./note.model";

export interface User {
  id?: number;
  name: string;
  passwordHash: string;
  degree: string;
  nickname: string;
  email: string;
  number: string;
  notes: Note[];
  roles: string[];
  authdata?:string;
  scores: Score[];
  media: number;
  image: boolean;
}
