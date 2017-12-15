-- Создание базы данных платежных поручений
CREATE DATABASE payment_order
  -- Выбор кодировки
  CHARACTER SET utf8;

USE payment_order;

-- Таблица банков
CREATE TABLE banks (
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
CREATE TABLE clients (

  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор записи',

  name    VARCHAR(255) NOT NULL
  COMMENT 'Наименование организации',

  account NUMERIC(20) UNSIGNED NOT NULL UNIQUE
  COMMENT 'Счет организации',
  inn     NUMERIC(10) UNSIGNED UNIQUE
  COMMENT 'ИНН организации',
  kpp     INT UNSIGNED
  COMMENT 'КПП организации',
  version INT      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  bank_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор банка',
  FOREIGN KEY (bank_id) REFERENCES banks (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);

-- Таблица параметров платежных поручений
CREATE TABLE orders (

  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор записи',
  number  NUMERIC(38) UNSIGNED NOT NULL UNIQUE
  COMMENT 'Номер платежного поручения',
  dates   DATE         NOT NULL
  COMMENT 'Дата создания платежного поручения',
  amount  NUMERIC(20) UNSIGNED NOT NULL
  COMMENT 'Сумма платежа',
  version INT     NOT NULL
  COMMENT 'Служебное поле Hibernate'
);

-- Таблица платежных поручений
CREATE TABLE payment_orders (

  id           INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор записи',
  id_payer     INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор плательщика',
  id_recipient INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор получателя',
  version      INT      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  FOREIGN KEY (id_payer) REFERENCES clients (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (id_recipient) REFERENCES clients (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);


CREATE TABLE transaction_order (
  id_orders         INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор платежных поручений',
  id_payment_orders INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор параметров платежных поручений',
  version      INT      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  FOREIGN KEY (id_orders) REFERENCES orders (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (id_payment_orders) REFERENCES payment_orders (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE INDEX bank_bik
  ON banks (bik);

CREATE INDEX bank_name
  ON banks (name);

CREATE INDEX client_account
  ON clients (account);

CREATE INDEX client_inn
  ON clients (inn);

CREATE INDEX orders_number
  ON orders (number);















