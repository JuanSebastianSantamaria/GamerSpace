import { Rol } from "./rol";

export class User {
    constructor(
        public userId: number,
        public fullname: string,
        public username: string,
        public password: string,
        public email: string,
        public phoneNumber: number,
        public rol: Rol
    ) {}
}