use MOVIEON;

DROP TABLE IF EXISTS orderInfo;
DROP TABLE IF EXISTS orderList;
DROP TABLE IF EXISTS shoppingCart;
DROP TABLE IF EXISTS customerService;


-- ORDERINFO --
-- 以下設定: 自增主鍵的起點值，也就是初始值，取值範圍是1 .. 655355 --
set auto_increment_offset=001;
-- 以下設定: 自增主鍵每次遞增的量，其預設值是1，取值範圍是1 .. 65535 --
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

INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('已完成', NOW(), '信用卡', '宅配到府', '王美玉','0911951248', '500, Longjiang Road, Taipei, Taiwan', '個人', 1, 900, '已付款');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('訂單成立', NOW(), 'ATM轉帳', '超商取貨', '吳亞德','0988765432', '100, Mingquan East Road, Taipei, Taiwan', '個人', 2, 600, '未付款');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('配送中', NOW(), '超商付款', '宅配到府', '林向辛','0945678901', '台北市中山區南京東路三段219號2樓', '個人', 4, 300, '已付款');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('已取消', NOW(), 'ATM轉帳', '超商取貨', '林政達','0956789012', '台北市中山區南京東路三段219號1樓', '個人', 5, 300, '未付款');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('已取消', NOW(), '超商付款', '宅配到府', '王美玉','0911951248', '500, Longjiang Road, Taipei, Taiwan', '個人', 1, 300, '未付款');
INSERT INTO orderInfo (orderStatus, orderDate, paymentMethodId, deliveryMethodId, consignee, mobile, address, invoiceId, userId, orderTotal, payStatus) VALUES ('配送中', NOW(), 'ATM轉帳', '超商取貨', '王美玉','0911951248', '500, Longjiang Road, Taipei, Taiwan', '個人', 1, 300, '已付款');

-- ORDERLIST --
-- 以下設定: 自增主鍵的起點值，也就是初始值，取值範圍是1 .. 655355 --
set auto_increment_offset=001;
-- 以下設定: 自增主鍵每次遞增的量，其預設值是1，取值範圍是1 .. 65535 --
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
-- 以下設定: 自增主鍵的起點值，也就是初始值，取值範圍是1 .. 655355 --
set auto_increment_offset=001;
-- 以下設定: 自增主鍵每次遞增的量，其預設值是1，取值範圍是1 .. 65535 --
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
-- 以下設定: 自增主鍵的起點值，也就是初始值，取值範圍是1 .. 655355 --
set auto_increment_offset=001;
-- 以下設定: 自增主鍵每次遞增的量，其預設值是1，取值範圍是1 .. 65535 --
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

INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'詢問配送時間?', '若今日確認付款的話,預計幾號能出貨呢?', NULL, 0001);
INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'品項是否都是正品呢?', '想詢問迪士尼的周邊都是正版的嗎?', NULL, 0002);
INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'可以換貨嗎?', '如果收到後發現不喜歡的話能換貨嗎?', NULL, 0003);
INSERT INTO customerService (msgTime, msgTitle, msgContext, reContext, userId) VALUES (NOW() ,'寄送時間太長!', '上個月初的訂單,到這個月中都尚未收到貨,想詢問目前什麼狀況?', NULL, 0004);

-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';