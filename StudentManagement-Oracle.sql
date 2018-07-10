--ѧ����¼
create table log_stu(
       usercode varchar2(20) primary key,
       pwd varchar2(20)
)

insert into log_stu values('s001','0001')
insert into log_stu values('s002','0002')
insert into log_stu values('s003','0003')
select * from log_stu

--��ʦ��¼
create table log_tea(
       usercode varchar2(20) primary key,
       pwd varchar2(20)
)
insert into log_tea values('t001','0001')
insert into log_tea values('t002','0002')
insert into log_tea values('t003','0003')
select * from log_tea

--����Ա��¼
create table log_root(
       usercode varchar2(20) primary key,
       pwd varchar2(20)  
)
insert into log_root values('r001','0001')
select * from log_root

--ѧ��������Ϣ
create table stu_info(
       stu_id varchar2(20) primary key,
       stu_name varchar2(20),
       sex varchar2(4),
       birth varchar2(20),
       province varchar2(20),
       city varchar2(20),
       address varchar2(100),
       college varchar2(20),
       major varchar2(20),
       grade varchar2(20),
       stu_class varchar2(20)
)

--�ɼ���Ϣ
create table stu_score(
       stu_id varchar2(20),
       stu_name varchar2(20),
       course_id varchar2(20),
       course_name varchar2(20),
       score number(5),
       constraint stu_score primary key(stu_id,course_id)
)

--�γ���Ϣ
create table stu_course(
       course_id varchar2(20),
       course_name varchar2(20),
       course_date varchar2(100),
       teacher_id varchar2(20),
       teacher_name varchar2(20),
       classroom varchar2(20),
       stu_id varchar2(20),
       stu_major varchar2(20)
)

--��ʦ������Ϣ
create table tea_info(
       teacher_id varchar2(20) primary key,
       teacher_name varchar2(20),
       sex varchar2(20),
       birth varchar2(20),
       province varchar2(20),
       city varchar2(20),
       address varchar2(100),
       college varchar2(20),
       major varchar2(20)
)

--��ʦ�γ���Ϣ
create table tea_course(
       course_id varchar2(20),
       course_name varchar2(50),
       course_date varchar2(100),
       teacher_id varchar2(20),
       teacher_name varchar2(20),
       classroom varchar2(20),
       stu_major varchar2(20)
)

--�����
create table notice(
       title varchar2(50),
       notice_date varchar2(20),
       txt varchar2(1000)
)



---ʡ�ݽ���

create table hat_province (

sid number(11) primary key,

provinceid varchar2(6),

province varchar2(40)

)
select * from hat_province
---��������
insert into hat_province values (1,'110000','������');

INSERT INTO hat_province VALUES (2,'120000','�����');

INSERT INTO hat_province VALUES (3,'130000','�ӱ�ʡ');

INSERT INTO hat_province VALUES (4,'140000','ɽ��ʡ');

INSERT INTO hat_province VALUES (5,'150000','���ɹ�������');

INSERT INTO hat_province VALUES (6,'210000','����ʡ');

INSERT INTO hat_province VALUES (7,'220000','����ʡ');

INSERT INTO hat_province VALUES (8,'230000','������ʡ'); 
INSERT INTO hat_province VALUES (9,'310000','�Ϻ���');

INSERT INTO hat_province VALUES (10,'320000','����ʡ');

INSERT INTO hat_province VALUES (11,'330000','�㽭ʡ');

INSERT INTO hat_province VALUES (12,'340000','����ʡ'); 

INSERT INTO hat_province VALUES (13,'350000','����ʡ');

INSERT INTO hat_province VALUES (14,'360000','����ʡ');

INSERT INTO hat_province VALUES (15,'370000','ɽ��ʡ');

INSERT INTO hat_province VALUES (16,'410000','����ʡ');

INSERT INTO hat_province VALUES (17,'420000','����ʡ');

INSERT INTO hat_province VALUES (18,'430000','����ʡ');

INSERT INTO hat_province VALUES (19,'440000','�㶫ʡ');

INSERT INTO hat_province VALUES (20,'450000','����׳��������');

INSERT INTO hat_province VALUES (21,'460000','����ʡ');

INSERT INTO hat_province VALUES (22,'500000','������');

INSERT INTO hat_province VALUES (23,'510000','�Ĵ�ʡ');

