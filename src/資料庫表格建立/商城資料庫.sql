use MOVIEON;

DROP TABLE IF EXISTS orderInfo;
DROP TABLE IF EXISTS orderList;
DROP TABLE IF EXISTS shoppingCart;
DROP TABLE IF EXISTS customerService;


-- ORDERINFO --
-- �H�U�]�w: �ۼW�D�䪺�_�I�ȡA�]�N�O��l�ȡA���Ƚd��O1 .. 655355 --
set auto_increment_offset=001;
-- �H�U�]�w: �ۼW�D��C�����W���q�A��w�]�ȬO1�A���Ƚd��O1 .. 65535 --
set auto_increment_increment=1; 
CREATE TABLE orderInfo (
	orderId	           INT AUTO_INCREMENT NOT NULL,
	orderStatus		   varchar(20),
    orderDate          DATETIME,
    paymentMethodId    varchar(20),
    deliveryMethodId   varchar(20),
    consignee          VARCHAR(12),
    mobile             VARCHAR(10),
    address            VARCHAR(50),
    invoiceId          VARCHAR(10),
    userId	           INT NOT NULL,
    orderTotal         INT(10),
    payStatus          varchar(20),
	-- CONSTRAINT orderInfo_userId_FK FOREIGN KEY (userId) REFERENCES ORDERINFO (userId),
	CONSTRAINT orderInfo_orderId_PK PRIMARY KEY (orderId)
) AUTO_INCREMENT = 1;

INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('�w����', NOW(), '�H�Υd', '�v�t�쩲', '������','0911951248', '500, Longjiang Road, Taipei, Taiwan', '�ӤH', 1, 900, '�w�I��');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('�q�榨��', NOW(), 'ATM��b', '�W�Ө��f', '�d�ȼw','0988765432', '100, Mingquan East Road, Taipei, Taiwan', '�ӤH', 2, 600, '���I��');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('�t�e��', NOW(), '�W�ӥI��', '�v�t�쩲', '�L�V��','0945678901', '�x�_�����s�ϫn�ʪF���T�q219��2��', '�ӤH', 4, 300, '�w�I��');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('�w����', NOW(), 'ATM��b', '�W�Ө��f', '�L�F�F','0956789012', '�x�_�����s�ϫn�ʪF���T�q219��1��', '�ӤH', 5, 300, '���I��');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('�w����', NOW(), '�W�ӥI��', '�v�t�쩲', '������','0911951248', '500, Longjiang Road, Taipei, Taiwan', '�ӤH', 1, 300, '���I��');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('�t�e��', NOW(), 'ATM��b', '�W�Ө��f', '������','0911951248', '500, Longjiang Road, Taipei, Taiwan', '�ӤH', 1, 300, '�w�I��');

-- ORDERLIST --
-- �H�U�]�w: �ۼW�D�䪺�_�I�ȡA�]�N�O��l�ȡA���Ƚd��O1 .. 655355 --
set auto_increment_offset=001;
-- �H�U�]�w: �ۼW�D��C�����W���q�A��w�]�ȬO1�A���Ƚd��O1 .. 65535 --
set auto_increment_increment=1; 
CREATE TABLE orderList (
	orderListId	      INT AUTO_INCREMENT NOT NULL,
	price	      	  INT(5),
	itemQty           INT(5),
    orderRemark       VARCHAR(200),
    orderId	          INT NOT NULL,
    itemId	          INT NOT NULL,
    productImage      BLOB,
-- 	CONSTRAINT orderList_ORDERID_FK FOREIGN KEY (ORDERID) REFERENCES ORDERLIST (ORDERID),
-- 	CONSTRAINT orderList_ITEMID_FK FOREIGN KEY (ITEMID) REFERENCES ORDERLIST (ITEMID),
	CONSTRAINT orderList_orderListId_PK PRIMARY KEY (orderListId)
) AUTO_INCREMENT = 1;

