--学生登录
create table log_stu(
       usercode varchar2(20) primary key,
       pwd varchar2(20)
)

insert into log_stu values('s001','0001')
insert into log_stu values('s002','0002')
insert into log_stu values('s003','0003')
select * from log_stu

--老师登录
create table log_tea(
       usercode varchar2(20) primary key,
       pwd varchar2(20)
)
insert into log_tea values('t001','0001')
insert into log_tea values('t002','0002')
insert into log_tea values('t003','0003')
select * from log_tea

--管理员登录
create table log_root(
       usercode varchar2(20) primary key,
       pwd varchar2(20)  
)
insert into log_root values('r001','0001')
select * from log_root

--学生个人信息
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

--成绩信息
create table stu_score(
       stu_id varchar2(20),
       stu_name varchar2(20),
       course_id varchar2(20),
       course_name varchar2(20),
       score number(5),
       constraint stu_score primary key(stu_id,course_id)
)

--课程信息
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

--教师个人信息
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

--老师课程信息
create table tea_course(
       course_id varchar2(20),
       course_name varchar2(50),
       course_date varchar2(100),
       teacher_id varchar2(20),
       teacher_name varchar2(20),
       classroom varchar2(20),
       stu_major varchar2(20)
)

--公告表
create table notice(
       title varchar2(50),
       notice_date varchar2(20),
       txt varchar2(1000)
)



---省份建表

create table hat_province (

sid number(11) primary key,

provinceid varchar2(6),

province varchar2(40)

)
select * from hat_province
---插入数据
insert into hat_province values (1,'110000','北京市');

INSERT INTO hat_province VALUES (2,'120000','天津市');

INSERT INTO hat_province VALUES (3,'130000','河北省');

INSERT INTO hat_province VALUES (4,'140000','山西省');

INSERT INTO hat_province VALUES (5,'150000','内蒙古自治区');

INSERT INTO hat_province VALUES (6,'210000','辽宁省');

INSERT INTO hat_province VALUES (7,'220000','吉林省');

INSERT INTO hat_province VALUES (8,'230000','黑龙江省'); 
INSERT INTO hat_province VALUES (9,'310000','上海市');

INSERT INTO hat_province VALUES (10,'320000','江苏省');

INSERT INTO hat_province VALUES (11,'330000','浙江省');

INSERT INTO hat_province VALUES (12,'340000','安徽省'); 

INSERT INTO hat_province VALUES (13,'350000','福建省');

INSERT INTO hat_province VALUES (14,'360000','江西省');

INSERT INTO hat_province VALUES (15,'370000','山东省');

INSERT INTO hat_province VALUES (16,'410000','河南省');

INSERT INTO hat_province VALUES (17,'420000','湖北省');

INSERT INTO hat_province VALUES (18,'430000','湖南省');

INSERT INTO hat_province VALUES (19,'440000','广东省');

INSERT INTO hat_province VALUES (20,'450000','广西壮族自治区');

INSERT INTO hat_province VALUES (21,'460000','海南省');

INSERT INTO hat_province VALUES (22,'500000','重庆市');

INSERT INTO hat_province VALUES (23,'510000','四川省');

INSERT INTO hat_province VALUES (24,'520000','贵州省');

INSERT INTO hat_province VALUES (25,'530000','云南省');

INSERT INTO hat_province VALUES (26,'540000','西藏自治区');

INSERT INTO hat_province VALUES (27,'610000','陕西省');

INSERT INTO hat_province VALUES (28,'620000','甘肃省');

INSERT INTO hat_province VALUES (29,'630000','青海省');

INSERT INTO hat_province VALUES (30,'640000','宁夏回族自治区');

INSERT INTO hat_province VALUES (31,'650000','新疆维吾尔自治区');

INSERT INTO hat_province VALUES (32,'710000','台湾省');

INSERT INTO hat_province VALUES (33,'810000','香港特别行政区');

INSERT INTO hat_province VALUES (34,'820000','澳门特别行政区'); 


--城市建表
CREATE TABLE hat_city (

cid number(11) primary key ,

city varchar2(50),

father varchar2(6)

)