INSERT INTO hat_province VALUES (24,'520000','����ʡ');

INSERT INTO hat_province VALUES (25,'530000','����ʡ');

INSERT INTO hat_province VALUES (26,'540000','����������');

INSERT INTO hat_province VALUES (27,'610000','����ʡ');

INSERT INTO hat_province VALUES (28,'620000','����ʡ');

INSERT INTO hat_province VALUES (29,'630000','�ຣʡ');

INSERT INTO hat_province VALUES (30,'640000','���Ļ���������');

INSERT INTO hat_province VALUES (31,'650000','�½�ά���������');

INSERT INTO hat_province VALUES (32,'710000','̨��ʡ');

INSERT INTO hat_province VALUES (33,'810000','����ر�������');

INSERT INTO hat_province VALUES (34,'820000','�����ر�������'); 


--���н���
CREATE TABLE hat_city (

cid number(11) primary key ,

city varchar2(50),

father varchar2(6)

)

select * from hat_city
--��������
insert into hat_city values (1,'������','110000');
insert into hat_city values (2,'������','110000');
insert into hat_city values (3,'������','110000');
 insert into hat_city values (4,'��̨��','110000');
 insert into hat_city values (5,'ʯ��ɽ��','110000');
 insert into hat_city values (6,'������','110000');
 insert into hat_city values (7,'˳����','110000');
 insert into hat_city values (8,'ͨ����','110000');
 insert into hat_city values (9,'������','110000');
 insert into hat_city values (10,'��ɽ��','110000');
 insert into hat_city values (11,'��ͷ����','110000');
 insert into hat_city values (12,'��ƽ��','110000');
 insert into hat_city values (13,'ƽ����','110000');
 insert into hat_city values (14,'������','110000');
 insert into hat_city values (15,'������','110000');
 insert into hat_city values (16,'������','110000');
 
  insert into hat_city values (17,'��ƽ��','120000');
  insert into hat_city values (18,'�Ӷ���','120000');
  insert into hat_city values (19,'������','120000');
  insert into hat_city values (20,'�Ͽ���','120000');
  insert into hat_city values (21,'�ӱ���','120000');
  insert into hat_city values (22,'������','120000');
  insert into hat_city values (23,'��������','120000');
  insert into hat_city values (24,'������','120000');
  insert into hat_city values (25,'������','120000');
  insert into hat_city values (26,'������','120000');
  insert into hat_city values (27,'������','120000');
  insert into hat_city values (28,'������','120000');
  insert into hat_city values (29,'������','120000');
  insert into hat_city values (30,'������','120000');
  insert into hat_city values (31,'������','120000');
  insert into hat_city values (32,'������','120000');
 

  INSERT INTO hat_city VALUES (33,'ʯ��ׯ��','130000');

INSERT INTO hat_city VALUES (34,'��ɽ��','130000');

INSERT INTO hat_city VALUES (35,'�ػʵ���','130000');

INSERT INTO hat_city VALUES (36,'������','130000');

INSERT INTO hat_city VALUES (37,'��̨��','130000');

INSERT INTO hat_city VALUES (38,'������','130000');

INSERT INTO hat_city VALUES (39,'�żҿ���','130000'); 
INSERT INTO hat_city VALUES (40,'�е���','130000');

INSERT INTO hat_city VALUES (41,'������','130000');

INSERT INTO hat_city VALUES (42,'�ȷ���','130000');

INSERT INTO hat_city VALUES (43,'��ˮ��','130000'); 


 
 INSERT INTO hat_city VALUES (44,'̫ԭ��','140000');

INSERT INTO hat_city VALUES (45,'��ͬ��','140000');

INSERT INTO hat_city VALUES (46,'��Ȫ��','140000');

INSERT INTO hat_city VALUES (47,'������','140000');

INSERT INTO hat_city VALUES (48,'������','140000');

INSERT INTO hat_city VALUES (49,'˷����','140000');

INSERT INTO hat_city VALUES (50,'������','140000');

INSERT INTO hat_city VALUES (51,'�˳���','140000'); 
INSERT INTO hat_city VALUES (52,'������','140000');

INSERT INTO hat_city VALUES (53,'�ٷ���','140000');

INSERT INTO hat_city VALUES (54,'������','140000'); 
 


INSERT INTO hat_city VALUES (55,'���ͺ�����','150000');

