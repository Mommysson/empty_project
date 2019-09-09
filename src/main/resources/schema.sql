CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    name       VARCHAR(255) NOT NULL  COMMENT 'Наименование',
    fullName   VARCHAR(255) NOT NULL  COMMENT 'Полное наименование',
    inn        INTEGER      NOT NULL  COMMENT 'ИНН',
    kpp        INTEGER      NOT NULL  COMMENT 'КПП',
    address    VARCHAR(255) NOT NULL  COMMENT 'Адрес',
    phone      INTEGER                COMMENT 'Телефон',
    isActive   BIT                    COMMENT 'Активен'
);
COMMENT ON TABLE Organization IS 'Компания';

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    name       VARCHAR(255) NOT NULL  COMMENT 'Наименование',
    orgId      INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор компании'
    address    VARCHAR(255) NOT NULL  COMMENT 'Адрес',
    phone      INTEGER                COMMENT 'Телефон',
    isActive   BIT                    COMMENT 'Активен'
);
COMMENT ON TABLE Office IS 'Офис';
ALTER TABLE Office ADD FOREIGN KEY (Organization) REFERENCES orgId(id);

CREATE TABLE IF NOT EXISTS User (
    id              INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version         INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    firstName       VARCHAR(255) NOT NULL  COMMENT 'Имя',
    lastName        VARCHAR(255) NOT NULL  COMMENT 'Фамилия',
    middleName      VARCHAR(255)           COMMENT 'Отчество',
    officeId        INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор офиса'
    jobTitle        VARCHAR(255) NOT NULL  COMMENT 'Должность',
    address         VARCHAR(255)           COMMENT 'Место жительства',
    phone           INTEGER                COMMENT 'Телефон',
    isIdentified    BIT                    COMMENT 'Идентифицирован'
    docName         VARCHAR(255)           COMMENT 'Документ',
    citizenshipName VARCHAR(255)           COMMENT 'Гражданство',
    docCode         INTEGER                COMMENT 'Код документа'
    docNumber       INTEGER                COMMENT 'Номер документа'
    docDate         DATE                   COMMENT 'Дата выдачи документа'
    citizenshipCode INTEGER                COMMENT 'Код гражданства'
);
COMMENT ON TABLE User IS 'Сотрудник';
ALTER TABLE User ADD FOREIGN KEY (Office) REFERENCES officeId(id);
ALTER TABLE User ADD FOREIGN KEY (Docs) REFERENCES docCode(code);
ALTER TABLE User ADD FOREIGN KEY (Docs) REFERENCES docName(name);
ALTER TABLE User ADD FOREIGN KEY (Countries) REFERENCES citizenshipName(name);
ALTER TABLE User ADD FOREIGN KEY (Countries) REFERENCES citizenshipCode(code);


CREATE TABLE IF NOT EXISTS Docs (
    name            VARCHAR(255) NOT NULL  COMMENT 'Название документа',
    code            INTEGER      NOT NULL  COMMENT 'Код документа'
);
COMMENT ON TABLE Docs IS 'Документы';

CREATE TABLE IF NOT EXISTS Countries (
    name            VARCHAR(255) NOT NULL  COMMENT 'Название страны',
    code            INTEGER      NOT NULL  COMMENT 'Код страны'
);
СOMMENT ON TABLE Countries IS 'Страны';