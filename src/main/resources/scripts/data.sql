USE payment_order;

INSERT INTO bank (name, bik, account, version) VALUES ('ГРКЦ ГУ Банка России по Челябинской обл. Г. Челябинск',
                                                        047501001,40101810400000010801, 0);
INSERT INTO bank (name, bik, account, version) VALUES ('КБ "Промсвязьбанк" г.Москва', 044525662,
                                                      30101810500000000662, 0);
INSERT INTO bank (name, bik, account, version) VALUES ('СБ "Сбербанк России ОАО" г.Москва', 040173709,
                                                      30101810600000000709, 0);
INSERT INTO bank (name, bik, account, version) VALUES ('Отделение Челябинск Г. Челябинск', 047561001,
                                                        40101810400000010802, 0);
INSERT INTO bank (name, bik, account, version) VALUES ('ГРКЦ ГУ Банка России по Воронежской области г. Воронеж',
                                                    042007001,40101810500000010004, 0);



INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ООО "Рассвет"',
                                                                        30101910500000000811, 7505005550, 750501001, 0,
                                                                        1);
INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ЗАО "Фрегат"',
                                                                        40702810800282001552, 7743018754, 774301001, 0,
                                                                        2);
INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ООО "Глобус"',
                                                                        40702810929000000293, 7725110052, 772501001, 0,
                                                                        3);
INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ИП Жукова Людмила Павловна',
                                                                        40702810500020000129, 2628041972, NULL, 0, 4);
INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ООО "Банкирша"',
                                                                        40800123456700000034, 7712345678, 0, 0, 5);
INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ООО "Торговая фирма "Гермес""',
                                                                        40702810400000001111, 7708123456, 770801001, 0,
                                                                        2);
INSERT INTO client (name, account, inn, kpp, version, bank_id) VALUES ('ООО "Альфа"',
                                                                        40702810400000002222, 7708199771, 770902002, 0,
                                                                        4);


INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (481, '02.04.2014', 68678,1, 2,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (59, '09.10.02', 64900,2,3,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (84, '12-07-16', 35000,3,4,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (74, '16-04-05', 4406,4,5,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (65, '09-10-12', 5687,5,6,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (250, '13-12-15', 25000,6,7,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (11, '07-07-02', 550,7,1,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (1, '14-05-19', 4332,1,2,0);
INSERT INTO payment_order (number, payment_order_date, amount, id_payer, id_recipient, version) VALUES (215, '17-09-06', 39000,2,3,0);
