INSERT INTO hat_city VALUES (56,'��ͷ��','150000');

INSERT INTO hat_city VALUES (57,'�ں���','150000');

INSERT INTO hat_city VALUES (58,'�����','150000');

INSERT INTO hat_city VALUES (59,'ͨ����','150000');

INSERT INTO hat_city VALUES (60,'������˹��','150000');

INSERT INTO hat_city VALUES (61,'���ױ�����','150000'); 
INSERT INTO hat_city VALUES (62,'�����׶���','150000');

INSERT INTO hat_city VALUES (63,'�����첼��','150000');

INSERT INTO hat_city VALUES (64,'�˰���','150000');

INSERT INTO hat_city VALUES (65,'���ֹ�����','150000');

INSERT INTO hat_city VALUES (66,'��������','150000'); 




INSERT INTO hat_city VALUES (67,'������','210000');

INSERT INTO hat_city VALUES (68,'������','210000');

INSERT INTO hat_city VALUES (69,'��ɽ��','210000');

INSERT INTO hat_city VALUES (70,'��˳��','210000');

INSERT INTO hat_city VALUES (71,'��Ϫ��','210000');

INSERT INTO hat_city VALUES (72,'������','210000');

INSERT INTO hat_city VALUES (73,'������','210000');

INSERT INTO hat_city VALUES (74,'Ӫ����','210000');

INSERT INTO hat_city VALUES (75,'������','210000');

INSERT INTO hat_city VALUES (76,'������','210000'); 
INSERT INTO hat_city VALUES (77,'�̽���','210000');

INSERT INTO hat_city VALUES (78,'������','210000');

INSERT INTO hat_city VALUES (79,'������','210000');

INSERT INTO hat_city VALUES (80,'��«����','210000'); 



INSERT INTO hat_city VALUES (81,'������','220000');

INSERT INTO hat_city VALUES (82,'������','220000');

INSERT INTO hat_city VALUES (83,'��ƽ��','220000');

INSERT INTO hat_city VALUES (84,'��Դ��','220000');

INSERT INTO hat_city VALUES (85,'ͨ����','220000');

INSERT INTO hat_city VALUES (86,'��ɽ��','220000');

INSERT INTO hat_city VALUES (87,'��ԭ��','220000');

INSERT INTO hat_city VALUES (88,'�׳���','220000');

INSERT INTO hat_city VALUES (89,'�ӱ߳�����������','220000'); 



INSERT INTO hat_city VALUES (90,'��������','230000');

INSERT INTO hat_city VALUES (91,'���������','230000');

INSERT INTO hat_city VALUES (92,'������','230000');

INSERT INTO hat_city VALUES (93,'�׸���','230000');

INSERT INTO hat_city VALUES (94,'˫Ѽɽ��','230000');

INSERT INTO hat_city VALUES (95,'������','230000');

INSERT INTO hat_city VALUES (96,'������','230000');

INSERT INTO hat_city VALUES (97,'��ľ˹��','230000');

INSERT INTO hat_city VALUES (98,'��̨����','230000'); 
INSERT INTO hat_city VALUES (99,'ĵ������','230000');

INSERT INTO hat_city VALUES (100,'�ں���','230000');

INSERT INTO hat_city VALUES (101,'�绯��','230000');

INSERT INTO hat_city VALUES (102,'���˰������','230000'); 


 INSERT INTO hat_city VALUES (103,'������','310000'); 
 INSERT INTO hat_city VALUES (104,'¬����','310000'); 
   INSERT INTO hat_city VALUES (105,'�����','310000'); 
    INSERT INTO hat_city VALUES (106,'������','310000'); 
     INSERT INTO hat_city VALUES (107,'������','310000'); 

 INSERT INTO hat_city VALUES (108,'������','310000'); 
  INSERT INTO hat_city VALUES (109,'բ����','310000'); 
   INSERT INTO hat_city VALUES (110,'�����','310000'); 
    INSERT INTO hat_city VALUES (111,'������','310000'); 
     INSERT INTO hat_city VALUES (112,'��ɽ��','310000'); 
     
     


     INSERT INTO hat_city VALUES (113,'������','310000'); 
      INSERT INTO hat_city VALUES (114,'�ζ���','310000'); 
       INSERT INTO hat_city VALUES (115,'�ɽ���','310000'); 
        INSERT INTO hat_city VALUES (116,'��ɽ��','310000'); 
         INSERT INTO hat_city VALUES (117,'������','310000'); 
          INSERT INTO hat_city VALUES (118,'�ֶ�����','310000'); 