select * from hat_city
--插入数据
insert into hat_city values (1,'东城区','110000');
insert into hat_city values (2,'西城区','110000');
insert into hat_city values (3,'朝阳区','110000');
 insert into hat_city values (4,'丰台区','110000');
 insert into hat_city values (5,'石景山区','110000');
 insert into hat_city values (6,'海淀区','110000');
 insert into hat_city values (7,'顺义区','110000');
 insert into hat_city values (8,'通州区','110000');
 insert into hat_city values (9,'大兴区','110000');
 insert into hat_city values (10,'房山区','110000');
 insert into hat_city values (11,'门头沟区','110000');
 insert into hat_city values (12,'昌平区','110000');
 insert into hat_city values (13,'平谷区','110000');
 insert into hat_city values (14,'密云区','110000');
 insert into hat_city values (15,'怀柔区','110000');
 insert into hat_city values (16,'延庆区','110000');
 
  insert into hat_city values (17,'和平区','120000');
  insert into hat_city values (18,'河东区','120000');
  insert into hat_city values (19,'河西区','120000');
  insert into hat_city values (20,'南开区','120000');
  insert into hat_city values (21,'河北区','120000');
  insert into hat_city values (22,'红桥区','120000');
  insert into hat_city values (23,'滨海新区','120000');
  insert into hat_city values (24,'东丽区','120000');
  insert into hat_city values (25,'西青区','120000');
  insert into hat_city values (26,'津南区','120000');
  insert into hat_city values (27,'武清区','120000');
  insert into hat_city values (28,'宝坻区','120000');
  insert into hat_city values (29,'宁河区','120000');
  insert into hat_city values (30,'静海区','120000');
  insert into hat_city values (31,'蓟州区','120000');
  insert into hat_city values (32,'北辰区','120000');
 

  INSERT INTO hat_city VALUES (33,'石家庄市','130000');

INSERT INTO hat_city VALUES (34,'唐山市','130000');

INSERT INTO hat_city VALUES (35,'秦皇岛市','130000');

INSERT INTO hat_city VALUES (36,'邯郸市','130000');

INSERT INTO hat_city VALUES (37,'邢台市','130000');

INSERT INTO hat_city VALUES (38,'保定市','130000');

INSERT INTO hat_city VALUES (39,'张家口市','130000'); 
INSERT INTO hat_city VALUES (40,'承德市','130000');

INSERT INTO hat_city VALUES (41,'沧州市','130000');

INSERT INTO hat_city VALUES (42,'廊坊市','130000');

INSERT INTO hat_city VALUES (43,'衡水市','130000'); 


 
 INSERT INTO hat_city VALUES (44,'太原市','140000');

INSERT INTO hat_city VALUES (45,'大同市','140000');

INSERT INTO hat_city VALUES (46,'阳泉市','140000');

INSERT INTO hat_city VALUES (47,'长治市','140000');

INSERT INTO hat_city VALUES (48,'晋城市','140000');

INSERT INTO hat_city VALUES (49,'朔州市','140000');

INSERT INTO hat_city VALUES (50,'晋中市','140000');

INSERT INTO hat_city VALUES (51,'运城市','140000'); 
INSERT INTO hat_city VALUES (52,'忻州市','140000');

INSERT INTO hat_city VALUES (53,'临汾市','140000');

INSERT INTO hat_city VALUES (54,'吕梁市','140000'); 
 


INSERT INTO hat_city VALUES (55,'呼和浩特市','150000');

INSERT INTO hat_city VALUES (56,'包头市','150000');

INSERT INTO hat_city VALUES (57,'乌海市','150000');

INSERT INTO hat_city VALUES (58,'赤峰市','150000');

INSERT INTO hat_city VALUES (59,'通辽市','150000');

INSERT INTO hat_city VALUES (60,'鄂尔多斯市','150000');

INSERT INTO hat_city VALUES (61,'呼伦贝尔市','150000'); 
INSERT INTO hat_city VALUES (62,'巴彦淖尔市','150000');

INSERT INTO hat_city VALUES (63,'乌兰察布市','150000');

INSERT INTO hat_city VALUES (64,'兴安盟','150000');

INSERT INTO hat_city VALUES (65,'锡林郭勒盟','150000');

INSERT INTO hat_city VALUES (66,'阿拉善盟','150000'); 




INSERT INTO hat_city VALUES (67,'沈阳市','210000');

INSERT INTO hat_city VALUES (68,'大连市','210000');

INSERT INTO hat_city VALUES (69,'鞍山市','210000');

INSERT INTO hat_city VALUES (70,'抚顺市','210000');

