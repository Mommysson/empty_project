CREATE TABLE IF NOT EXISTS Organizations (
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
COMMENT ON TABLE Organizations IS 'Компании';

CREATE TABLE IF NOT EXISTS Offices (
    id         INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    name       VARCHAR(255) NOT NULL  COMMENT 'Наименование',
    orgId      INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор компании'
    address    VARCHAR(255) NOT NULL  COMMENT 'Адрес',
    phone      INTEGER                COMMENT 'Телефон',
    isActive   BIT                    COMMENT 'Активен'
);
COMMENT ON TABLE Offices IS 'Офисы';
ALTER TABLE Offices ADD FOREIGN KEY (orgId) REFERENCES Organizations(id);
CREATE INDEX Offices_Of_Organizations ON Offices(orgId);

CREATE TABLE IF NOT EXISTS Users (
    id              INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version         INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    firstName       VARCHAR(255) NOT NULL  COMMENT 'Имя',
    lastName        VARCHAR(255)           COMMENT 'Фамилия',
    middleName      VARCHAR(255)           COMMENT 'Отчество',
    officeId        INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор офиса'
    jobTitle        VARCHAR(255) NOT NULL  COMMENT 'Должность',
    address         VARCHAR(255)           COMMENT 'Место жительства',
    phone           INTEGER                COMMENT 'Телефон',
    isIdentified    BIT                    COMMENT 'Идентифицирован'
    docId           INTEGER                COMMENT 'Уникальный идентификатор документа'
    citizenshipCode INTEGER                COMMENT 'Код гражданства'
);
COMMENT ON TABLE Users IS 'Пользователи';
ALTER TABLE Users ADD FOREIGN KEY (officeId) REFERENCES Offices(id);
CREATE INDEX Users_Of_Offices ON Users(officeId);
ALTER TABLE Users ADD FOREIGN KEY (docId) REFERENCES Users_documents(id);
CREATE INDEX User_Document ON Users(docId);
ALTER TABLE Users ADD FOREIGN KEY (citizenshipCode) REFERENCES Countries(code);
CREATE INDEX User_Citizenship ON Users(citizenshipCode);

CREATE TABLE IF NOT EXISTS Users_documents (
    id              INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version         INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    userId          INTEGER      NOT NULL  COMMENT 'Уникальный идентификатор пользователя',
    docCode         INTEGER      NOT NULL  COMMENT 'Код документа',
    docNumber       INTEGER                COMMENT 'Номер документа'
    docDate         DATE                   COMMENT 'Дата выдачи документа'
);
COMMENT ON TABLE Users_documents IS 'Документы пользователей';
ALTER TABLE Users_documents ADD FOREIGN KEY (docCode) REFERENCES Document_Types(code);
ALTER TABLE Users_documents ADD FOREIGN KEY (userId) REFERENCES Users(id);
CREATE INDEX Type_Of_Document ON Users_documents (docCode);
CREATE INDEX User_Of_Document ON Users_documents (userId);

CREATE TABLE IF NOT EXISTS Document_Types (
    name            VARCHAR(255) NOT NULL  COMMENT 'Название документа',
    code            INTEGER      NOT NULL  COMMENT 'Код документа'
);
COMMENT ON TABLE Document_Types IS 'Типы документов';

CREATE TABLE IF NOT EXISTS Countries (
    name            VARCHAR(255) NOT NULL  COMMENT 'Название страны',
    code            INTEGER      NOT NULL  COMMENT 'Код страны'
);
СOMMENT ON TABLE Countries IS 'Страны';