INSERT INTO hat_city VALUES (119,'�Ͼ���','320000');

INSERT INTO hat_city VALUES (120,'������','320000');

INSERT INTO hat_city VALUES (121,'������','320000');

INSERT INTO hat_city VALUES (122,'������','320000');

INSERT INTO hat_city VALUES (123,'������','320000');

INSERT INTO hat_city VALUES (124,'��ͨ��','320000');

INSERT INTO hat_city VALUES (125,'���Ƹ���','320000'); 

INSERT INTO hat_city VALUES (126,'������','320000');

INSERT INTO hat_city VALUES (127,'�γ���','320000');

INSERT INTO hat_city VALUES (128,'������','320000');

INSERT INTO hat_city VALUES (129,'����','320000');

INSERT INTO hat_city VALUES (130,'̩����','320000');

INSERT INTO hat_city VALUES (131,'��Ǩ��','320000'); 


INSERT INTO hat_city VALUES (132,'������','330000');

INSERT INTO hat_city VALUES (133,'������','330000');

INSERT INTO hat_city VALUES (134,'������','330000');

INSERT INTO hat_city VALUES (135,'������','330000');

INSERT INTO hat_city VALUES (136,'������','330000');

INSERT INTO hat_city VALUES (137,'������','330000');

INSERT INTO hat_city VALUES (138,'����','330000'); 
INSERT INTO hat_city VALUES (139,'������','330000');

INSERT INTO hat_city VALUES (140,'��ɽ��','330000');

INSERT INTO hat_city VALUES (141,'̨����','330000');

INSERT INTO hat_city VALUES (142,'��ˮ��','330000'); 



INSERT INTO hat_city VALUES (143,'�Ϸ���','340000');

INSERT INTO hat_city VALUES (144,'�ߺ���','340000');

INSERT INTO hat_city VALUES (145,'������','340000');

INSERT INTO hat_city VALUES (146,'������','340000');

INSERT INTO hat_city VALUES (147,'��ɽ��','340000');

INSERT INTO hat_city VALUES (148,'������','340000');

INSERT INTO hat_city VALUES (149,'ͭ����','340000');

INSERT INTO hat_city VALUES (150,'������','340000');

INSERT INTO hat_city VALUES (151,'��ɽ��','340000');

INSERT INTO hat_city VALUES (152,'������','340000'); 
INSERT INTO hat_city VALUES (153,'������','340000');

INSERT INTO hat_city VALUES (154,'������','340000');

INSERT INTO hat_city VALUES (155,'������','340000');

INSERT INTO hat_city VALUES (156,'������','340000');

INSERT INTO hat_city VALUES (157,'������','340000');

INSERT INTO hat_city VALUES (158,'������','340000');

INSERT INTO hat_city VALUES (159,'������','340000'); 


INSERT INTO hat_city VALUES (160,'������','350000');

INSERT INTO hat_city VALUES (161,'������','350000');

INSERT INTO hat_city VALUES (162,'������','350000');

INSERT INTO hat_city VALUES (163,'������','350000');

INSERT INTO hat_city VALUES (164,'Ȫ����','350000');

INSERT INTO hat_city VALUES (165,'������','350000');

INSERT INTO hat_city VALUES (166,'��ƽ��','350000');

INSERT INTO hat_city VALUES (167,'������','350000');

INSERT INTO hat_city VALUES (168,'������','350000'); 




INSERT INTO hat_city VALUES (169,'�ϲ���','360000');

INSERT INTO hat_city VALUES (170,'��������','360000');

INSERT INTO hat_city VALUES (171,'Ƽ����','360000');

INSERT INTO hat_city VALUES (172,'�Ž���','360000');

INSERT INTO hat_city VALUES (173,'������','360000');

INSERT INTO hat_city VALUES (174,'ӥ̶��','360000');

INSERT INTO hat_city VALUES (175,'������','360000');

INSERT INTO hat_city VALUES (176,'������','360000');

INSERT INTO hat_city VALUES (177,'�˴���','360000'); 
INSERT INTO hat_city VALUES (178,'������','360000');

INSERT INTO hat_city VALUES (179,'������','360000'); 