INSERT INTO hat_city VALUES (71,'本溪市','210000');

INSERT INTO hat_city VALUES (72,'丹东市','210000');

INSERT INTO hat_city VALUES (73,'锦州市','210000');

INSERT INTO hat_city VALUES (74,'营口市','210000');

INSERT INTO hat_city VALUES (75,'阜新市','210000');

INSERT INTO hat_city VALUES (76,'辽阳市','210000'); 
INSERT INTO hat_city VALUES (77,'盘锦市','210000');

INSERT INTO hat_city VALUES (78,'铁岭市','210000');

INSERT INTO hat_city VALUES (79,'朝阳市','210000');

INSERT INTO hat_city VALUES (80,'葫芦岛市','210000'); 



INSERT INTO hat_city VALUES (81,'长春市','220000');

INSERT INTO hat_city VALUES (82,'吉林市','220000');

INSERT INTO hat_city VALUES (83,'四平市','220000');

INSERT INTO hat_city VALUES (84,'辽源市','220000');

INSERT INTO hat_city VALUES (85,'通化市','220000');

INSERT INTO hat_city VALUES (86,'白山市','220000');

INSERT INTO hat_city VALUES (87,'松原市','220000');

INSERT INTO hat_city VALUES (88,'白城市','220000');

INSERT INTO hat_city VALUES (89,'延边朝鲜族自治州','220000'); 



INSERT INTO hat_city VALUES (90,'哈尔滨市','230000');

INSERT INTO hat_city VALUES (91,'齐齐哈尔市','230000');

INSERT INTO hat_city VALUES (92,'鸡西市','230000');

INSERT INTO hat_city VALUES (93,'鹤岗市','230000');

INSERT INTO hat_city VALUES (94,'双鸭山市','230000');

INSERT INTO hat_city VALUES (95,'大庆市','230000');

INSERT INTO hat_city VALUES (96,'伊春市','230000');

INSERT INTO hat_city VALUES (97,'佳木斯市','230000');

INSERT INTO hat_city VALUES (98,'七台河市','230000'); 
INSERT INTO hat_city VALUES (99,'牡丹江市','230000');

INSERT INTO hat_city VALUES (100,'黑河市','230000');

INSERT INTO hat_city VALUES (101,'绥化市','230000');

INSERT INTO hat_city VALUES (102,'大兴安岭地区','230000'); 


 INSERT INTO hat_city VALUES (103,'黄浦区','310000'); 
 INSERT INTO hat_city VALUES (104,'卢湾区','310000'); 
   INSERT INTO hat_city VALUES (105,'徐汇区','310000'); 
    INSERT INTO hat_city VALUES (106,'长宁区','310000'); 
     INSERT INTO hat_city VALUES (107,'静安区','310000'); 

 INSERT INTO hat_city VALUES (108,'普陀区','310000'); 
  INSERT INTO hat_city VALUES (109,'闸北区','310000'); 
   INSERT INTO hat_city VALUES (110,'虹口区','310000'); 
    INSERT INTO hat_city VALUES (111,'杨浦区','310000'); 
     INSERT INTO hat_city VALUES (112,'宝山区','310000'); 
     
     


     INSERT INTO hat_city VALUES (113,'闵行区','310000'); 
      INSERT INTO hat_city VALUES (114,'嘉定区','310000'); 
       INSERT INTO hat_city VALUES (115,'松江区','310000'); 
        INSERT INTO hat_city VALUES (116,'金山区','310000'); 
         INSERT INTO hat_city VALUES (117,'青浦区','310000'); 
          INSERT INTO hat_city VALUES (118,'浦东新区','310000'); 

INSERT INTO hat_city VALUES (119,'南京市','320000');

INSERT INTO hat_city VALUES (120,'无锡市','320000');

INSERT INTO hat_city VALUES (121,'徐州市','320000');

INSERT INTO hat_city VALUES (122,'常州市','320000');

INSERT INTO hat_city VALUES (123,'苏州市','320000');

INSERT INTO hat_city VALUES (124,'南通市','320000');

INSERT INTO hat_city VALUES (125,'连云港市','320000'); 

INSERT INTO hat_city VALUES (126,'淮安市','320000');

INSERT INTO hat_city VALUES (127,'盐城市','320000');

INSERT INTO hat_city VALUES (128,'扬州市','320000');

INSERT INTO hat_city VALUES (129,'镇江市','320000');

