-- 建立訂單表 (orders)，order_id 自動遞增
create table if not exists `order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '訂單ID',
    user_id INT NOT NULL COMMENT '使用者ID',
    order_date datetime NOT NULL default current_timestamp COMMENT '訂單日期',
    FOREIGN KEY (user_id) REFERENCES user(id) 
);
 
-- 建立訂單項目表 (order_item)，item_id 自動遞增
create table if not exists order_item (
    item_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '項目ID',
    order_id INT NOT NULL COMMENT '訂單ID',
    product_id INT NOT NULL COMMENT '商品ID',
    quantity INT NOT NULL COMMENT '數量',
    FOREIGN KEY (order_id) REFERENCES `order`(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);
-- 建立商品(product);
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `product_name` varchar(50) NOT NULL COMMENT '商品名稱',
  `price` int NOT NULL COMMENT '商品價格',
  `qty` int DEFAULT '0' COMMENT '商品庫存',
  `image_base64` longtext COMMENT '商品照片',
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_name` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

https://developers-dot-devsite-v2-prod.appspot.com/chart/interactive/docs/gallery/piechart?hl=zh-tw