INSERT INTO hat_city VALUES (180,'������','370000');

INSERT INTO hat_city VALUES (181,'�ൺ��','370000');

INSERT INTO hat_city VALUES (182,'�Ͳ���','370000');

INSERT INTO hat_city VALUES (183,'��ׯ��','370000');

INSERT INTO hat_city VALUES (184,'��Ӫ��','370000');

INSERT INTO hat_city VALUES (185,'��̨��','370000');

INSERT INTO hat_city VALUES (186,'Ϋ����','370000');

INSERT INTO hat_city VALUES (187,'������','370000'); 
INSERT INTO hat_city VALUES (188,'̩����','370000');

INSERT INTO hat_city VALUES (189,'������','370000');

INSERT INTO hat_city VALUES (190,'������','370000');

INSERT INTO hat_city VALUES (191,'������','370000');

INSERT INTO hat_city VALUES (192,'������','370000');

INSERT INTO hat_city VALUES (193,'������','370000');

INSERT INTO hat_city VALUES (194,'�ĳ���','370000');

INSERT INTO hat_city VALUES (195,'������','370000');

INSERT INTO hat_city VALUES (196,'������','370000'); 


INSERT INTO hat_city VALUES (197,'֣����','410000');

INSERT INTO hat_city VALUES (198,'������','410000');

INSERT INTO hat_city VALUES (199,'������','410000');

INSERT INTO hat_city VALUES (200,'ƽ��ɽ��','410000');

INSERT INTO hat_city VALUES (201,'������','410000');

INSERT INTO hat_city VALUES (202,'�ױ���','410000');

INSERT INTO hat_city VALUES (203,'������','410000');

INSERT INTO hat_city VALUES (204,'������','410000');

INSERT INTO hat_city VALUES (205,'�����','410000'); 
INSERT INTO hat_city VALUES (206,'�����','410000');

INSERT INTO hat_city VALUES (207,'�����','410000');

INSERT INTO hat_city VALUES (208,'����Ͽ��','410000');

INSERT INTO hat_city VALUES (209,'������','410000');

INSERT INTO hat_city VALUES (210,'������','410000');

INSERT INTO hat_city VALUES (211,'������','410000');

INSERT INTO hat_city VALUES (212,'�ܿ���','410000');

INSERT INTO hat_city VALUES (213,'פ�����','410000'); 



INSERT INTO hat_city VALUES (214,'�人��','420000');

INSERT INTO hat_city VALUES (215,'��ʯ��','420000');

INSERT INTO hat_city VALUES (216,'ʮ����','420000');

INSERT INTO hat_city VALUES (217,'�˲���','420000');

INSERT INTO hat_city VALUES (218,'�差��','420000');

INSERT INTO hat_city VALUES (219,'������','420000');

INSERT INTO hat_city VALUES (220,'������','420000');

INSERT INTO hat_city VALUES (221,'Т����','420000');

INSERT INTO hat_city VALUES (222,'������','420000');

INSERT INTO hat_city VALUES (223,'�Ƹ���','420000'); 
INSERT INTO hat_city VALUES (224,'������','420000');

INSERT INTO hat_city VALUES (225,'������','420000');

INSERT INTO hat_city VALUES (226,'��ʩ����������������','420000');

INSERT INTO hat_city VALUES (227,'ʡֱϽ������λ','420000'); 



INSERT INTO hat_city VALUES (228,'��ɳ��','430000');


INSERT INTO hat_city VALUES (229,'������','430000');

INSERT INTO hat_city VALUES (230,'��̶��','430000');

INSERT INTO hat_city VALUES (231,'������','430000');

INSERT INTO hat_city VALUES (232,'������','430000');

INSERT INTO hat_city VALUES (233,'������','430000');

INSERT INTO hat_city VALUES (234,'������','430000');

INSERT INTO hat_city VALUES (235,'�żҽ���','430000');

INSERT INTO hat_city VALUES (236,'������','430000'); 
INSERT INTO hat_city VALUES (237,'������','430000');

INSERT INTO hat_city VALUES (238,'������','430000');

INSERT INTO hat_city VALUES (239,'������','430000');

INSERT INTO hat_city VALUES (240,'¦����','430000');

INSERT INTO hat_city VALUES (241,'��������������������','430000'); 




INSERT INTO hat_city VALUES (242,'������','440000');