INSERT INTO hat_city VALUES (130,'泰州市','320000');

INSERT INTO hat_city VALUES (131,'宿迁市','320000'); 


INSERT INTO hat_city VALUES (132,'杭州市','330000');

INSERT INTO hat_city VALUES (133,'宁波市','330000');

INSERT INTO hat_city VALUES (134,'温州市','330000');

INSERT INTO hat_city VALUES (135,'嘉兴市','330000');

INSERT INTO hat_city VALUES (136,'湖州市','330000');

INSERT INTO hat_city VALUES (137,'绍兴市','330000');

INSERT INTO hat_city VALUES (138,'金华市','330000'); 
INSERT INTO hat_city VALUES (139,'衢州市','330000');

INSERT INTO hat_city VALUES (140,'舟山市','330000');

INSERT INTO hat_city VALUES (141,'台州市','330000');

INSERT INTO hat_city VALUES (142,'丽水市','330000'); 



INSERT INTO hat_city VALUES (143,'合肥市','340000');

INSERT INTO hat_city VALUES (144,'芜湖市','340000');

INSERT INTO hat_city VALUES (145,'蚌埠市','340000');

INSERT INTO hat_city VALUES (146,'淮南市','340000');

INSERT INTO hat_city VALUES (147,'马鞍山市','340000');

INSERT INTO hat_city VALUES (148,'淮北市','340000');

INSERT INTO hat_city VALUES (149,'铜陵市','340000');

INSERT INTO hat_city VALUES (150,'安庆市','340000');

INSERT INTO hat_city VALUES (151,'黄山市','340000');

INSERT INTO hat_city VALUES (152,'滁州市','340000'); 
INSERT INTO hat_city VALUES (153,'阜阳市','340000');

INSERT INTO hat_city VALUES (154,'宿州市','340000');

INSERT INTO hat_city VALUES (155,'巢湖市','340000');

INSERT INTO hat_city VALUES (156,'六安市','340000');

INSERT INTO hat_city VALUES (157,'亳州市','340000');

INSERT INTO hat_city VALUES (158,'池州市','340000');

INSERT INTO hat_city VALUES (159,'宣城市','340000'); 


INSERT INTO hat_city VALUES (160,'福州市','350000');

INSERT INTO hat_city VALUES (161,'厦门市','350000');

INSERT INTO hat_city VALUES (162,'莆田市','350000');

INSERT INTO hat_city VALUES (163,'三明市','350000');

INSERT INTO hat_city VALUES (164,'泉州市','350000');

INSERT INTO hat_city VALUES (165,'漳州市','350000');

INSERT INTO hat_city VALUES (166,'南平市','350000');

INSERT INTO hat_city VALUES (167,'龙岩市','350000');

INSERT INTO hat_city VALUES (168,'宁德市','350000'); 




INSERT INTO hat_city VALUES (169,'南昌市','360000');

INSERT INTO hat_city VALUES (170,'景德镇市','360000');

INSERT INTO hat_city VALUES (171,'萍乡市','360000');

INSERT INTO hat_city VALUES (172,'九江市','360000');

INSERT INTO hat_city VALUES (173,'新余市','360000');

INSERT INTO hat_city VALUES (174,'鹰潭市','360000');

INSERT INTO hat_city VALUES (175,'赣州市','360000');

INSERT INTO hat_city VALUES (176,'吉安市','360000');

INSERT INTO hat_city VALUES (177,'宜春市','360000'); 
INSERT INTO hat_city VALUES (178,'抚州市','360000');

INSERT INTO hat_city VALUES (179,'上饶市','360000'); 


INSERT INTO hat_city VALUES (180,'济南市','370000');

INSERT INTO hat_city VALUES (181,'青岛市','370000');

INSERT INTO hat_city VALUES (182,'淄博市','370000');

INSERT INTO hat_city VALUES (183,'枣庄市','370000');

INSERT INTO hat_city VALUES (184,'东营市','370000');

INSERT INTO hat_city VALUES (185,'烟台市','370000');

INSERT INTO hat_city VALUES (186,'潍坊市','370000');

INSERT INTO hat_city VALUES (187,'济宁市','370000'); 
INSERT INTO hat_city VALUES (188,'泰安市','370000');

INSERT INTO hat_city VALUES (189,'威海市','370000');

INSERT INTO hat_city VALUES (190,'日照市','370000');

