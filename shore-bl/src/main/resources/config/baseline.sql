SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
CREATE DATABASE IF NOT EXISTS `mrn_shore` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mrn_shore`;

CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `category_items` (
  `id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `category_id` int(6) NOT NULL,
  `sub_category_id` int(6) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `measurement_unit` int(3) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `isMuslim` tinyint(1) DEFAULT NULL,
  `search_tags` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `caterers` (
  `id` int(3) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone1` varchar(50) DEFAULT NULL,
  `phone2` varchar(50) DEFAULT NULL,
  `address1` varchar(1000) DEFAULT NULL,
  `address2` varchar(1000) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `country_id` int(6) NOT NULL,
  `pin` varchar(50) DEFAULT NULL,
  `added_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `caterer_clients` (
  `id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone1` varchar(50) DEFAULT NULL,
  `phone2` varchar(50) DEFAULT NULL,
  `address1` varchar(1000) DEFAULT NULL,
  `address2` varchar(1000) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `country_id` int(6) NOT NULL,
  `pin` varchar(50) DEFAULT NULL,
  `added_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `caterer_ships` (
  `id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `caterer_client_id` int(6) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `added_on` datetime DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(6) NOT NULL,
  `country_id` int(6) NOT NULL,
  `name` int(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `countries` (
  `id` int(6) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `item_measurement_unit` (
  `id` int(3) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `orders` (
  `id` varchar(100) NOT NULL,
  `order_number` varchar(50) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `modified_on` datetime DEFAULT NULL,
  `ship_id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `client_id` int(6) NOT NULL,
  `country_id` int(6) DEFAULT NULL,
  `city_id` int(6) DEFAULT NULL,
  `port_id` int(6) DEFAULT NULL,
  `expected_delivery_date` date DEFAULT NULL,
  `preferred_supplier` int(6) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `delivered_on` date DEFAULT NULL,
  `delivery_supplier` int(6) DEFAULT NULL,
  `ship_comments` varchar(500) DEFAULT NULL,
  `caterer_comments` varchar(500) DEFAULT NULL,
  `supplier_comments` varchar(500) DEFAULT NULL,
  `delivery_comments` varchar(500) DEFAULT NULL,
  `rejection_comments` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `order_extra_items` (
  `order_id` varchar(100) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `ordered_units` float DEFAULT NULL,
  `quoted_units` float DEFAULT NULL,
  `measurement_id` varchar(50) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `ship_comments` varchar(500) DEFAULT NULL,
  `caterer_comments` varchar(500) DEFAULT NULL,
  `supplier_comments` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `order_history` (
  `order_id` varchar(100) DEFAULT NULL,
  `event` varchar(500) NOT NULL,
  `event_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `order_items` (
  `order_id` varchar(100) DEFAULT NULL,
  `seq_number` int(3) NOT NULL,
  `item_id` int(6) DEFAULT NULL,
  `order_units` float NOT NULL,
  `qouted_units` float NOT NULL,
  `unit_price` float NOT NULL,
  `ship_comments` varchar(500) NOT NULL,
  `caterer_comments` varchar(500) NOT NULL,
  `supplier_comments` varchar(500) NOT NULL,
  `category_id` int(6) DEFAULT NULL,
  `sub_category_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `order_status` (
  `id` int(3) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` enum('SHI','SHO','SUP','SHI-SHO','SHI-SUP','SHO-SUP') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ports` (
  `id` int(6) NOT NULL,
  `country_id` int(6) NOT NULL,
  `city_id` int(6) NOT NULL,
  `name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sub_categories` (
  `id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `category_id` int(6) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suppliers` (
  `id` int(3) NOT NULL,
  `code` varchar(50) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone1` varchar(50) DEFAULT NULL,
  `phone2` varchar(50) DEFAULT NULL,
  `address1` varchar(1000) DEFAULT NULL,
  `address2` varchar(1000) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `country_id` int(6) NOT NULL,
  `pin` varchar(50) DEFAULT NULL,
  `added_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `supplier_orders` (
  `order_id` varchar(100) NOT NULL,
  `supplier_id` int(6) NOT NULL,
  `order_number` varchar(50) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `modified_on` datetime DEFAULT NULL,
  `country_id` int(6) DEFAULT NULL,
  `city_id` int(6) DEFAULT NULL,
  `port_id` int(6) DEFAULT NULL,
  `expected_delivery_date` date DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `delivered_on` date DEFAULT NULL,
  `ship_comments` varchar(500) DEFAULT NULL,
  `caterer_comments` varchar(500) DEFAULT NULL,
  `supplier_comments` varchar(500) DEFAULT NULL,
  `delivery_comments` varchar(500) DEFAULT NULL,
  `rejection_comments` varchar(500) DEFAULT NULL,
  `ship_id` int(6) NOT NULL,
  `caterer_id` int(6) NOT NULL,
  `client_id` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `supplier_order_extra_items` (
  `order_id` varchar(100) NOT NULL,
  `supplier_id` int(6) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `ordered_units` float DEFAULT NULL,
  `quoted_units` float DEFAULT NULL,
  `measurement_id` varchar(50) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `ship_comments` varchar(500) DEFAULT NULL,
  `caterer_comments` varchar(500) DEFAULT NULL,
  `supplier_comments` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `supplier_order_history` (
  `order_id` varchar(100) DEFAULT NULL,
  `supplier_id` int(6) NOT NULL,
  `event` varchar(500) NOT NULL,
  `event_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `supplier_order_items` (
  `order_id` varchar(100) DEFAULT NULL,
  `supplier_id` int(6) NOT NULL,
  `seq_number` int(3) NOT NULL,
  `item_id` int(6) DEFAULT NULL,
  `order_units` float NOT NULL,
  `qouted_units` float NOT NULL,
  `unit_price` float NOT NULL,
  `ship_comments` varchar(500) NOT NULL,
  `caterer_comments` varchar(500) NOT NULL,
  `supplier_comments` varchar(500) NOT NULL,
  `category_id` int(6) DEFAULT NULL,
  `sub_category_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(6) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `country_id` int(6) DEFAULT NULL,
  `type` enum('ADMIN','CAT','SUP','') NOT NULL,
  `caterer_id` int(6) DEFAULT NULL,
  `supplier_id` int(6) DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `caterer_id` (`caterer_id`);

ALTER TABLE `category_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `caterer_id` (`caterer_id`),
  ADD KEY `sub_category_id` (`sub_category_id`),
  ADD KEY `category_id` (`category_id`);

ALTER TABLE `caterers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `country_id` (`country_id`);

ALTER TABLE `caterer_clients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `country_id` (`country_id`);

ALTER TABLE `caterer_ships`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `caterer_id` (`caterer_id`),
  ADD KEY `caterer_client_id` (`caterer_client_id`);

ALTER TABLE `cities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cities_country_id` (`country_id`);

ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `item_measurement_unit`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status` (`status`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `city_id` (`city_id`),
  ADD KEY `port_id` (`port_id`),
  ADD KEY `ship_id` (`ship_id`),
  ADD KEY `caterer_id` (`caterer_id`),
  ADD KEY `client_id` (`client_id`);

ALTER TABLE `order_extra_items`
  ADD KEY `order_id` (`order_id`);

ALTER TABLE `order_history`
  ADD KEY `order_id` (`order_id`);

ALTER TABLE `order_items`
  ADD KEY `item_id` (`item_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `sub_category_id` (`sub_category_id`),
  ADD KEY `order_id` (`order_id`);

ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `ports`
  ADD PRIMARY KEY (`id`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `city_id` (`city_id`);

ALTER TABLE `sub_categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `caterer_id` (`caterer_id`),
  ADD KEY `category_id` (`category_id`);

ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `caterer_id` (`caterer_id`);

ALTER TABLE `supplier_orders`
  ADD KEY `status` (`status`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `city_id` (`city_id`),
  ADD KEY `port_id` (`port_id`),
  ADD KEY `ship_id` (`ship_id`),
  ADD KEY `caterer_id` (`caterer_id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `supplier_id` (`supplier_id`);

ALTER TABLE `supplier_order_extra_items`
  ADD KEY `order_id` (`order_id`);

ALTER TABLE `supplier_order_history`
  ADD KEY `order_id` (`order_id`);

ALTER TABLE `supplier_order_items`
  ADD KEY `item_id` (`item_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `sub_category_id` (`sub_category_id`),
  ADD KEY `order_id` (`order_id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `caterer_id` (`caterer_id`),
  ADD KEY `supplier_id` (`supplier_id`);


ALTER TABLE `categories`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `category_items`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `caterers`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
ALTER TABLE `caterer_clients`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `caterer_ships`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `cities`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `countries`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `item_measurement_unit`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
ALTER TABLE `ports`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `sub_categories`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
ALTER TABLE `suppliers`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
ALTER TABLE `users`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;

ALTER TABLE `categories`
  ADD CONSTRAINT `FK_categories_caterer_id` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`);

ALTER TABLE `category_items`
  ADD CONSTRAINT `FK_items_category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `FK_items_caterer_id` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`),
  ADD CONSTRAINT `FK_items_sub_category_id` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_categories` (`id`);

ALTER TABLE `caterers`
  ADD CONSTRAINT `FK_caterers_country_id` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

ALTER TABLE `caterer_clients`
  ADD CONSTRAINT `FK_caterer_clinet_country_id` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

ALTER TABLE `caterer_ships`
  ADD CONSTRAINT `FK_caterer_ships_caterer_id` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`),
  ADD CONSTRAINT `FK_caterer_ships_client_id` FOREIGN KEY (`caterer_client_id`) REFERENCES `caterer_clients` (`id`);

ALTER TABLE `cities`
  ADD CONSTRAINT `FK_cities_country_id` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

ALTER TABLE `orders`
  ADD CONSTRAINT `FK1_orders_country` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`),
  ADD CONSTRAINT `FK2_orders_city` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`),
  ADD CONSTRAINT `FK3_orders_port` FOREIGN KEY (`port_id`) REFERENCES `ports` (`id`),
  ADD CONSTRAINT `FK4_orders_status` FOREIGN KEY (`status`) REFERENCES `order_status` (`id`),
  ADD CONSTRAINT `FK5_orders_ship` FOREIGN KEY (`ship_id`) REFERENCES `caterer_ships` (`id`);

ALTER TABLE `order_extra_items`
  ADD CONSTRAINT `FK1_order_extra_items_orderid` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_history`
  ADD CONSTRAINT `FK1_order_history_orderID` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_items`
  ADD CONSTRAINT `FK1_order_items_category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `FK2_order_items_subcategory_id` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_categories` (`id`),
  ADD CONSTRAINT `FK3_order_items_itemid` FOREIGN KEY (`item_id`) REFERENCES `category_items` (`id`),
  ADD CONSTRAINT `FK3_order_items_orderId` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `ports`
  ADD CONSTRAINT `FK_ports_city_id` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`),
  ADD CONSTRAINT `FK_ports_country_id` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

ALTER TABLE `sub_categories`
  ADD CONSTRAINT `FK_sub_categories_category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `FK_sub_categories_caterer_id` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`);

ALTER TABLE `suppliers`
  ADD CONSTRAINT `FK1_suppliers_caterer` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`),
  ADD CONSTRAINT `FK1_suppliers_country` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

ALTER TABLE `supplier_orders`
  ADD CONSTRAINT `FK1_supplier_orders_orderID` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FK2_supplier_orders_countryID` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`),
  ADD CONSTRAINT `FK3_supplier_orders_cityID` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`),
  ADD CONSTRAINT `FK4_supplier_orders_portID` FOREIGN KEY (`port_id`) REFERENCES `ports` (`id`),
  ADD CONSTRAINT `FK5_supplier_orders_orderStatus` FOREIGN KEY (`status`) REFERENCES `order_status` (`id`),
  ADD CONSTRAINT `FK6_supplier_orders_ship` FOREIGN KEY (`ship_id`) REFERENCES `caterer_ships` (`id`),
  ADD CONSTRAINT `FK7_supplier_orders_caterer` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`),
  ADD CONSTRAINT `FK8_supplier_orders_client` FOREIGN KEY (`client_id`) REFERENCES `caterer_clients` (`id`);

ALTER TABLE `supplier_order_items`
  ADD CONSTRAINT `FK2_supplier_order_items_item` FOREIGN KEY (`item_id`) REFERENCES `category_items` (`id`),
  ADD CONSTRAINT `FK3_supplier_order_items_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `FK4_supplier_order_items_category` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_categories` (`id`);

ALTER TABLE `users`
  ADD CONSTRAINT `FK_users_caterer` FOREIGN KEY (`caterer_id`) REFERENCES `caterers` (`id`),
  ADD CONSTRAINT `FK_users_country` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`),
  ADD CONSTRAINT `FK_users_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`);