INSERT INTO hat_city VALUES (243,'�ع���','440000');

INSERT INTO hat_city VALUES (244,'������','440000');

INSERT INTO hat_city VALUES (245,'�麣��','440000');

INSERT INTO hat_city VALUES (246,'��ͷ��','440000');

INSERT INTO hat_city VALUES (247,'��ɽ��','440000');

INSERT INTO hat_city VALUES (248,'������','440000');

INSERT INTO hat_city VALUES (249,'տ����','440000'); 
INSERT INTO hat_city VALUES (250,'ï����','440000');

INSERT INTO hat_city VALUES (251,'������','440000');

INSERT INTO hat_city VALUES (252,'������','440000');

INSERT INTO hat_city VALUES (253,'÷����','440000');

INSERT INTO hat_city VALUES (254,'��β��','440000');

INSERT INTO hat_city VALUES (255,'��Դ��','440000');

INSERT INTO hat_city VALUES (256,'������','440000');

INSERT INTO hat_city VALUES (257,'��Զ��','440000'); 
INSERT INTO hat_city VALUES (258,'��ݸ��','440000');

INSERT INTO hat_city VALUES (259,'��ɽ��','440000');

INSERT INTO hat_city VALUES (260,'������','440000');

INSERT INTO hat_city VALUES (261,'������','440000');

INSERT INTO hat_city VALUES (262,'�Ƹ���','440000'); 

INSERT INTO hat_city VALUES (263,'������','450000');

INSERT INTO hat_city VALUES (264,'������','450000');

INSERT INTO hat_city VALUES (265,'������','450000');

INSERT INTO hat_city VALUES (266,'������','450000');

INSERT INTO hat_city VALUES (267,'������','450000');

INSERT INTO hat_city VALUES (268,'���Ǹ���','450000');

INSERT INTO hat_city VALUES (269,'������','450000'); 

INSERT INTO hat_city VALUES (270,'�����','450000');

INSERT INTO hat_city VALUES (271,'������','450000');

INSERT INTO hat_city VALUES (272,'��ɫ��','450000');

INSERT INTO hat_city VALUES (273,'������','450000');

INSERT INTO hat_city VALUES (274,'�ӳ���','450000');

INSERT INTO hat_city VALUES (275,'������','450000');

INSERT INTO hat_city VALUES (276,'������','450000'); 

delete hat_city where cid=295

INSERT INTO hat_city VALUES (278,'��ָɽ��','460000');
INSERT INTO hat_city VALUES (279,'����','460000');
INSERT INTO hat_city VALUES (280,'�Ĳ���','460000');
INSERT INTO hat_city VALUES (281,'������','460000');
INSERT INTO hat_city VALUES (282,'������','460000');
INSERT INTO hat_city VALUES (283,'������','460000');
INSERT INTO hat_city VALUES (284,'�Ͳ���','460000');
INSERT INTO hat_city VALUES (285,'������','460000');
INSERT INTO hat_city VALUES (286,'�ٸ���','460000');
INSERT INTO hat_city VALUES (287,'��ɳ����������','460000');
INSERT INTO hat_city VALUES (288,'��������������','460000');
INSERT INTO hat_city VALUES (289,'�ֶ�����������','460000');
INSERT INTO hat_city VALUES (290,'��ˮ����������','460000');
INSERT INTO hat_city VALUES (291,'��ͤ��������������','460000');
INSERT INTO hat_city VALUES (292,'������������������','460000');
INSERT INTO hat_city VALUES (293,'������','460000');
INSERT INTO hat_city VALUES (294,'��ɳ��','460000');
INSERT INTO hat_city VALUES (277,'������','460000');

INSERT INTO hat_city VALUES (295,'�ɶ���','510000');

INSERT INTO hat_city VALUES (296,'�Թ���','510000');

INSERT INTO hat_city VALUES (297,'��֦����','510000');

INSERT INTO hat_city VALUES (298,'������','510000');

INSERT INTO hat_city VALUES (299,'������','510000');

INSERT INTO hat_city VALUES (300,'������','510000');

INSERT INTO hat_city VALUES (301,'��Ԫ��','510000');

INSERT INTO hat_city VALUES (302,'������','510000'); 
INSERT INTO hat_city VALUES (303,'�ڽ���','510000');

INSERT INTO hat_city VALUES (304,'��ɽ��','510000');

