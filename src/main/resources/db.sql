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