INSERT INTO orderList (price, itemQty, orderRemark , orderId, itemId, productImage) VALUES (300, 2, NULL, 001, 3005, '');
INSERT INTO orderList (price, itemQty, orderRemark , orderId, itemId, productImage) VALUES (300, 1, NULL, 002, 3005, ''), (300, 1, NULL, 001, 3006, '');
INSERT INTO orderList (price, itemQty, orderRemark , orderId, itemId, productImage) VALUES (300, 1, NULL, 003, 3006, '');
INSERT INTO orderList (price, itemQty, orderRemark , orderId, itemId, productImage) VALUES (300, 1, NULL, 004, 3005, '');
INSERT INTO orderList (price, itemQty, orderRemark , orderId, itemId, productImage) VALUES (300, 1, NULL, 005, 3006, '');
INSERT INTO orderList (price, itemQty, orderRemark , orderId, itemId, productImage) VALUES (300, 1, NULL, 006, 3005, '');

-- SHOPPINGCART --
-- �H�U�]�w: �ۼW�D�䪺�_�I�ȡA�]�N�O��l�ȡA���Ƚd��O1 .. 655355 --
set auto_increment_offset=001;
-- �H�U�]�w: �ۼW�D��C�����W���q�A��w�]�ȬO1�A���Ƚd��O1 .. 65535 --
set auto_increment_increment=1;
CREATE TABLE shoppingCart (
	cartId     INT AUTO_INCREMENT NOT NULL,
	itemQty    INT(10),
    userId	   INT NOT NULL,
    itemId	   INT NOT NULL,
-- 	CONSTRAINT SHOPPINGCART_USERID_FK FOREIGN KEY (USERID) REFERENCES SHOPPINGCART (USERID),
--  CONSTRAINT SHOPPINGCART_ITEMID_FK FOREIGN KEY (ITEMID) REFERENCES SHOPPINGCART (ITEMID),
	CONSTRAINT shoppingCart_cartId_PK PRIMARY KEY (cartId)
) AUTO_INCREMENT = 1;

INSERT INTO shoppingCart (itemQty, userId, itemId) VALUES (2, 0001, 01), (3, 0001, 08), (1, 0001, 12);
INSERT INTO shoppingCart (itemQty, userId, itemId) VALUES (1, 0002, 11);
INSERT INTO shoppingCart (itemQty, userId, itemId) VALUES (3, 0003, 21), (2, 0003, 12);
INSERT INTO shoppingCart (itemQty, userId, itemId) VALUES (1, 0004, 09);


-- CUSTOMERSERVICE --
-- �H�U�]�w: �ۼW�D�䪺�_�I�ȡA�]�N�O��l�ȡA���Ƚd��O1 .. 655355 --
set auto_increment_offset=001;
-- �H�U�]�w: �ۼW�D��C�����W���q�A��w�]�ȬO1�A���Ƚd��O1 .. 65535 --
set auto_increment_increment=1;
CREATE TABLE customerService (
	msgId       INT AUTO_INCREMENT NOT NULL,
	msgTime     DATETIME,
	msgTitle     VARCHAR(100),
	msgContext  VARCHAR(900),
	reContext   VARCHAR(900),
	userId      INT NOT NULL,    
--  	CONSTRAINT CustomerService_userId_FK FOREIGN KEY (userId) REFERENCES CUSTOMERSERVICE (userId),
	CONSTRAINT customerService_msgId_PK PRIMARY KEY (msgId)
) AUTO_INCREMENT = 1;

INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'�߰ݰt�e�ɶ�?', '�Y����T�{�I�ڪ���,�w�p�X����X�f�O?', NULL, 0001);
INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'�~���O�_���O���~�O?', '�Q�߰ݭ}�h�����P�䳣�O��������?', NULL, 0002);
INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'�i�H���f��?', '�p�G�����o�{�����w���ܯഫ�f��?', NULL, 0003);
INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'�H�e�ɶ��Ӫ�!', '�W�Ӥ�쪺�q��,��o�Ӥ뤤���|������f,�Q�߰ݥثe���򪬪p?', NULL, 0004);

-- �H�U�����ܶq��:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session�ܶq
-- show global variables  like '%auto_inc%';  -- //global�ܶq

-- �H�U�������Ҫ� �����BSSL�B �r���s�X��:
-- select version();
-- show variables like '%ssl%';  [ �ΰ��� mysql> \s ]
-- show variables like '%character%';