INSERT INTO hat_city VALUES (305,'�ϳ���','510000');

INSERT INTO hat_city VALUES (306,'üɽ��','510000');

INSERT INTO hat_city VALUES (307,'�˱���','510000');

INSERT INTO hat_city VALUES (308,'�㰲��','510000');

INSERT INTO hat_city VALUES (309,'������','510000');

INSERT INTO hat_city VALUES (310,'�Ű���','510000');

INSERT INTO hat_city VALUES (311,'������','510000'); 
INSERT INTO hat_city VALUES (312,'������','510000');

INSERT INTO hat_city VALUES (313,'���Ӳ���Ǽ��������','510000');

INSERT INTO hat_city VALUES (314,'���β���������','510000');

INSERT INTO hat_city VALUES (315,'��ɽ����������','510000'); 

INSERT INTO hat_city VALUES (316,'������','520000');

INSERT INTO hat_city VALUES (317,'����ˮ��','520000');

INSERT INTO hat_city VALUES (318,'������','520000');

INSERT INTO hat_city VALUES (319,'��˳��','520000');

INSERT INTO hat_city VALUES (320,'ͭ�ʵ���','520000');

INSERT INTO hat_city VALUES (321,'ǭ���ϲ���������������','520000');

INSERT INTO hat_city VALUES (322,'�Ͻڵ���','520000');

INSERT INTO hat_city VALUES (323,'ǭ�������嶱��������','520000');

INSERT INTO hat_city VALUES (324,'ǭ�ϲ���������������','520000');

INSERT INTO hat_city VALUES (325,'������','530000');

INSERT INTO hat_city VALUES (326,'������','530000'); 
INSERT INTO hat_city VALUES (327,'��Ϫ��','530000');

INSERT INTO hat_city VALUES (328,'��ɽ��','530000');

INSERT INTO hat_city VALUES (329,'��ͨ��','530000');

INSERT INTO hat_city VALUES (330,'������','530000');

INSERT INTO hat_city VALUES (331,'˼é��','530000');

INSERT INTO hat_city VALUES (332,'�ٲ���','530000'); 
INSERT INTO hat_city VALUES (333,'��������������','530000');

INSERT INTO hat_city VALUES (334,'��ӹ���������������','530000');

INSERT INTO hat_city VALUES (335,'��ɽ׳������������','530000');

INSERT INTO hat_city VALUES (336,'��˫���ɴ���������','530000');

INSERT INTO hat_city VALUES (337,'�������������','530000');

INSERT INTO hat_city VALUES (338,'�º���徰����������','530000');

INSERT INTO hat_city VALUES (339,'ŭ��������������','530000');

INSERT INTO hat_city VALUES (340,'�������������','530000'); 


INSERT INTO hat_city VALUES (341,'������','540000');

INSERT INTO hat_city VALUES (342,'��������','540000');

INSERT INTO hat_city VALUES (343,'ɽ�ϵ���','540000');

INSERT INTO hat_city VALUES (344,'�տ������','540000');

INSERT INTO hat_city VALUES (345,'��������','540000');

INSERT INTO hat_city VALUES (346,'�������','540000');

INSERT INTO hat_city VALUES (347,'��֥����','540000');

INSERT INTO hat_city VALUES (348,'������','610000');

INSERT INTO hat_city VALUES (349,'ͭ����','610000');

INSERT INTO hat_city VALUES (350,'������','610000'); 
INSERT INTO hat_city VALUES (351,'������','610000');

INSERT INTO hat_city VALUES (352,'μ����','610000');

INSERT INTO hat_city VALUES (353,'�Ӱ���','610000');

INSERT INTO hat_city VALUES (354,'������','610000');

INSERT INTO hat_city VALUES (355,'������','610000');

INSERT INTO hat_city VALUES (356,'������','610000');

INSERT INTO hat_city VALUES (357,'������','610000'); 


INSERT INTO hat_city VALUES (358,'������','620000');

INSERT INTO hat_city VALUES (359,'��������','620000');

INSERT INTO hat_city VALUES (360,'�����','620000');

INSERT INTO hat_city VALUES (361,'������','620000');

INSERT INTO hat_city VALUES (362,'��ˮ��','620000');

INSERT INTO hat_city VALUES (363,'������','620000');

INSERT INTO hat_city VALUES (364,'��Ҵ��','620000');

