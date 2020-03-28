
export interface User {
  id?: number;
  name: string;
  passwordHash: string;
  degree: string;
  nickname: string;
  email: string;
  number: string;
  roles: string[];
}