INSERT INTO hat_city VALUES (191,'莱芜市','370000');

INSERT INTO hat_city VALUES (192,'临沂市','370000');

INSERT INTO hat_city VALUES (193,'德州市','370000');

INSERT INTO hat_city VALUES (194,'聊城市','370000');

INSERT INTO hat_city VALUES (195,'滨州市','370000');

INSERT INTO hat_city VALUES (196,'荷泽市','370000'); 


INSERT INTO hat_city VALUES (197,'郑州市','410000');

INSERT INTO hat_city VALUES (198,'开封市','410000');

INSERT INTO hat_city VALUES (199,'洛阳市','410000');

INSERT INTO hat_city VALUES (200,'平顶山市','410000');

INSERT INTO hat_city VALUES (201,'安阳市','410000');

INSERT INTO hat_city VALUES (202,'鹤壁市','410000');

INSERT INTO hat_city VALUES (203,'新乡市','410000');

INSERT INTO hat_city VALUES (204,'焦作市','410000');

INSERT INTO hat_city VALUES (205,'濮阳市','410000'); 
INSERT INTO hat_city VALUES (206,'许昌市','410000');

INSERT INTO hat_city VALUES (207,'漯河市','410000');

INSERT INTO hat_city VALUES (208,'三门峡市','410000');

INSERT INTO hat_city VALUES (209,'南阳市','410000');

INSERT INTO hat_city VALUES (210,'商丘市','410000');

INSERT INTO hat_city VALUES (211,'信阳市','410000');

INSERT INTO hat_city VALUES (212,'周口市','410000');

INSERT INTO hat_city VALUES (213,'驻马店市','410000'); 



INSERT INTO hat_city VALUES (214,'武汉市','420000');

INSERT INTO hat_city VALUES (215,'黄石市','420000');

INSERT INTO hat_city VALUES (216,'十堰市','420000');

INSERT INTO hat_city VALUES (217,'宜昌市','420000');

INSERT INTO hat_city VALUES (218,'襄樊市','420000');

INSERT INTO hat_city VALUES (219,'鄂州市','420000');

INSERT INTO hat_city VALUES (220,'荆门市','420000');

INSERT INTO hat_city VALUES (221,'孝感市','420000');

INSERT INTO hat_city VALUES (222,'荆州市','420000');

INSERT INTO hat_city VALUES (223,'黄冈市','420000'); 
INSERT INTO hat_city VALUES (224,'咸宁市','420000');

INSERT INTO hat_city VALUES (225,'随州市','420000');

INSERT INTO hat_city VALUES (226,'恩施土家族苗族自治州','420000');

INSERT INTO hat_city VALUES (227,'省直辖行政单位','420000'); 



INSERT INTO hat_city VALUES (228,'长沙市','430000');


INSERT INTO hat_city VALUES (229,'株洲市','430000');

INSERT INTO hat_city VALUES (230,'湘潭市','430000');

INSERT INTO hat_city VALUES (231,'衡阳市','430000');

INSERT INTO hat_city VALUES (232,'邵阳市','430000');

INSERT INTO hat_city VALUES (233,'岳阳市','430000');

INSERT INTO hat_city VALUES (234,'常德市','430000');

INSERT INTO hat_city VALUES (235,'张家界市','430000');

INSERT INTO hat_city VALUES (236,'益阳市','430000'); 
INSERT INTO hat_city VALUES (237,'郴州市','430000');

INSERT INTO hat_city VALUES (238,'永州市','430000');

INSERT INTO hat_city VALUES (239,'怀化市','430000');

INSERT INTO hat_city VALUES (240,'娄底市','430000');

INSERT INTO hat_city VALUES (241,'湘西土家族苗族自治州','430000'); 




INSERT INTO hat_city VALUES (242,'广州市','440000');

INSERT INTO hat_city VALUES (243,'韶关市','440000');

INSERT INTO hat_city VALUES (244,'深圳市','440000');

INSERT INTO hat_city VALUES (245,'珠海市','440000');

INSERT INTO hat_city VALUES (246,'汕头市','440000');

INSERT INTO hat_city VALUES (247,'佛山市','440000');

INSERT INTO hat_city VALUES (248,'江门市','440000');

INSERT INTO hat_city VALUES (249,'湛江市','440000'); 
INSERT INTO hat_city VALUES (250,'茂名市','440000');