INSERT INTO hat_city VALUES (365,'ƽ����','620000');

INSERT INTO hat_city VALUES (366,'��Ȫ��','620000'); 
INSERT INTO hat_city VALUES (367,'������','620000');

INSERT INTO hat_city VALUES (368,'������','620000');

INSERT INTO hat_city VALUES (369,'¤����','620000');

INSERT INTO hat_city VALUES (370,'���Ļ���������','620000');

INSERT INTO hat_city VALUES (371,'���ϲ���������','620000');

INSERT INTO hat_city VALUES (372,'������','630000');


INSERT INTO hat_city VALUES (373,'��������','630000'); 
INSERT INTO hat_city VALUES (374,'��������������','630000');

--delete hat_city where cid=385
INSERT INTO hat_city VALUES (375,'���ϲ���������','630000');

INSERT INTO hat_city VALUES (376,'���ϲ���������','630000');

INSERT INTO hat_city VALUES (377,'�������������','630000');

INSERT INTO hat_city VALUES (378,'��������������','630000');

INSERT INTO hat_city VALUES (379,'�����ɹ������������','630000'); 
--select * from hat_city where father='630000'

INSERT INTO hat_city VALUES (380,'������','640000');

INSERT INTO hat_city VALUES (381,'ʯ��ɽ��','640000');

INSERT INTO hat_city VALUES (382,'������','640000');

INSERT INTO hat_city VALUES (383,'��ԭ��','640000');

INSERT INTO hat_city VALUES (384,'������','640000');

INSERT INTO hat_city VALUES (385,'��³ľ����','650000');

INSERT INTO hat_city VALUES (386,'����������','650000');

INSERT INTO hat_city VALUES (387,'��³������','650000');

INSERT INTO hat_city VALUES (388,'���ܵ���','650000'); 
INSERT INTO hat_city VALUES (389,'��������������','650000');

INSERT INTO hat_city VALUES (390,'���������ɹ�������','650000');

INSERT INTO hat_city VALUES (391,'���������ɹ�������','650000');

INSERT INTO hat_city VALUES (392,'�����յ���','650000');

INSERT INTO hat_city VALUES (393,'�������տ¶�����������','650000');

INSERT INTO hat_city VALUES (394,'��ʲ����','650000');

INSERT INTO hat_city VALUES (395,'�������','650000');

INSERT INTO hat_city VALUES (396,'���������������','650000');

INSERT INTO hat_city VALUES (397,'���ǵ���','650000'); 
INSERT INTO hat_city VALUES (398,'����̩����','650000'); 

INSERT INTO hat_city VALUES (399,'������','500000');
INSERT INTO hat_city VALUES (400,'��ɿ���','500000');
INSERT INTO hat_city VALUES (401,'��ɿ���','500000');
INSERT INTO hat_city VALUES (402,'ɳƺ����','500000');
INSERT INTO hat_city VALUES (424,'��������','500000');
INSERT INTO hat_city VALUES (403,'�ϰ���','500000');
INSERT INTO hat_city VALUES (404,'������','500000');
INSERT INTO hat_city VALUES (405,'�山��','500000');
INSERT INTO hat_city VALUES (406,'������','500000');
INSERT INTO hat_city VALUES (407,'������','500000');
INSERT INTO hat_city VALUES (408,'������','500000');
INSERT INTO hat_city VALUES (409,'������','500000');
INSERT INTO hat_city VALUES (410,'�ɽ��','500000');
INSERT INTO hat_city VALUES (411,'������','500000');
INSERT INTO hat_city VALUES (412,'�뽭��','500000');
INSERT INTO hat_city VALUES (413,'������','500000');
INSERT INTO hat_city VALUES (414,'�ϴ���','500000');
INSERT INTO hat_city VALUES (415,'ǭ����','500000');
INSERT INTO hat_city VALUES (416,'������','500000');
INSERT INTO hat_city VALUES (417,'�ϴ���','500000');
INSERT INTO hat_city VALUES (418,'ͭ����','500000');
INSERT INTO hat_city VALUES (419,'������','500000');
INSERT INTO hat_city VALUES (420,'�ٲ���','500000');
INSERT INTO hat_city VALUES (421,'������','500000');
INSERT INTO hat_city VALUES (422,'��ƽ��','500000');
INSERT INTO hat_city VALUES (423,'��¡��','500000');



          

