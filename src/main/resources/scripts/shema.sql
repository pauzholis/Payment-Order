

-- Таблица банков
CREATE TABLE bank (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор записи',
  name    VARCHAR(255) NOT NULL
  COMMENT 'Наименование банка',
  bik     BIGINT UNSIGNED UNIQUE
  COMMENT 'БИК банка',
  account NUMERIC(20) UNSIGNED NOT NULL UNIQUE
  COMMENT 'Номер счета банка',
  version INT      NOT NULL
  COMMENT 'Служебное поле Hibernate'

);

-- Таблица клиентов (Плательщик/Получатель)
CREATE TABLE client (

  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор записи',

  name    VARCHAR(255) NOT NULL
  COMMENT 'Наименование организации',

  account NUMERIC(20) UNSIGNED NOT NULL UNIQUE
  COMMENT 'Счет организации',
  inn     NUMERIC(10) UNSIGNED UNIQUE
  COMMENT 'ИНН организации',
  kpp     NUMERIC(9) UNSIGNED
  COMMENT 'КПП организации',
  version INT      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  bank_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор банка',
  FOREIGN KEY (bank_id) REFERENCES bank (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);


-- Таблица платежных поручений
CREATE TABLE payment_order (

  id           INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор записи',
  number  NUMERIC(38) UNSIGNED NOT NULL UNIQUE
  COMMENT 'Номер платежного поручения',
  payment_order_date   DATE         NOT NULL
  COMMENT 'Дата создания платежного поручения',
  amount  NUMERIC(20) UNSIGNED NOT NULL
  COMMENT 'Сумма платежа',
  id_payer     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор плательщика',
  id_recipient INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор получателя',
  version      INT      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  FOREIGN KEY (id_payer) REFERENCES client (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (id_recipient) REFERENCES client (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);




CREATE INDEX bank_bik
  ON bank (bik);

CREATE INDEX bank_name
  ON bank (name);

CREATE INDEX client_account
  ON client (account);

CREATE INDEX client_inn
  ON client (inn);

CREATE INDEX orders_number
  ON payment_order (number);

  CREATE INDEX bank_id
  ON bank (id);

  CREATE INDEX id_payer
  ON client (id);

















