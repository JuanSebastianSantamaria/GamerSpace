import { Purchase } from "./purchase";
import { PurchasesCar } from "./purchases-car";
import { Rol } from "./rol";
import { User } from "./user";

export class Customer extends User{
    constructor(
        public userId: number,
        public fullname: string,
        public username: string,
        public password: string,
        public email: string,
        public phoneNumber: number,
        public rol: Rol
    ) {
        super(userId, fullname, username, password, email, phoneNumber, rol);
    }
}
