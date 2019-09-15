INSERT INTO Organizations (id, version, name, fullName, inn, kpp, address,  phone, isActive) VALUES (
1, 0, 'A','Aa',11,111,'Moscow',123,1);
INSERT INTO Organizations (id, version, name, fullName, inn, kpp, address,  phone, isActive) VALUES (
2, 0, 'B','Bb',22,222,'Tula',124,1);
INSERT INTO Organizations (id, version, name, fullName, inn, kpp, address,  phone, isActive) VALUES (
3, 0, 'C','Cc',33,333,'Chekhov',125,1);

INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
1, 0,'Ab',1, 'Moscow',126,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
2, 0,'Ac',1, 'Moscow',127,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
3, 0,'Ad',1, 'Moscow',128,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
4, 0,'Bb',2, 'Tula',129,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
5, 0,'Bc',2, 'Tula',130,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
6, 0,'Bd',2, 'Tula',131,1);
INSERT INTO Office (id, version, name, orgId, address,  phone, isActive) VALUES (
7, 0,'Cb',3, 'Chekhov',132,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
8, 0,'Cc',3, 'Chekhov',133,1);
INSERT INTO Offices (id, version, name, orgId, address,  phone, isActive) VALUES (
9, 0,'Cd',3, 'Chekhov',134,1);


INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,
docId, citizenshipCode) VALUES (
1, 0,'Aaa1','Bbb1','Ccc1',1,'Boss','Moscow',135,1,1,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
2, 0,'Aaa2','Bbb2','Ccc2',1,'Manager','Moscow',136,0,2,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
3, 0,'Ddd1','Eee1','Fff1',2,'Boss','Moscow',137,1,3,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
4, 0,'Ddd2','Eee2','Fff2',2,'Manager','Moscow',138,0,4,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
5, 0,'Ggg1','Hhh1','Iii1',3,'Boss','Moscow',139,0,5,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
6, 0,'Ggg2','Hhh2','Iii2',3,'Manager','Moscow',140,1,6,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
7, 0,'Jjj1','Kkk1','Lll1',4,'Boss','Tula',141,0,7,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
8, 0,'Jjj2','Kkk2','Lll2',4,'Manager','Tula',142,1,8,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
9, 0,'Mmm1','Nnn1','Ooo1',5,'Boss','Tula',143,1,9,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
10, 0,'Mmm2','Nnn2','Ooo2',5,'Manager','Tula',144,0,10,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
11, 0,'Ppp1','Qqq1','Rrr1',6,'Boss','Tula',145,1,11,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
12, 0,'Ppp2','Qqq2','Rrr2',6,'Manager','Tula',146,0,12,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
13, 0,'Sss1','Ttt1','Uuu1',7,'Boss','Chekhov',147,0,13,643));
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
14, 0,'Sss2','Ttt2','Uuu2',7,'Manager','Chekhov',148,1,14,643));
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
15, 0,'Vvv1','Www1',NULL,8,'Boss','Chekhov',149,0,15,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
16, 0,'Vvv2','Www2',NULL,8,'Manager','Chekhov',150,1,16,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
17, 0,'Xxx1','Yyy1','Zzz1',9,'Boss','Chekhov',151,1,17,643);
INSERT INTO Users (id, version, firstName, lastName, middleName,officeId, jobTitle, address,  phone, isIdentified,docId,
citizenshipCode) VALUES (
18, 0,'Xxx2','Yyy2','Zzz2',9,'Manager','Chekhov',152,1,18,643);

INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
1,0,1,21,123456,2019-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
2,0,2,21,123457,2019-07-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
3,0,3,21,123458,2019-05-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
4,0,4,21,123459,2019-03-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
5,0,5,21,223456,2019-01-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
6,0,6,21,323456,2018-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
7,0,7,21,423456,2017-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
8,0,8,21,523456,2016-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
9,0,9,21,623456,2015-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
10,0,10,21,723456,2014-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
11,0,11,21,823456,2013-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
12,0,12,21,923456,2012-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
13,0,13,21,113456,2011-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
14,0,14,21,133456,2010-08-31);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
15,0,15,21,143456,2019-08-30);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
16,0,16,21,153456,2019-08-29);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
17,0,17,21,163456,2019-08-28);
INSERT INTO Users_Documents (id, version, userId, docCode, docNumber, docDate) VALUES (
18,0,18,21,173456,2019-08-27);

INSERT INTO Document_Types (name, code) VALUES ('Свидетельство о рождении',03);
INSERT INTO Document_Types (name, code) VALUES ('Военный билет',07);
INSERT INTO Document_Types (name, code) VALUES ('Временное удостоверение, выданное взамен военного билета',08);
INSERT INTO Document_Types (name, code) VALUES ('Паспорт иностранного гражданина',10);
INSERT INTO Document_Types (name, code) VALUES (
  'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу',11);
INSERT INTO Document_Types (name, code) VALUES  ('Вид на жительство в Российской Федерации',12);
INSERT INTO Document_Types (name, code) VALUES ('Удостоверение беженца',13);
INSERT INTO Document_Types (name, code) VALUES ('Разрешение на временное проживание в Российской Федерации',15);
INSERT INTO Document_Types (name, code) VALUES (
'Свидетельство о предоставлении временного убежища на территории Российской Федерации',18);
INSERT INTO Document_Types (name, code) VALUES ('Паспорт гражданина Российской Федерации',21);
INSERT INTO Document_Types (name, code) VALUES (
'Свидетельство о рождении, выданное уполномоченным органом иностранного государства',23);
INSERT INTO Document_Types (name, code) VALUES ('Удостоверение личности военнослужащего Российской Федерации',24);
INSERT INTO Document_Types (name, code) VALUES ('Иные документы',51);

INSERT INTO Countries (name, code) VALUES ('Российская Федерация',643);