INSERT INTO hat_city VALUES (251,'肇庆市','440000');

INSERT INTO hat_city VALUES (252,'惠州市','440000');

INSERT INTO hat_city VALUES (253,'梅州市','440000');

INSERT INTO hat_city VALUES (254,'汕尾市','440000');

INSERT INTO hat_city VALUES (255,'河源市','440000');

INSERT INTO hat_city VALUES (256,'阳江市','440000');

INSERT INTO hat_city VALUES (257,'清远市','440000'); 
INSERT INTO hat_city VALUES (258,'东莞市','440000');

INSERT INTO hat_city VALUES (259,'中山市','440000');

INSERT INTO hat_city VALUES (260,'潮州市','440000');

INSERT INTO hat_city VALUES (261,'揭阳市','440000');

INSERT INTO hat_city VALUES (262,'云浮市','440000'); 

INSERT INTO hat_city VALUES (263,'南宁市','450000');

INSERT INTO hat_city VALUES (264,'柳州市','450000');

INSERT INTO hat_city VALUES (265,'桂林市','450000');

INSERT INTO hat_city VALUES (266,'梧州市','450000');

INSERT INTO hat_city VALUES (267,'北海市','450000');

INSERT INTO hat_city VALUES (268,'防城港市','450000');

INSERT INTO hat_city VALUES (269,'钦州市','450000'); 

INSERT INTO hat_city VALUES (270,'贵港市','450000');

INSERT INTO hat_city VALUES (271,'玉林市','450000');

INSERT INTO hat_city VALUES (272,'百色市','450000');

INSERT INTO hat_city VALUES (273,'贺州市','450000');

INSERT INTO hat_city VALUES (274,'河池市','450000');

INSERT INTO hat_city VALUES (275,'来宾市','450000');

INSERT INTO hat_city VALUES (276,'崇左市','450000'); 

delete hat_city where cid=295

INSERT INTO hat_city VALUES (278,'五指山市','460000');
INSERT INTO hat_city VALUES (279,'琼海市','460000');
INSERT INTO hat_city VALUES (280,'文昌市','460000');
INSERT INTO hat_city VALUES (281,'万宁市','460000');
INSERT INTO hat_city VALUES (282,'东方市','460000');
INSERT INTO hat_city VALUES (283,'定安县','460000');
INSERT INTO hat_city VALUES (284,'屯昌县','460000');
INSERT INTO hat_city VALUES (285,'澄迈县','460000');
INSERT INTO hat_city VALUES (286,'临高县','460000');
INSERT INTO hat_city VALUES (287,'白沙黎族自治县','460000');
INSERT INTO hat_city VALUES (288,'昌江黎族自治县','460000');
INSERT INTO hat_city VALUES (289,'乐东黎族自治县','460000');
INSERT INTO hat_city VALUES (290,'陵水黎族自治县','460000');
INSERT INTO hat_city VALUES (291,'保亭黎族苗族自治县','460000');
INSERT INTO hat_city VALUES (292,'琼中黎族苗族自治县','460000');
INSERT INTO hat_city VALUES (293,'海口市','460000');
INSERT INTO hat_city VALUES (294,'三沙市','460000');
INSERT INTO hat_city VALUES (277,'儋州市','460000');

INSERT INTO hat_city VALUES (295,'成都市','510000');

INSERT INTO hat_city VALUES (296,'自贡市','510000');

INSERT INTO hat_city VALUES (297,'攀枝花市','510000');

INSERT INTO hat_city VALUES (298,'泸州市','510000');

INSERT INTO hat_city VALUES (299,'德阳市','510000');

INSERT INTO hat_city VALUES (300,'绵阳市','510000');

INSERT INTO hat_city VALUES (301,'广元市','510000');

INSERT INTO hat_city VALUES (302,'遂宁市','510000'); 
INSERT INTO hat_city VALUES (303,'内江市','510000');

INSERT INTO hat_city VALUES (304,'乐山市','510000');

INSERT INTO hat_city VALUES (305,'南充市','510000');

INSERT INTO hat_city VALUES (306,'眉山市','510000');

INSERT INTO hat_city VALUES (307,'宜宾市','510000');

INSERT INTO hat_city VALUES (308,'广安市','510000');

INSERT INTO hat_city VALUES (309,'达州市','510000');

INSERT INTO hat_city VALUES (310,'雅安市','510000');

