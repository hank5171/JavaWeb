CREATE TABLE `shop` (
	shop_id INT AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(50) COMMENT '餐廳名稱',
    tel VARCHAR(50) COMMENT '餐點電話',
    shop_address VARCHAR(50) COMMENT '餐廳地址',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否已刪除（0:否 1:是）'
) COMMENT='商家總表';

CREATE TABLE `role` (
    role_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '角色 ID',
    role_name VARCHAR(50) UNIQUE NOT NULL COMMENT '角色名稱'
) COMMENT='角色對照表';

CREATE TABLE `menu_items` (
	menu_id INT AUTO_INCREMENT PRIMARY KEY,
    shop_id INT NOT NULL COMMENT '餐廳 ID',
    `name` VARCHAR(50) COMMENT '餐點名稱',
    `description` VARCHAR(255) COMMENT '商品備註',
    price INT COMMENT '金額',
    `status` TINYINT(1) DEFAULT '1' COMMENT '是否顯示(隱藏:0 顯示:1)',
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否已刪除（0:否 1:是）',
    -- 外鍵設定
    CONSTRAINT fk_menu_shop
        FOREIGN KEY (shop_id)
        REFERENCES shop(shop_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) COMMENT='餐點總表';

CREATE TABLE `users` (
    user_id INT AUTO_INCREMENT PRIMARY KEY ,
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '使用者名稱（帳號）',
    `password` VARCHAR(255) NOT NULL COMMENT '使用者密碼（加密儲存）',
    `password_salt` VARCHAR(255) NOT NULL COMMENT '加密鹽',
    user_role int NOT NULL DEFAULT '2' COMMENT '使用者權限（1:管理員, 2:一般使用者）',
    `status` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '帳號狀態（1 啟用，0 停用）',
    last_login_time DATETIME DEFAULT NULL COMMENT '最近登入時間',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
	is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否已刪除（0:否 1:是）',
	CONSTRAINT fk_user_role
		FOREIGN KEY (user_role)
		REFERENCES role(role_id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE `orders` (
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL COMMENT '點餐會員',
    menu_id INT COMMENT '餐點 ID', 
    quantity INT NOT NULL DEFAULT '1' COMMENT '數量',
    customized TEXT COMMENT '客製化備註',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
    CONSTRAINT fk_order_user
		FOREIGN KEY (user_id)
		REFERENCES `users`(user_id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	CONSTRAINT fk_order_menu_items
		FOREIGN KEY (menu_id)
		REFERENCES `menu_items`(menu_id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
) COMMENT='訂單總表';

CREATE TABLE `message` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '留言使用者ID',
  `message` varchar(255) DEFAULT NULL COMMENT '留言',
  PRIMARY KEY (`message_id`),
  KEY `fk_message_user` (`user_id`),
  CONSTRAINT `fk_message_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;









