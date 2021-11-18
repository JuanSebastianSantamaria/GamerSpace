insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-1, 'Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-2, 'Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-3, 'Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-4, 'Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-5, 'Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-6, 'Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-7, 'Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-8, 'Snd Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-9, 'Snd Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-10, 'Snd Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-11, 'Snd Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-12, 'Snd Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-13, 'Snd Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-14, 'Snd Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-15, 'Trd Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-16, 'Trd Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-17, 'Trd Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-18, 'Trd Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-19, 'Trd Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-20, 'Trd Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg');
insert into product (product_Id, title, description, price, stock, PHOTO_PATH) values (-21, 'Trd Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png');


insert into rol (rol_Id, rol) values (0, 'admin');
insert into rol (rol_Id, rol) values (1, 'customer');


insert into admin (user_Id, fullname, username, password, email, phone_Number, ROL_ROL_ID) values (0, 'System Adminitrator Name', 'admin', '$2a$10$biWOm2ACVKFEY81iiLX/VutdSEmnjqNv7LWziCcGpqGPIr1NPKDlC', 'admin@gamerspace.com', 0123456789, 0);


insert into customer (user_Id, fullname, username, password, email, phone_Number, ROL_ROL_ID) values (-1, 'David Ruiz', 'david', '$2a$10$biWOm2ACVKFEY81iiLX/VutdSEmnjqNv7LWziCcGpqGPIr1NPKDlC', 'david@gamerspace.com', 1234, 1);
insert into customer (user_Id, fullname, username, password, email, phone_Number, ROL_ROL_ID) values (-2, 'Felipe Cruz', 'felipe', '$2a$10$biWOm2ACVKFEY81iiLX/VutdSEmnjqNv7LWziCcGpqGPIr1NPKDlC', 'felipe@gamerspace.com', 1234, 1);
insert into customer (user_Id, fullname, username, password, email, phone_Number, ROL_ROL_ID) values (-3, 'Diana Bustos', 'diana', '$2a$10$biWOm2ACVKFEY81iiLX/VutdSEmnjqNv7LWziCcGpqGPIr1NPKDlC', 'diana@gamerspace.com', 1234, 1);


insert into purchase_car (purchase_car_id, customer_user_Id) values (-1, -1);
insert into purchase_car (purchase_car_id, customer_user_Id) values (-2, -2);
insert into purchase_car (purchase_car_id, customer_user_Id) values (-3, -3);


insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-1, TO_DATE('11-10-2021 21:43:31', 'dd-mm-yyyy hh:mm:ss') , 11, 890000, -1);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-2, TO_DATE('27-11-2021 21:43:31', 'dd-mm-yyyy hh:mm:ss'), 1, 520000, -1);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-3, TO_DATE('20-09-2021 17:43:31', 'dd-mm-yyyy hh:mm:ss'), 7, 253000, -1);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-4, TO_DATE('13-02-2021 22:43:31', 'dd-mm-yyyy hh:mm:ss'), 4, 20000, -1);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-5, TO_DATE('08-01-2021 10:43:31', 'dd-mm-yyyy hh:mm:ss'), 1, 30000, -1);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-6, TO_DATE('02-05-2021 12:43:31', 'dd-mm-yyyy hh:mm:ss'), 3, 45000, -1);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-7, TO_DATE('11-10-2021 21:43:31', 'dd-mm-yyyy hh:mm:ss') , 11, 890000, -3);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-8, TO_DATE('27-11-2021 21:43:31', 'dd-mm-yyyy hh:mm:ss'), 1, 520000, -3);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-9, TO_DATE('20-09-2021 17:43:31', 'dd-mm-yyyy hh:mm:ss'), 7, 253000, -3);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-10, TO_DATE('13-02-2021 22:43:31', 'dd-mm-yyyy hh:mm:ss'), 4, 20000, -3);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-11, TO_DATE('08-01-2021 10:43:31', 'dd-mm-yyyy hh:mm:ss'), 1, 30000, -3);
insert into purchase (purchase_Id, date, quantity, total, customer_user_Id) values (-12, TO_DATE('02-05-2021 12:43:31', 'dd-mm-yyyy hh:mm:ss'), 3, 45000, -3);

insert into product_purchase (product_id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-1, 'Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg', -1, 8, 640000, -1);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-2, 'Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg', -2, 2, 100000, -1);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-3, 'Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png', -3, 1, 150000, -1);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-4, 'Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png', -4, 1, 520000, -2);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-5, 'Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png', -5, 4, 88000, -3);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-6, 'Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg', -6, 2, 90000, -3);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-7, 'Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png', -7, 1, 75000, -3);

insert into product_purchase (product_id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-8, 'Snd Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg', -8, 8, 640000, -4);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-9, 'Snd Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg', -9, 2, 100000, -4);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-10, 'Snd Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png', -10, 1, 150000, -4);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-11, 'Snd Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png', -11, 1, 520000, -5);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-12, 'Snd Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png', -12, 4, 88000, -6);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-13, 'Snd Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg', -13, 2, 90000, -6);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-14, 'Snd Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png', -14, 1, 75000, -6);

insert into product_purchase (product_id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-15, 'Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg', -1, 8, 640000, -7);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-16, 'Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg', -2, 2, 100000, -7);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-17, 'Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png', -3, 1, 150000, -7);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-18, 'Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png', -4, 1, 520000, -8);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-19, 'Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png', -5, 4, 88000, -9);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-20, 'Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg', -6, 2, 90000, -9);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-21, 'Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png', -7, 1, 75000, -9);

insert into product_purchase (product_id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-22, 'Snd Headphones', 'This is the headphones description', 80000, 15, 'https://i.imgur.com/5SBKmJg.jpg', -8, 8, 640000, -10);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-23, 'Snd Mouse', 'This is the mouse description', 50000, 20, 'https://i.imgur.com/8t85adi.jpg', -9, 2, 100000, -10);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-24, 'Snd Keyboard', 'This is the keyboard description', 150000, 30, 'https://i.imgur.com/aMxT1hH.png', -10, 1, 150000, -10);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-25, 'Snd Chair', 'This is the chair description', 520000, 10, 'https://i.imgur.com/iA1k0Da.png', -11, 1, 520000, -11);

insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-26, 'Snd Pad Mouse', 'This is the pad mouse description', 22000, 50, 'https://i.imgur.com/ucFDLgV.png', -12, 4, 88000, -12);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-27, 'Snd Microphone', 'This is the microphone description', 45000, 25, 'https://i.imgur.com/KCQg3U7.jpg', -13, 2, 90000, -12);
insert into product_purchase (product_Id, title, description, price, stock, photo_path, original_id, quantity, total, purchase_purchase_id) values (-28, 'Snd Desk', 'This is the desk description', 75000, 8, 'https://i.imgur.com/ZpsnLWs.png', -14, 1, 75000, -12);