INSERT INTO hat_city VALUES (311,'巴中市','510000'); 
INSERT INTO hat_city VALUES (312,'资阳市','510000');

INSERT INTO hat_city VALUES (313,'阿坝藏族羌族自治州','510000');

INSERT INTO hat_city VALUES (314,'甘孜藏族自治州','510000');

INSERT INTO hat_city VALUES (315,'凉山彝族自治州','510000'); 

INSERT INTO hat_city VALUES (316,'贵阳市','520000');

INSERT INTO hat_city VALUES (317,'六盘水市','520000');

INSERT INTO hat_city VALUES (318,'遵义市','520000');

INSERT INTO hat_city VALUES (319,'安顺市','520000');

INSERT INTO hat_city VALUES (320,'铜仁地区','520000');

INSERT INTO hat_city VALUES (321,'黔西南布依族苗族自治州','520000');

INSERT INTO hat_city VALUES (322,'毕节地区','520000');

INSERT INTO hat_city VALUES (323,'黔东南苗族侗族自治州','520000');

INSERT INTO hat_city VALUES (324,'黔南布依族苗族自治州','520000');

INSERT INTO hat_city VALUES (325,'昆明市','530000');

INSERT INTO hat_city VALUES (326,'曲靖市','530000'); 
INSERT INTO hat_city VALUES (327,'玉溪市','530000');

INSERT INTO hat_city VALUES (328,'保山市','530000');

INSERT INTO hat_city VALUES (329,'昭通市','530000');

INSERT INTO hat_city VALUES (330,'丽江市','530000');

INSERT INTO hat_city VALUES (331,'思茅市','530000');

INSERT INTO hat_city VALUES (332,'临沧市','530000'); 
INSERT INTO hat_city VALUES (333,'楚雄彝族自治州','530000');

INSERT INTO hat_city VALUES (334,'红河哈尼族彝族自治州','530000');

INSERT INTO hat_city VALUES (335,'文山壮族苗族自治州','530000');

INSERT INTO hat_city VALUES (336,'西双版纳傣族自治州','530000');

INSERT INTO hat_city VALUES (337,'大理白族自治州','530000');

INSERT INTO hat_city VALUES (338,'德宏傣族景颇族自治州','530000');

INSERT INTO hat_city VALUES (339,'怒江傈僳族自治州','530000');

INSERT INTO hat_city VALUES (340,'迪庆藏族自治州','530000'); 


INSERT INTO hat_city VALUES (341,'拉萨市','540000');

INSERT INTO hat_city VALUES (342,'昌都地区','540000');

INSERT INTO hat_city VALUES (343,'山南地区','540000');

INSERT INTO hat_city VALUES (344,'日喀则地区','540000');

INSERT INTO hat_city VALUES (345,'那曲地区','540000');

INSERT INTO hat_city VALUES (346,'阿里地区','540000');

INSERT INTO hat_city VALUES (347,'林芝地区','540000');

INSERT INTO hat_city VALUES (348,'西安市','610000');

INSERT INTO hat_city VALUES (349,'铜川市','610000');

INSERT INTO hat_city VALUES (350,'宝鸡市','610000'); 
INSERT INTO hat_city VALUES (351,'咸阳市','610000');

INSERT INTO hat_city VALUES (352,'渭南市','610000');

INSERT INTO hat_city VALUES (353,'延安市','610000');

INSERT INTO hat_city VALUES (354,'汉中市','610000');

INSERT INTO hat_city VALUES (355,'榆林市','610000');

INSERT INTO hat_city VALUES (356,'安康市','610000');

INSERT INTO hat_city VALUES (357,'商洛市','610000'); 


INSERT INTO hat_city VALUES (358,'兰州市','620000');

INSERT INTO hat_city VALUES (359,'嘉峪关市','620000');

INSERT INTO hat_city VALUES (360,'金昌市','620000');

INSERT INTO hat_city VALUES (361,'白银市','620000');

INSERT INTO hat_city VALUES (362,'天水市','620000');

INSERT INTO hat_city VALUES (363,'武威市','620000');

INSERT INTO hat_city VALUES (364,'张掖市','620000');

INSERT INTO hat_city VALUES (365,'平凉市','620000');

INSERT INTO hat_city VALUES (366,'酒泉市','620000'); 
INSERT INTO hat_city VALUES (367,'庆阳市','620000');

INSERT INTO hat_city VALUES (368,'定西市','620000');

