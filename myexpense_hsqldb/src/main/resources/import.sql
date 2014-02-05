--INSERT INTO USERS(ACCESS,COLOR_THEME,CREATED_BY,CURRENCY,DELETED,EMAIL,ENABLED,JOINED_ID,MODIFIED_BY,NAME,PASSWORD,USERNAME) VALUES (1,'redmond','2013-08-28 13:51:27','INR',1,'saini.jitender@gmail.com',1,NULL,'2013-08-28 13:51:27.0','Jitender','5f4dcc3b5aa765d61d8327deb882cf99','jitendersaini')
--INSERT INTO CATEGORY (CATEGORY_NAME,CATEGORY_TYPE,CREATED_DATE,MODIFIED_DATE,CREATED_BY,MODIFIED_BY) VALUES('CATEGORY1',1,'2013-08-28 13:52:18','2013-08-28 13:52:18',1,1)
--INSERT INTO BUDGET(MONTH,VALUE,YEAR,CREATED_BY,MODIFIED_BY)VALUES(1,12345,2014,1,1)
--INSERT INTO PAYMENT_MODE(CREATED_DATE,MODIFIED_DATE,PAYMENT_MODE,PAYMENT_MODE_TYPE,CREATED_BY,MODIFIED_BY)VALUES('2013-08-28 13:52:18','2013-08-28 13:52:18','CASH',1,1,1)
--INSERT INTO EXPENSE(CREATED_DATE,EXPENSE_DATE,EXPENSE_TITLE,EXPENSE_VALUE,MODIFIED_DATE,CATEGORY_ID,PAID_VIA_ID,CREATED_BY,MODIFIED_BY)VALUES('2013-08-28 13:52:18','2013-08-28 13:52:18','Kitchen Grocery',1234.45,'2013-08-28 13:52:18',1,1,1,1)
--INSERT INTO NOTIFICATION(CREATED_DATE,MODIFIED_DATE,NOTIFICATION_DUE_DATE,NOTIFICATION_END_DATE,NOTIFICATION_START_DATE,NOTIFICATION_TITLE,NOTIFY_DAYS,NOTIFY_VIA,STATUS,CATEGORY_ID,CREATED_BY,MODIFIED_BY)VALUES('2013-08-28 13:52:18','2013-08-28 13:52:18','2013-08-28 13:52:18','2013-08-28 13:52:18','2013-08-28 13:52:18','PAY VODAFONE BILL',1,1,1,1,1,1)

-------------BEGIN USERS TABLE--------------
INSERT INTO users(access,color_theme,created_by,currency,deleted,email,enabled,joined_id,modified_by,name,password,username) VALUES (1,'redmond','2013-08-28 13:51:27.0','INR',1,'saini.jitender@gmail.com',1,null,'2013-08-28 13:51:27.0','Jitender','5f4dcc3b5aa765d61d8327deb882cf99','jitendersaini')
-------------END USERS TABLE--------------

-------------BEGIN CATEGORY TABLE--------------
INSERT INTO category (category_name,category_type,created_date,modified_date,created_by,modified_by) VALUES('CATEGORY1',1,'2013-08-28 13:52:18.0','2013-08-28 13:52:18.0','1','1')
INSERT INTO category (category_name,category_type,created_date,modified_date,created_by,modified_by) VALUES('Grocery',1,'2014-01-16 21:28:57.008','2014-01-16 21:28:57.008','1','1')
INSERT INTO category (category_name,category_type,created_date,modified_date,created_by,modified_by) VALUES('Bills',1,'2014-01-16 21:28:57.008','2014-01-16 21:28:57.008','1','1')
INSERT INTO category (category_name,category_type,created_date,modified_date,created_by,modified_by) VALUES('PUC',2,'2014-01-16 21:28:57.008','2014-01-16 21:28:57.008','1','1')
-------------END CATEGORY TABLE--------------

-------------BEGIN BUDGET TABLE--------------
INSERT INTO budget(month,value,year,created_by,modified_by) VALUES (1,12345.0,2014,1,1)
-------------END BUDGET TABLE--------------

-------------BEGIN PAYMENT MODE TABLE--------------
INSERT INTO payment_mode(created_date,modified_date,payment_mode,payment_mode_type,created_by,modified_by)VALUES('2013-08-28 13:52:18.0','2013-08-28 13:52:18.0','CASH',0,1,1)
INSERT INTO payment_mode(created_date,modified_date,payment_mode,payment_mode_type,created_by,modified_by)VALUES('2014-01-16 21:28:21.655','2014-01-16 21:28:21.655','Citi Card',1,1,1)
INSERT INTO payment_mode(created_date,modified_date,payment_mode,payment_mode_type,created_by,modified_by)VALUES('2014-01-16 21:28:21.655','2014-01-16 21:28:21.655','Stand Chart',1,1,1)
-------------END PAYMENT MODE TABLE--------------

-------------BEGIN EXPENSE TABLE--------------
INSERT INTO expense(created_date,expense_date,expense_title,expense_value,modified_date,category_id,paid_via_id,created_by,modified_by)VALUES('2013-08-28 13:52:18.0','2014-01-02 13:52:18.0','Kitchen Grocery',1234.45,'2013-08-28 13:52:18.0',1,1,1,1)
-------------END EXPENSE TABLE--------------

-------------BEGIN NOTIFICATION TABLE--------------
INSERT INTO notification(created_date,modified_date,notification_due_date,notification_end_date,notification_start_date,notification_title,notify_days,notify_via,status,category_id,created_by,modified_by)VALUES('2013-08-28 13:52:18.0','2013-08-28 13:52:18.0','2013-08-28 13:52:18.0','2013-08-28 13:52:18.0','2013-08-28 13:52:18.0','PAY VODAFONE BILL',1,1,1,1,1,1)
-------------END NOTIFICATION TABLE--------------



