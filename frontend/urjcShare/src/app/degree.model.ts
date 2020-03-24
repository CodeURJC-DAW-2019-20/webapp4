import {Subject} from "./subject.model";

export interface Degree {
  id?: number;
  name: string;
  subjects: Subject[];
}