INSERT INTO hat_city VALUES (369,'陇南市','620000');

INSERT INTO hat_city VALUES (370,'临夏回族自治州','620000');

INSERT INTO hat_city VALUES (371,'甘南藏族自治州','620000');

INSERT INTO hat_city VALUES (372,'西宁市','630000');


INSERT INTO hat_city VALUES (373,'海东地区','630000'); 
INSERT INTO hat_city VALUES (374,'海北藏族自治州','630000');

--delete hat_city where cid=385
INSERT INTO hat_city VALUES (375,'黄南藏族自治州','630000');

INSERT INTO hat_city VALUES (376,'海南藏族自治州','630000');

INSERT INTO hat_city VALUES (377,'果洛藏族自治州','630000');

INSERT INTO hat_city VALUES (378,'玉树藏族自治州','630000');

INSERT INTO hat_city VALUES (379,'海西蒙古族藏族自治州','630000'); 
--select * from hat_city where father='630000'

INSERT INTO hat_city VALUES (380,'银川市','640000');

INSERT INTO hat_city VALUES (381,'石嘴山市','640000');

INSERT INTO hat_city VALUES (382,'吴忠市','640000');

INSERT INTO hat_city VALUES (383,'固原市','640000');

INSERT INTO hat_city VALUES (384,'中卫市','640000');

INSERT INTO hat_city VALUES (385,'乌鲁木齐市','650000');

INSERT INTO hat_city VALUES (386,'克拉玛依市','650000');

INSERT INTO hat_city VALUES (387,'吐鲁番地区','650000');

INSERT INTO hat_city VALUES (388,'哈密地区','650000'); 
INSERT INTO hat_city VALUES (389,'昌吉回族自治州','650000');

INSERT INTO hat_city VALUES (390,'博尔塔拉蒙古自治州','650000');

INSERT INTO hat_city VALUES (391,'巴音郭楞蒙古自治州','650000');

INSERT INTO hat_city VALUES (392,'阿克苏地区','650000');

INSERT INTO hat_city VALUES (393,'克孜勒苏柯尔克孜自治州','650000');

INSERT INTO hat_city VALUES (394,'喀什地区','650000');

INSERT INTO hat_city VALUES (395,'和田地区','650000');

INSERT INTO hat_city VALUES (396,'伊犁哈萨克自治州','650000');

INSERT INTO hat_city VALUES (397,'塔城地区','650000'); 
INSERT INTO hat_city VALUES (398,'阿勒泰地区','650000'); 

INSERT INTO hat_city VALUES (399,'渝中区','500000');
INSERT INTO hat_city VALUES (400,'大渡口区','500000');
INSERT INTO hat_city VALUES (401,'大渡口区','500000');
INSERT INTO hat_city VALUES (402,'沙坪坝区','500000');
INSERT INTO hat_city VALUES (424,'九龙坡区','500000');
INSERT INTO hat_city VALUES (403,'南岸区','500000');
INSERT INTO hat_city VALUES (404,'北碚区','500000');
INSERT INTO hat_city VALUES (405,'渝北区','500000');
INSERT INTO hat_city VALUES (406,'巴南区','500000');
INSERT INTO hat_city VALUES (407,'万州区','500000');
INSERT INTO hat_city VALUES (408,'涪陵区','500000');
INSERT INTO hat_city VALUES (409,'永川区','500000');
INSERT INTO hat_city VALUES (410,'璧山区','500000');
INSERT INTO hat_city VALUES (411,'大足区','500000');
INSERT INTO hat_city VALUES (412,'綦江区','500000');
INSERT INTO hat_city VALUES (413,'江津区','500000');
INSERT INTO hat_city VALUES (414,'合川区','500000');
INSERT INTO hat_city VALUES (415,'黔江区','500000');
INSERT INTO hat_city VALUES (416,'长寿区','500000');
INSERT INTO hat_city VALUES (417,'南川区','500000');
INSERT INTO hat_city VALUES (418,'铜梁区','500000');
INSERT INTO hat_city VALUES (419,'潼南区','500000');
INSERT INTO hat_city VALUES (420,'荣昌区','500000');
INSERT INTO hat_city VALUES (421,'开州区','500000');
INSERT INTO hat_city VALUES (422,'梁平区','500000');
INSERT INTO hat_city VALUES (423,'武隆区','500000');



          

