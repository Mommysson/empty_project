CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    name       VARCHAR(255) NOT NULL  COMMENT 'Наименование',
    full_Name  VARCHAR(255) NOT NULL  COMMENT 'Полное наименование',
    inn        INTEGER      NOT NULL  COMMENT 'ИНН',
    kpp        INTEGER      NOT NULL  COMMENT 'КПП',
    address    VARCHAR(255) NOT NULL  COMMENT 'Адрес',
    phone      INTEGER                COMMENT 'Телефон',
    is_Active  BIT                    COMMENT 'Активен'
);
COMMENT ON TABLE Organization IS 'Компания';

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    name       VARCHAR(255) NOT NULL  COMMENT 'Наименование',
    org_Id     INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор компании'
    address    VARCHAR(255) NOT NULL  COMMENT 'Адрес',
    phone      INTEGER                COMMENT 'Телефон',
    is_Active  BIT                    COMMENT 'Активен'
);
COMMENT ON TABLE Office IS 'Офис';
ALTER TABLE Office ADD FOREIGN KEY (org_Id) REFERENCES Organization(id);
CREATE INDEX Office_Of_Organization ON Office(org_Id);



