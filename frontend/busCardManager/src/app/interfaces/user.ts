import { Card } from "./card";

export interface User {
  id?: number;
  name: string;
  email: string;
  password: string;
  cards?: Card[];
}
