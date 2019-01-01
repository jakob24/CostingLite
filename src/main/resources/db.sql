ALTER TABLE `costing_lite`.`product` 
ADD COLUMN `postage_charges` DOUBLE NULL AFTER `modified_on`,
ADD COLUMN `packing_charges` DOUBLE NULL AFTER `postage_charges`,
ADD COLUMN `other_charges` DOUBLE NULL AFTER `packing_charges`,
ADD COLUMN `web_rrp` DOUBLE NULL AFTER `other_charges`,
ADD COLUMN `web_pp_charge` DOUBLE NULL AFTER `web_rrp`,
ADD COLUMN `ebay_rrp` DOUBLE NULL AFTER `web_pp_charge`,
ADD COLUMN `ebay_fees` DOUBLE NULL AFTER `ebay_rrp`,
ADD COLUMN `amz_rrp` DOUBLE NULL AFTER `ebay_fees`,
ADD COLUMN `amz_fees` DOUBLE NULL AFTER `amz_rrp`,
ADD COLUMN `amz_fba_fees` DOUBLE NULL AFTER `amz_fees`;

ALTER TABLE `costing_lite`.`product` 
CHANGE COLUMN `postage_charges` `postage_charges` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `packing_charges` `packing_charges` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `other_charges` `other_charges` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `web_rrp` `web_rrp` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `web_pp_charge` `web_pp_charge` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `ebay_rrp` `ebay_rrp` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `ebay_fees` `ebay_fees` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `amz_rrp` `amz_rrp` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `amz_fees` `amz_fees` DOUBLE NULL DEFAULT 0 ,
CHANGE COLUMN `amz_fba_fees` `amz_fba_fees` DOUBLE NULL DEFAULT 0 ;

ALTER TABLE `costing_lite`.`product` 
ADD COLUMN `ean` VARCHAR(45) NULL AFTER `amz_fba_fees`;


ALTER TABLE `costing_lite`.`shipment` 
ADD INDEX `pay_ship_fk_idx` (`payment` ASC);
;
ALTER TABLE `costing_lite`.`shipment` 
ADD CONSTRAINT `pay_ship_fk`
  FOREIGN KEY (`payment`)
  REFERENCES `costing_lite`.`payment` (`payment_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
#19/12/2018
ALTER TABLE `costing_lite`.`shipment` 
ADD COLUMN `shipment_number` INT NULL AFTER `modified_on`;

ALTER TABLE `costing_lite`.`shipment` 
CHANGE COLUMN `shipment_number` `shipment_number` INT(2) NULL DEFAULT NULL ;

ALTER TABLE `costing_lite`.`invoice` 
ADD COLUMN `invoice_ref` VARCHAR(45) NULL AFTER `modified_on`;

#21/12/2018
ALTER TABLE `costing_lite`.`shipment` 
DROP COLUMN `payment`;

22/12/2018
ALTER TABLE `costing_lite`.`invoice` 
DROP COLUMN `invoice_ref`;

ALTER TABLE `costing_lite`.`invoice` 
ADD COLUMN `comments` VARCHAR(500) NULL AFTER `modified_on`;

27/12/2018
ALTER TABLE `costing_lite`.`invoice` 
ADD COLUMN `shipment_complete` TINYINT(2) NULL AFTER `comments`;

ALTER TABLE `costing_lite`.`invoice` 
CHANGE COLUMN `shipment_complete` `shipment_complete` TINYINT(2) NULL DEFAULT 0 ;

DROP TABLE `costing_lite`.`payment`;

ALTER TABLE `costing_lite`.`product` 
ADD COLUMN `sku` VARCHAR(45) NOT NULL AFTER `ean`;

ALTER TABLE `costing_lite`.`product` 
CHANGE COLUMN `image` `image` VARCHAR(500) NULL DEFAULT NULL ;

ALTER TABLE `costing_lite`.`product` 
CHANGE COLUMN `sku` `sku` VARCHAR(45) NULL ;

ALTER TABLE `costing_lite`.`product` 
CHANGE COLUMN `ASIN` `ASIN` VARCHAR(45) NULL DEFAULT NULL ,
CHANGE COLUMN `sku` `sku` VARCHAR(400) NULL DEFAULT NULL ;

ALTER TABLE `costing_lite`.`product` 
ADD COLUMN `inactive_from` TIMESTAMP NULL AFTER `sku`;

DELETE FROM `costing_lite`.`product` WHERE `product_id`='1';
DELETE FROM `costing_lite`.`product` WHERE `product_id`='2';
DELETE FROM `costing_lite`.`product` WHERE `product_id`='3';

ALTER TABLE `costing_lite`.`product` 
CHANGE COLUMN `name` `name` VARCHAR(150) NULL DEFAULT NULL ;

LOAD DATA INFILE 'C:/Users/Jacob/Desktop/ExportData.csv' 
INTO TABLE product 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS






