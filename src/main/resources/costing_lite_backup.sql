-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 23, 2019 at 05:44 AM
-- Server version: 5.7.11
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `costing_lite`
--

-- --------------------------------------------------------

--
-- Table structure for table `amazon_fba_size_fees`
--

CREATE TABLE IF NOT EXISTS `amazon_fba_size_fees` (
  `amazon_fba_size_fees_id` int(11) NOT NULL,
  `size` varchar(100) DEFAULT NULL,
  `uk_fees` double DEFAULT NULL,
  `de_fees` double DEFAULT NULL,
  `fr_fees` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `amazon_fba_size_fees`
--

INSERT INTO `amazon_fba_size_fees` (`amazon_fba_size_fees_id`, `size`, `uk_fees`, `de_fees`, `fr_fees`) VALUES
(1, 'Sml-Oversize-0-1000g', 3.66, 5.03, 6.04),
(2, 'Sm-Env-Non-Media-0-100g', 1.34, 1.64, 2.11),
(3, 'Std-Env-Non-Media-0-100g', 1.47, 1.81, 2.24),
(4, 'Std-Env-Non-Media-101-250g', 1.62, 0, 0),
(5, 'Std-Parcel-Non-Media-0-250g', 1.98, 2.39, 4.39),
(6, 'Std-Parcel-Non-Media-501-1000g', 2.17, 3.08, 5.05),
(7, 'Std-Parcel-Non-Media-1501-2000g', 2.53, 3.66, 5.27),
(8, 'Lg-Env-Non-Media-0-1000g', 1.97, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `courier`
--

CREATE TABLE IF NOT EXISTS `courier` (
  `courier_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courier`
--

INSERT INTO `courier` (`courier_id`, `name`, `modified_by`, `modified_on`) VALUES
(1, 'UPS', NULL, '2018-12-15 06:17:28'),
(2, 'FedEx', NULL, '2018-12-15 06:18:34'),
(3, 'Linex International', NULL, '2018-12-15 06:18:57'),
(4, 'DPD', NULL, '2019-02-21 05:44:24'),
(5, 'DHL', NULL, '2019-02-21 05:44:40');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(11) NOT NULL,
  `invoice_number` varchar(45) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `inv_amount` double DEFAULT NULL,
  `inv_amount_usd` double DEFAULT NULL,
  `supplier` int(11) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comments` varchar(500) DEFAULT NULL,
  `shipment_complete` tinyint(2) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `invoice_number`, `invoice_date`, `date_paid`, `inv_amount`, `inv_amount_usd`, `supplier`, `modified_by`, `modified_on`, `comments`, `shipment_complete`) VALUES
(2, 'INV345', '2018-12-20', NULL, 0, 450, NULL, NULL, NULL, 'SOME COM', NULL),
(3, 'INV12', '2018-12-20', NULL, 0, 450, NULL, NULL, NULL, 'FGDFSGFD', NULL),
(4, 'INVRT56', '2018-12-20', NULL, 0, 600, NULL, NULL, NULL, 'SOME COM', NULL),
(5, 'INVMX23', '2018-12-20', NULL, 0, 700, NULL, NULL, NULL, 'DSF ADSF', NULL),
(6, 'MX55', '2018-12-18', NULL, 0, 864, 3, NULL, '2019-03-06 07:13:02', 'DSAF SDFADS', 0),
(7, 'OTTO3', '2018-12-20', '2019-01-04', 0, 900, 2, NULL, '2019-01-04 05:38:49', '2 Batches', 1),
(8, 'OTTO4', '2018-08-10', '2019-01-05', 464, 0, 2, NULL, '2019-01-06 06:11:26', 'Costed in £', 0),
(9, 'INVFG45', '2019-01-20', NULL, 0, 800, 1, NULL, '2019-02-02 17:44:06', '', 1),
(10, 'SDERT56Y', '2019-01-22', '2019-02-02', 0, 1000, 1, NULL, NULL, 'Paypal Payment', 0),
(11, 'SDERT56Y', '2019-01-22', '2019-02-02', 0, 1000, 1, NULL, NULL, 'Paypal Payment', 0),
(12, 'SDERT56Y', '2019-01-22', '2019-02-02', 0, 1000, 1, NULL, NULL, 'Paypal Payment', 0),
(13, 'TESTNEW', '2019-02-02', NULL, 0, 1500, 1, NULL, NULL, 'PAYX', 0),
(14, 'NEWOTTO', '2019-02-01', NULL, 0, 800, 2, NULL, NULL, '', 0),
(15, 'NEWOTTO', '2019-02-01', NULL, 0, 800, 2, NULL, NULL, '', 0),
(16, 'MXTEST', '2019-02-02', NULL, 3000, 0, 3, NULL, NULL, '', 0),
(17, 'INV-2019-01', '2019-02-12', NULL, 437.5, 0, 7, NULL, NULL, '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `payment_id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `amount_usd` double DEFAULT NULL,
  `bank_charges` double DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `disbursement_charges` double DEFAULT NULL,
  `gbp_to_usd` double DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  `other_charges` double DEFAULT NULL,
  `paid` smallint(6) DEFAULT NULL,
  `payment_type` varchar(45) DEFAULT NULL,
  `vat` double DEFAULT NULL,
  `invoice` int(11) DEFAULT NULL,
  `shipment` int(11) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `amount`, `amount_usd`, `bank_charges`, `date_paid`, `disbursement_charges`, `gbp_to_usd`, `modified_on`, `other_charges`, `paid`, `payment_type`, `vat`, `invoice`, `shipment`, `modified_by`) VALUES
(1, 281.12, 350, 3, '2018-12-20', 0, 1.245, NULL, 0, 0, 'INVOICE', 0, NULL, NULL, NULL),
(2, 79.74, 100, 3, '2018-12-22', 0, 1.254, NULL, 0, 0, 'INVOICE', 0, NULL, NULL, NULL),
(3, 318.47, 400, 3, '2018-12-21', 0, 1.256, NULL, 0, 0, 'INVOICE', 0, NULL, NULL, NULL),
(4, 401.41, 500, 3, '2018-12-21', 0, 1.2456, NULL, 0, 0, 'INVOICE', 0, 5, NULL, NULL),
(5, 161.94, 200, 3, '2018-12-22', 0, 1.235, NULL, 25, 0, 'INVOICE', 0, 5, NULL, NULL),
(6, 696.1, 864, 0, '2018-12-23', 0, 1.2412, NULL, 0, 0, 'INVOICE', 0, 6, NULL, NULL),
(7, 561.34, 700, 3, '2018-12-21', 0, 1.247, NULL, 0, 0, 'INVOICE', 0, 7, NULL, NULL),
(8, 161.94, 200, 3, '2018-12-22', 0, 1.235, NULL, 0, 0, 'INVOICE', 0, 7, NULL, NULL),
(9, 0, 0, 0, '2018-12-26', 0, 0, NULL, 0, 0, 'SHIPMENT', 0, NULL, 1, NULL),
(10, 0, 0, 0, '2018-12-27', 0, 0, NULL, 0, 0, 'SHIPMENT', 0, NULL, 2, NULL),
(11, 0, 0, 3, '2019-01-01', 11, 0, NULL, 0, 0, 'SHIPMENT', 12, NULL, 3, NULL),
(12, 464, 0, 4, '2018-08-10', 0, 0, NULL, 0, 0, 'INVOICE', 0, 8, NULL, NULL),
(13, 325, 0, 4, '2018-10-26', 12, 0, NULL, 0, 0, 'SHIPMENT', 9.18, NULL, 4, NULL),
(14, 325, 0, 4, '2018-10-26', 12, 0, NULL, 0, 0, 'SHIPMENT', 9.18, NULL, 6, NULL),
(15, 325, 0, 4, '2018-10-26', 12, 0, NULL, 0, 0, 'SHIPMENT', 9.18, NULL, 8, NULL),
(16, 325, 0, 4, '2018-10-26', 12, 0, NULL, 0, 0, 'SHIPMENT', 9.18, NULL, 10, NULL),
(17, 325, 0, 4, '2018-10-26', 12, 0, NULL, 0, 0, 'SHIPMENT', 9.18, NULL, 12, NULL),
(18, 325, 0, 4, '2018-10-17', 12, 0, NULL, 0, 0, 'SHIPMENT', 9.18, NULL, 14, NULL),
(19, 404.6617028164454, 500, 3, '2019-01-21', 0, 1.2356, NULL, 0, 0, 'INVOICE', 0, 9, NULL, NULL),
(20, 240.85, 300, 4, '2019-01-21', 0, 1.2456, NULL, 2, 0, 'INVOICE', 0, 9, NULL, NULL),
(21, 0, 0, 0, '2019-01-21', 12, 0, NULL, 0, 0, 'SHIPMENT', 11, NULL, 16, NULL),
(22, 810.37, 1000, 0, '2019-01-22', 0, 1.234, NULL, 0, 0, 'INVOICE', 0, 10, NULL, NULL),
(23, 810.37, 1000, 0, '2019-01-22', 0, 1.234, NULL, 0, 0, 'INVOICE', 0, 11, NULL, NULL),
(24, 810.37, 1000, 0, '2019-01-22', 0, 1.234, NULL, 0, 0, 'INVOICE', 0, 12, NULL, NULL),
(25, 1214.57, 1500, 0, '2019-02-02', 0, 1.235, NULL, 0, 0, 'INVOICE', 0, 13, NULL, NULL),
(26, 648.3, 800, 3, '2019-02-02', 0, 1.234, NULL, 1, 0, 'INVOICE', 0, 14, NULL, NULL),
(27, 648.3, 800, 3, '2019-02-02', 0, 1.234, NULL, 1, 0, 'INVOICE', 0, 15, NULL, NULL),
(28, 3000, 0, 3, '2019-02-02', 0, 0, NULL, 2, 0, 'INVOICE', 0, 16, NULL, NULL),
(29, 123, 0, 0, '2019-02-14', 45, 0, NULL, 0, 0, 'SHIPMENT', 0, NULL, 17, NULL),
(30, 437.5, 0, 3, '2019-02-12', 0, 0, NULL, 0, 0, 'INVOICE', 0, 17, NULL, NULL),
(31, 0, 0, 0, '2019-03-08', 0, 0, NULL, 0, 0, 'SHIPMENT', 0, NULL, 18, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `ASIN` varchar(45) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `min_inventory` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `postage_charges` double DEFAULT '0',
  `packing_charges` double DEFAULT '0',
  `other_charges` double DEFAULT '0',
  `web_rrp` double DEFAULT '0',
  `web_pp_charge` double DEFAULT '0',
  `ebay_rrp` double DEFAULT '0',
  `ebay_fees` double DEFAULT '0',
  `amz_rrp` double DEFAULT '0',
  `amz_fees` double DEFAULT '0',
  `amz_fba_fees` double DEFAULT '0',
  `ean` varchar(45) DEFAULT NULL,
  `sku` varchar(400) DEFAULT NULL,
  `inactive_from` timestamp NULL DEFAULT NULL,
  `cost_price_gbp` double DEFAULT NULL,
  `cost_price_usd` double DEFAULT NULL,
  `supplier` int(11) DEFAULT NULL,
  `amz_de_rrp` double DEFAULT NULL,
  `amz_de_fba_fees` double DEFAULT NULL,
  `amz_fr_rrp` double DEFAULT NULL,
  `amz_fr_fba_fess` double DEFAULT NULL,
  `amz_fr_fba_fees` double DEFAULT NULL,
  `amazon_fba_size_fees` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `name`, `ASIN`, `inventory`, `min_inventory`, `description`, `image`, `modified_by`, `modified_on`, `postage_charges`, `packing_charges`, `other_charges`, `web_rrp`, `web_pp_charge`, `ebay_rrp`, `ebay_fees`, `amz_rrp`, `amz_fees`, `amz_fba_fees`, `ean`, `sku`, `inactive_from`, `cost_price_gbp`, `cost_price_usd`, `supplier`, `amz_de_rrp`, `amz_de_fba_fees`, `amz_fr_rrp`, `amz_fr_fba_fess`, `amz_fr_fba_fees`, `amazon_fba_size_fees`) VALUES
(1, 'Hand Carved Jewellery Box', 'B01N374G9A', 9, 1, '', 'http://artisansworld.co.uk/img/p/6/3/9/639.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.5, 0, 7.18, 3, 7.18, 0, 9.98, 1.5, 0, '8438611357701', 'WH-110', '2018-12-31 00:00:00', 2.76, 2, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Hand Carved Jewellery Box', '', 5, 1, '', 'http://artisansworld.co.uk/img/p/6/4/0/640.jpg', NULL, '2019-03-09 05:16:13', 2.85, 0.25, 0, 6.96, 3, 6.96, 0, 9.66, 1.45, 0, '8.44E+12', 'WH-127', '2018-12-31 00:00:00', 3.48, 2.09, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Wooden Jewellery Box with Elephant Motif', 'B01MUI7JNA', 4, 1, '', 'http://artisansworld.co.uk/img/p/6/4/1/641.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.5, 0, 7.48, 3, 7.48, 0, 9.98, 1.5, 0, '8438611357640', 'WH-137', '2019-02-01 00:00:00', 4.4, 2.4, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'Wooden Peacock Figurine', 'B075XDK4B9', 14, 1, '', 'http://artisansworld.co.uk/img/p/3/8/5/385.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 9.98, 3, 9.98, 0, 9.98, 1.5, 0, '8438611358067', 'WH-101', '2018-12-31 00:00:00', 8.3, 5, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'Wooden Buddha Sculpture', 'B01MYCG96Y', 19, 1, '', 'http://artisansworld.co.uk/img/p/3/9/0/390.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 11.34, 3, 11.34, 0, 12.06, 1.81, 0, '8438611357886', 'WH-111', '2019-02-01 00:00:00', 11.9, 8, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'Wooden Specs Holder', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/9/5/95.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 6.05, 3, 6.05, 0, 6.05, 0, 0, '8438611358128', 'WH-115', '2018-12-31 00:00:00', 1.87, 1.5, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'Wooden Owls', 'B075XH7VDK', 3, 1, '', 'http://artisansworld.co.uk/img/p/4/6/8/468.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 14.98, 3, 14.98, 0, 14.98, 2.25, 0, '8438611357497', 'WH-113', '2018-12-31 00:00:00', 9.69, 5.5, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'Hand Carved Jewellery Box - Large', '', 2, 1, '', 'http://artisansworld.co.uk/img/p/4/6/46.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 9.98, 3, 9.98, 0, 9.98, 0, 0, '8.44E+12', 'CK-001', '2019-02-01 00:00:00', 4.99, 2.994, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'Hand Carved Jewellery Box', '', 2, 1, '', 'http://artisansworld.co.uk/img/p/5/3/53.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 9.98, 3, 9.98, 0, 9.98, 0, 0, '8.44E+12', 'CK-002', '2018-12-31 00:00:00', 4.99, 2.99, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'Wooden Peacock With Open Wings', 'B01MSBRW3O', 6, 1, '', 'http://artisansworld.co.uk/img/p/3/7/9/379.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 10.98, 3, 15.48, 0, 10.98, 1.65, 0, '8438611357794', 'KH-116', '2018-12-31 00:00:00', 10.07, 7.5, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'Wooden Peacock With Chick', 'B01N37W3S5', 3, 1, '', 'http://artisansworld.co.uk/img/p/6/0/60.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.5, 0, 14.98, 3, 15.98, 0, 15.98, 2.4, 0, '8438611357947', 'KH-119', '2018-12-31 00:00:00', 20, 14, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(12, 'Hand Carved Wooden Elephant - 6"', 'B01MYAAHEC', 13, 1, '', 'http://artisansworld.co.uk/img/p/8/3/7/837.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 26.46, 3, 27.86, 0, 27.86, 4.18, 0, '8438611357527', 'KH-019', NULL, 21.02, 20, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(13, 'Wooden Elephant - Lattice Style carved', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/2/4/6/246.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 25.58, 3, 25.58, 0, 25.58, 0, 0, '8.44E+12', 'KH-069', '2019-02-01 00:00:00', 12.79, 7.6739999999999995, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(14, 'Wooden Parrot Love Birds', 'B075XGKTRV', 3, 1, '', 'http://artisansworld.co.uk/img/p/3/9/1/391.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 12.58, 3, 12.58, 0, 12.65, 1.9, 0, '8438611358241', 'KH-107', '2018-12-31 00:00:00', 10.07, 7.5, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(15, 'Wooden Peacock Love Birds', 'B075XDBDKF', 3, 1, '', 'http://artisansworld.co.uk/img/p/3/7/3/373.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 12.58, 3, 12.58, 0, 12.65, 1.9, 0, '8438611358210', 'KH-108', '2018-12-31 00:00:00', 10.07, 7.5, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(16, 'Wooden Carved camel', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/2/1/2/212.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 19.98, 3, 19.98, 0, 19.98, 0, 0, '8.44E+12', 'KH-084', '2019-02-01 00:00:00', 9.99, 5.994, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(17, 'Carved Wooden Pen Holder', 'B01N5U0VEK', 6, 1, '', 'http://artisansworld.co.uk/img/p/3/7/6/376.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 9.8, 3, 9.8, 0, 9.98, 1.5, 0, '8438611358005', 'KH-454', '2018-12-31 00:00:00', 4.09, 4, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(18, 'Letter Opener - Wooden Elephant Carving', 'B07BNW3FYB', 27, 1, '', 'http://artisansworld.co.uk/img/p/7/9/6/796.jpg', NULL, '2019-03-16 06:03:12', 0.79, 0.25, 0, 2.4, 3, 5.98, 0, 5.42, 0.9, 2.28, '8438611358098', 'KH-1007A', NULL, 0.51, 0.4, 4, 6.98, 2.86, 8.98, NULL, 3.59, 3),
(19, 'Letter Opener - Wooden Bird Carving', 'B076YBQMSX', 19, 1, '', 'http://artisansworld.co.uk/img/p/3/9/4/394.jpg', NULL, '2019-03-17 06:41:10', 0.79, 0.25, 0, 3.98, 3, 5.28, 0.57, 5.98, 0.93, 2.37, '8438611358159', 'KH-1010', NULL, 0.82, 65, 4, 6.98, 2.86, 7.98, NULL, 3.44, 3),
(20, 'Wooden Carved Letter Opener', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/3/2/9/329.jpg', NULL, '2019-03-02 06:29:59', 0.79, 0.25, 0, 1.68, 3, 1.68, 0, 1.68, 0, 0, '8.44E+12', 'KH-1009', '2019-02-01 00:00:00', 0.84, 0.5, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(21, 'Wooden carved Key Chain', 'B07P2LFF18', 27, 1, '', 'http://artisansworld.co.uk/img/p/3/0/8/308.jpg', NULL, '2019-03-17 06:42:47', 0.79, 0.25, 0, 1.98, 3, 2.98, 0, 2.98, 0.45, 1.92, '7426872491853', 'KH-1000', NULL, 0.44, 0.28, 4, 3.53, 2.34, 3.77, NULL, 2.81, 3),
(22, 'Marble Pen Holder', '', 5, 1, '', 'http://artisansworld.co.uk/img/p/1/5/7/157.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 12.66, 3, 12.66, 0, 12.66, 0, 0, '8438611357978', 'KH-823', '2019-02-06 00:00:00', 7.84, 3.798, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(23, 'Marble Napkin Holder', 'B076YGCGF6', 3, 1, '', 'http://artisansworld.co.uk/img/p/7/1/2/712.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 10.54, 3, 10.54, 0, 11.43, 1.71, 0, '8438611358036', 'KH-821', '2019-02-01 00:00:00', 5.6, 5, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(24, 'Marble Tabletop Watch', 'B06VTVHGXV', 3, 1, '', 'http://artisansworld.co.uk/img/p/3/4/8/348.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.5, 0, 10.64, 3, 10.64, 0, 9.06, 1.36, 0, '8438611357916', 'KH-819', '2019-02-01 00:00:00', 4.48, 4.5, 4, NULL, NULL, NULL, NULL, NULL, NULL),
(25, 'Wooden Marquetry Box With Opulent Red Lining', '', 13, 1, '', 'http://artisansworld.co.uk/img/p/6/4/6/646.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 8.98, 3, 8.98, 0, 8.98, 0, 0, '8.44E+12', 'CK-003', '2019-02-01 00:00:00', 4.49, 2.694, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(26, 'Wooden Yarn Bowl - Multi Wood - 6" x 3"', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/8/2/5/825.jpg', NULL, '2019-03-08 05:57:32', 2.85, 0.25, 0, 21.5, 3, 20.98, 2.77, 21.5, 0, 0, '8438611357466', 'NC-004', NULL, 10.8, 13.5, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(27, 'Wooden Money Box with Key Lock / Piggy Bank', 'B01N3BK8CN', 3, 1, '', 'http://artisansworld.co.uk/img/p/4/2/1/421.jpg', NULL, '2019-03-08 05:54:10', 2.85, 0.25, 0, 16.49, 3, 15.98, 1.73, 15.45, 2.32, 0, '8438611357558', 'NC-022', NULL, 8.31, 5.5, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(28, 'Exotic Wooden Coaster set', 'B01N4RXUMP', 11, 1, '', 'http://artisansworld.co.uk/img/p/4/5/4/454.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.5, 0, 7.2, 3, 9, 0, 8.17, 1.23, 0, '8438611357589', 'WH-10137', '2019-02-01 00:00:00', 2.45, 1.5, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(29, 'Chinese Checkers board set with Glass Marbles', 'B01N7X8FX4', 240, 1, 'Other charges - £2.5 for 60 marbles', 'http://artisansworld.co.uk/img/p/9/0/1/901.jpg', NULL, '2019-03-16 06:51:15', 2.85, 1.25, 2.5, 32.48, 3, 35.28, 3.81, 35.28, 5.29, 7.82, '8438611357763', 'NC-005', NULL, 11.73, 11, 3, 39.76, 9.62, 43.38, NULL, 11.78, 7),
(30, 'Wooden Magnetic Travel Chess Set', 'B01N7X8NOZ', 16, 1, 'Supplied by OTTO', 'http://artisansworld.co.uk/img/p/9/1/5/915.jpg', NULL, '2019-03-16 06:36:44', 2.85, 0.25, 0, 16.98, 3, 18.98, 2.05, 17.98, 2.32, 4.87, '8438611357732', 'NC-002', NULL, 10.7, 7.72, 2, NULL, NULL, NULL, NULL, NULL, 6),
(31, 'Playing Cards and Dice Set In Wooden Box', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/7/2/2/722.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 15.98, 3, 15.98, 0, 15.98, 0, 0, '8.44E+12', 'NC-008', '2018-12-31 00:00:00', 7.99, 4.79, 2, NULL, NULL, NULL, NULL, NULL, NULL),
(32, 'Wooden Yarn Bowl - 6" X 3" with Free Yarn Ball', 'B07KC1MHWK', 21, 1, '', 'http://artisansworld.co.uk/img/p/8/7/7/877.jpg', NULL, '2019-03-16 17:09:00', 2.85, 0.25, 0, 20.16, 3, 20.98, 3, 19.98, 3, 5.17, '8438611358425', 'NC-008', NULL, 9.8, 12.3, 3, 23.67, 6.63, 25.27, NULL, 8.84, 6),
(33, 'Wooden Yarn Bowl - 7" X 3" - Multi Wood', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/7/9/0/790.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 23.98, 3, 23.98, 0, 23.98, 0, 0, '8438611358456', 'NC-006', NULL, 12.8, 16, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(34, 'Wooden Soup Bowls - Set of 2', '', 5, 1, '', 'http://artisansworld.co.uk/img/p/5/2/3/523.jpg', NULL, '2019-03-02 06:26:30', 0.79, 0.25, 0, 14.98, 3, 14.98, 0, 14.98, 0, 0, '8438611358630', 'NC-104', '2018-12-31 00:00:00', 7.49, 4.49, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(35, 'Rose Wood Knitting Needles - 3mm', '', 24, 1, '', 'http://artisansworld.co.uk/img/p/5/2/8/528.jpg', NULL, '2019-03-02 06:23:33', 0.79, 0.25, 0, 4.1, 3, 4.1, 0, 4.1, 0, 0, '8.44E+12', 'RK-003', NULL, 2.05, 1.2299999999999998, 5, NULL, NULL, NULL, NULL, NULL, NULL),
(36, 'Rose Wood Knitting Needles - 5mm', '', 24, 1, '', 'http://artisansworld.co.uk/img/p/5/3/3/533.jpg', NULL, '2019-03-02 06:23:43', 0.79, 0.25, 0, 4.98, 3, 4.98, 0, 4.98, 0, 0, '8.44E+12', 'RK-005', NULL, 2.49, 1.494, 5, NULL, NULL, NULL, NULL, NULL, NULL),
(37, 'Wooden Carved Shawl Pin - Oval Shaped', 'B073JZQ6FF', 47, 1, '', 'http://artisansworld.co.uk/img/p/8/3/1/831.jpg', NULL, '2019-03-09 04:55:57', 0.79, 0.25, 0, 4.98, 3, 5.64, 0, 5.64, 1.06, 2.7, '8438611358906', 'AW1056', NULL, 1.58, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(38, 'Wooden Carved Round Shawl Pin', 'B073JZQ6FF', 24, 1, '', 'http://artisansworld.co.uk/img/p/5/5/3/553.jpg', NULL, '2019-03-16 06:38:51', 0.79, 0.25, 0, 4.98, 3, 6.2, 0, 6.2, 0.93, 2.9, '8438611358937', 'AW1058', NULL, 1.58, 2, 1, NULL, NULL, NULL, NULL, NULL, 8),
(39, 'Round Wooden Carved Shawl Pin', 'B073K1ZBJQ', 30, 1, '', 'http://artisansworld.co.uk/img/p/5/5/8/558.jpg', NULL, '2019-03-08 05:58:14', 0.79, 0.25, 0, 4.98, 3, 5.28, 0.7, 5.48, 0.82, 0, '8438611358968', 'AW1060', NULL, 2.49, 1.49, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(40, 'Mobile Phone Stand Holder', 'B0755VYDWG', 28, 1, '', 'http://artisansworld.co.uk/img/p/5/9/1/591.jpg', NULL, '2019-03-16 06:44:57', 2.85, 0.5, 0, 7.3, 3, 7.3, 0, 9.98, 1.2, 3.18, '8438611358784', 'MH-001', '2018-12-31 00:00:00', 3.65, 2.19, 6, 11.82, 4.16, 12.62, NULL, 6.28, 5),
(41, 'Wooden Hand Massager - Small', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/5/9/2/592.jpg', NULL, '2019-03-02 06:29:30', 0.79, 0.25, 0, 3.22, 3, 3.22, 0, 3.22, 0, 0, '8.44E+12', 'HM-001', '2019-02-01 00:00:00', 1.61, 0.966, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(42, 'Wooden Fruit Bowl', '', 3, 1, '', 'http://artisansworld.co.uk/img/p/6/1/4/614.jpg', NULL, '2019-03-02 06:29:15', 0.79, 0.25, 0, 16.98, 3, 16.98, 0, 16.98, 0, 0, '7.43E+12', 'CK-018', '2019-02-01 00:00:00', 8.49, 5.094, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(43, 'Single Point Knitting Needle - 23 cm Long', '', 60, 1, '', 'http://artisansworld.co.uk/img/p/6/5/0/650.jpg', NULL, '2019-03-02 06:27:32', 0.79, 0.25, 0, 1, 3, 0.68, 0, 0.68, 0, 0, '8.44E+12', 'AW800003-2', '2018-12-31 00:00:00', 0.34, 0.2, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(44, 'Single Point Knitting Needle - 34 cm Long', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/6/7/0/670.jpg', NULL, '2019-03-02 06:27:40', 0.79, 0.25, 0, 1.58, 3, 1.58, 0, 1.58, 0, 0, '8.44E+12', 'AW800006-15', '2018-12-31 00:00:00', 0.79, 0.47, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(45, 'Circular Knitting Needle - 120 cm Long', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/6/7/1/671.jpg', NULL, '2019-03-02 06:28:31', 0.79, 0.25, 0, 1.16, 3, 1.16, 0, 1.16, 0, 0, '8.44E+12', 'AW800012-6', '2019-02-01 00:00:00', 0.58, 0.348, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(46, 'Circular Knitting Needle - 40 cm Long', '', 20, 1, '', 'http://artisansworld.co.uk/img/p/6/7/4/674.jpg', NULL, '2019-03-02 06:27:53', 0.79, 0.25, 0, 1, 3, 0.68, 0, 0.68, 0, 0, '8.44E+12', 'AW830098', '2018-12-31 00:00:00', 0.34, 0.2, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(47, 'Circular Knitting Needle - 80 cm Long', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/6/7/7/677.jpg', NULL, '2019-03-02 06:28:01', 0.79, 0.25, 0, 1.08, 3, 1.08, 0, 1.08, 0, 0, '8.44E+12', 'AW830127', '2018-12-31 00:00:00', 0.54, 0.32, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(48, 'Circular Knitting Needle - 81 cm Long', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/6/8/0/680.jpg', NULL, '2019-03-02 06:28:09', 0.79, 0.25, 0, 2.3, 3, 2.3, 0, 2.3, 0, 0, '8.44E+12', 'AWB0080689', '2018-12-31 00:00:00', 1.15, 0.69, 8, NULL, NULL, NULL, NULL, NULL, NULL),
(49, 'Wooden Yarn Holder', 'B076YFTSKM', 107, 1, '', 'http://artisansworld.co.uk/685-large_default/wooden-yarn-holder.jpg', NULL, '2019-03-17 06:44:23', 2.85, 0.5, 0, 16.94, 3, 19.88, 2.46, 19.88, 2.98, 5.15, '8438611358814', 'SH-402', NULL, 6.93, 8, 7, 22.91, 6.52, 25.91, NULL, 8.94, 6),
(50, 'Wooden Drop Spindle - Top Whorl', 'B076Y8NNYF', 13, 10, '', 'http://artisansworld.co.uk/img/p/6/9/4/694.jpg', NULL, '2019-03-09 04:55:57', 0.79, 0.5, 0, 11.98, 3, 14.78, 1.95, 15.98, 2.4, 4.02, '8438611358845', 'SH-301', NULL, 6.06, 7, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(51, 'Lucet Braiding Tool', '', 3, 1, '', 'http://artisansworld.co.uk/img/p/7/0/0/700.jpg', NULL, '2019-03-02 06:30:39', 0.79, 0.25, 0, 4.16, 3, 4.16, 0, 4.16, 0, 0, '8.44E+12', 'SH-101', '2019-02-01 00:00:00', 2.08, 1.25, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(52, 'Wooden Shawl Pin - Heart Shaped', '', 9, 1, '', 'http://artisansworld.co.uk/img/p/7/0/7/707.jpg', NULL, '2019-03-02 06:24:17', 0.79, 0.25, 0, 4.48, 3, 4.48, 0, 4.48, 0, 0, 'bye luv', 'SH-201', NULL, 2.24, 1.34, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(53, 'Rose Wood Knitting Needles - 8 mm', '', 1, 1, '', 'http://artisansworld.co.uk/img/p/7/2/1/721.jpg', NULL, '2019-03-02 06:23:52', 0.79, 0.25, 0, 6.98, 3, 6.98, 0, 6.98, 0, 0, '8.44E+12', 'RK-008', NULL, 3.49, 2.094, 5, NULL, NULL, NULL, NULL, NULL, NULL),
(54, 'Wooden Yarn Bowl - 7" X 3"', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/7/2/8/728.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 27.98, 3, 27.98, 0, 27.98, 0, 0, '7.43E+12', 'NC-009', '2019-02-01 00:00:00', 13.99, 8.394, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(55, 'Shawl Pin - Steam Beech Wood', 'B077RJ2X75', 25, 1, '', 'http://artisansworld.co.uk/img/p/7/4/2/742.jpg', NULL, '2019-03-16 06:53:24', 0.79, 0.25, 0, 4.98, 3, 5.48, 0.72, 5.98, 0.9, 2.24, '8438611359057', 'HSPA-12', NULL, 1.8, 1.5, 1, 7.4, 2.84, 7.98, NULL, 3.31, 2),
(56, 'Rosewood Shawl Pin - HSPA-17', 'B077RF7SCH', 25, 1, '', 'http://artisansworld.co.uk/img/p/8/3/5/835.jpg', NULL, '2019-03-16 06:35:29', 0.79, 0.25, 0, 4.98, 3, 5.25, 0.72, 5.44, 0.82, 2.17, '8438611358395', 'HSPA-17', NULL, 1.8, 1.5, 1, 7.4, 2.75, 8.4, NULL, 3.37, 2),
(57, 'Rosewood Shawl Pin - HSPA-20', 'B077RJ4J75', 23, 1, '', 'http://artisansworld.co.uk/img/p/9/1/9/919.jpg', NULL, '2019-03-16 06:46:32', 0.79, 0.25, 0, 4.98, 3, 6.2, 0.82, 6.2, 0.93, 2.4, '8438611358579', 'HSPA-20', NULL, 1.8, 1.5, 1, 7.2, 2.72, 8.2, NULL, 3.34, 2),
(58, 'Wooden Shawl Pin - HSPA-23', '', 25, 1, '', 'http://artisansworld.co.uk/img/p/8/3/4/834.jpg', NULL, '2019-03-09 05:11:49', 0.79, 0.25, 0, 4.98, 3, 4.98, 0, 5.98, 0, 2.24, '8438611358609', 'HSPA-23', NULL, 1.8, 1.5, 9, NULL, NULL, NULL, NULL, NULL, NULL),
(59, 'Wooden Carved Shawl Pin - HSPA-24', 'B077RM8XQL', 24, 1, '', 'http://artisansworld.co.uk/img/p/7/5/9/759.jpg', NULL, '2019-03-16 06:54:53', 0.79, 0.25, 0, 4.98, 3, 5.98, 0, 5.98, 0.9, 2.37, '8438611358753', 'HSPA-24', NULL, 1.8, 1.5, 9, 6.98, 2.86, 7.98, NULL, 3.44, 3),
(60, 'Rosewood Crochet Hooks - Set of 4', 'B078BM2ZXK', 8, 1, '', 'http://artisansworld.co.uk/img/p/7/7/6/776.jpg', NULL, '2019-03-16 06:32:18', 0.79, 0.5, 0, 11.45, 3, 12.68, 0, 12.84, 1.93, 3.4, '8438611358180', 'SH-118', NULL, 6.34, 3.804, 1, 15.64, 4.16, 17.14, NULL, 4.81, 3),
(61, 'Rosewood Nostepinne Centre Pull Yarn Winder', 'B07CWF712D', 11, 1, '', 'http://artisansworld.co.uk/img/p/8/1/5/815.jpg', NULL, '2019-03-09 05:16:55', 0.79, 0.25, 0, 4.98, 3, 8.2, 1.08, 8, 1.12, 2.67, '7426872492058', 'SK-542', NULL, 1.66, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(62, 'Rosewood Crochet Hooks - Small | Set of 3', '', 10, 1, '', 'http://artisansworld.co.uk/img/p/8/1/9/819.jpg', NULL, '2019-03-02 06:24:11', 0.79, 0.5, 0, 10.98, 3, 10.98, 0, 10.98, 0, 0, '7426872492072', 'SH-119', NULL, 2.62, 2.47, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(63, 'Snake Boat', '', 2, 1, '', 'http://artisansworld.co.uk/img/p/8/4/6/846.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 18.5, 3, 18.5, 0, 18.5, 0, 0, '7.43E+12', 'BM-2104', '2019-02-01 00:00:00', 9.25, 5.55, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(64, 'Maple Wood Nostepinne Centre Pull Yarn Winder', 'B07J2FCDFJ', 10, 1, '', 'http://artisansworld.co.uk/img/p/8/4/7/847.jpg', NULL, '2019-03-02 06:25:02', 0.79, 0.25, 0, 4.9, 3, 7.5, 0, 7.5, 1.13, 0, '7426872492102', 'SK-544', NULL, 1.66, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(65, 'Hexagonal Wooden Jewellery Box', '', 2, 1, '', 'http://artisansworld.co.uk/img/p/8/5/5/855.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 11.48, 3, 11.48, 0, 11.48, 0, 0, '7.43E+12', 'CK-004', '2019-02-01 00:00:00', 5.74, 3.444, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(66, 'Vintage Pirate Style Extendable Telescope', '', 491, 1, '', 'http://artisansworld.co.uk/img/p/8/5/7/857.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 24.98, 3, 24.98, 0, 24.98, 0, 0, '7.43E+12', 'CK-412', '2018-12-31 00:00:00', 12.49, 7.49, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(67, 'Guitar Shaped Wooden Key Holder', '', 0, 1, '', 'http://artisansworld.co.uk/img/p/8/6/3/863.jpg', NULL, '2019-03-06 07:28:46', 2.85, 0.25, 0, 17.98, 3, 17.98, 0, 17.98, 0, 0, '7.43E+12', 'CK-214', '2019-02-01 00:00:00', 8.99, 5.394, 6, NULL, NULL, NULL, NULL, NULL, NULL),
(68, 'Dominoes Box Set - Double Six', 'B07K5QFW75', 15, 1, '', 'http://artisansworld.co.uk/img/p/8/7/0/870.jpg', NULL, '2019-03-16 06:48:18', 2.85, 0.25, 0, 16.88, 3, 16.88, 0, 16.88, 2.55, 4.72, '7426872492140', 'NC-009', NULL, 8.95, 7, 2, 19.98, 6.08, NULL, NULL, NULL, 6),
(69, 'Amish Style Tabletop Wooden Yarn Winder', 'B07P2KQS2G', 20, 5, '', 'http://artisansworld.co.uk/924-large_default/amish-style-tabletop-wooden-yarn-winder.jpg', NULL, '2019-03-06 07:28:46', 2.85, 1.25, 0, 22.82, 3, 26.98, 0, 26.98, 4.05, 0, '7426872492164', 'SH-412', NULL, 14.59, 13.78, 1, NULL, NULL, NULL, NULL, NULL, NULL),
(70, 'Umbrella Yarn Swift - Premium Range', 'B07N1WF9YT', 20, 6, '', 'http://artisansworld.co.uk/img/p/9/1/0/910.jpg', NULL, '2019-03-16 06:41:43', 2.85, 1.25, 0, 27.98, 3, 28.46, 3.76, 28.46, 4.27, 6.44, '7426872492171', 'SH-414', NULL, 14.59, 13.78, 1, 36.06, 8.49, 38.06, NULL, 10.76, 6),
(71, 'Chinese Checkers OTTO', '', 1, 1, 'Supplied by OTTO(Only 1)', 'http://artisansworld.co.uk/img/p/9/0/1/901.jpg', NULL, '2019-03-06 07:28:46', 2.85, 1.25, NULL, 29, 3, NULL, NULL, NULL, NULL, NULL, '7426872492140', 'OTTO23', '2019-02-01 00:00:00', 0, 7.1, 2, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `shipment`
--

CREATE TABLE IF NOT EXISTS `shipment` (
  `shipment_id` int(11) NOT NULL,
  `shipment_date` date DEFAULT NULL,
  `courier` int(11) DEFAULT NULL,
  `tracking_number` varchar(45) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `invoice` int(11) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `shipment_number` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipment`
--

INSERT INTO `shipment` (`shipment_id`, `shipment_date`, `courier`, `tracking_number`, `delivery_date`, `invoice`, `modified_by`, `modified_on`, `shipment_number`) VALUES
(1, '2018-12-18', 1, '435435FDG', '2018-12-20', 6, NULL, NULL, 1),
(2, '2018-12-20', 2, 'VBCVXB464', '2018-12-26', 6, NULL, NULL, 2),
(3, '2019-01-04', 1, 'WER45T', '2019-01-04', 7, NULL, NULL, 1),
(14, '2018-10-15', 2, 'SOMENO', '2018-10-18', 8, NULL, NULL, 1),
(15, '2018-10-15', 3, 'SOMENO', '2018-10-19', 8, NULL, NULL, 2),
(16, '2019-01-20', 1, 'UPS2345', '2019-01-21', 9, NULL, NULL, 1),
(17, '2019-02-14', 2, 'DSFASDFADS', '2019-02-14', 14, NULL, NULL, 1),
(18, '2019-03-02', 4, 'XSDERFTGH', '2019-03-06', 17, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `shipment_product`
--

CREATE TABLE IF NOT EXISTS `shipment_product` (
  `shipment_product_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `cost_price_usd` double DEFAULT NULL,
  `cost_price_gbp` double DEFAULT NULL,
  `landing_cost_gbp` double DEFAULT NULL,
  `product_qty` int(11) DEFAULT NULL,
  `shipment` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `amz_fba_fees` double DEFAULT NULL,
  `amz_fees` double DEFAULT NULL,
  `amz_rrp` double DEFAULT NULL,
  `ebay_fees` double DEFAULT NULL,
  `ebay_rrp` double DEFAULT NULL,
  `other_charges` double DEFAULT NULL,
  `web_rrp` double DEFAULT NULL,
  `web_profit` double DEFAULT NULL,
  `ebay_profit` double DEFAULT NULL,
  `amz_profit` double DEFAULT NULL,
  `amz_fba_profit` double DEFAULT NULL,
  `amz_de_rrp` double DEFAULT NULL,
  `amz_de_fba_fees` double DEFAULT NULL,
  `amz_fr_rrp` double DEFAULT NULL,
  `amz_de_fba_profit` double DEFAULT NULL,
  `amz_fr_fba_profit` double DEFAULT NULL,
  `amz_fr_fba_fees` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipment_product`
--

INSERT INTO `shipment_product` (`shipment_product_id`, `date`, `cost_price_usd`, `cost_price_gbp`, `landing_cost_gbp`, `product_qty`, `shipment`, `product`, `modified_by`, `modified_on`, `amz_fba_fees`, `amz_fees`, `amz_rrp`, `ebay_fees`, `ebay_rrp`, `other_charges`, `web_rrp`, `web_profit`, `ebay_profit`, `amz_profit`, `amz_fba_profit`, `amz_de_rrp`, `amz_de_fba_fees`, `amz_fr_rrp`, `amz_de_fba_profit`, `amz_fr_fba_profit`, `amz_fr_fba_fees`) VALUES
(2, NULL, 12.69, 10.98, 11.47, 130, 3, 66, NULL, NULL, 0, 0, 24.98, 0, 24.98, 0, 24.98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, '2019-01-04', 1.99, 1.19, 1.24, 5, 3, 19, NULL, NULL, 0, 0, 3.98, 0, 3.98, 0, 3.98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, '2019-01-04', 1.61, 1.21, 1.26, 25, 3, 41, NULL, NULL, 0, 0, 3.22, 0, 3.22, 0, 3.22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, '2019-01-21', 11.526, 19.21, 19.83, 20, 16, 70, NULL, NULL, 0, 0, 38.42, 0, 38.42, 0, 38.42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, '2019-02-14', 1.494, 2.49, 3.15, 20, 17, 37, NULL, NULL, 0, 0, 4.98, 0, 4.98, 0, 4.98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, '2019-03-06', 0, 8.75, 8.81, 50, 18, 49, NULL, NULL, 2.17, 2.98, 19.88, 2.46, 19.88, 0, 16.94, 5.24, 4.02, 4.14, 4.39, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '2018-12-20', 11, 8.86, 8.86, 60, 1, 29, NULL, '2019-03-16 17:20:30', 5.29, 5.29, 35.28, 3.81, 35.28, 2.5, 32.48, 16.05, 14.25, 13.47, 16.32, 39.76, 9.62, 43.38, 15.61, 16.63, 11.78),
(13, '2018-12-20', 10.2, 8.22, 8.22, 20, 1, 32, NULL, NULL, 5.17, 3, 19.98, 3, 20.98, 0, 18.19, 7.29, 5.39, 5.06, 5.31, 23.67, 6.63, 25.27, 7.24, 6.19, 8.84);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `supplier_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comments` varchar(4000) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `name`, `location`, `modified_by`, `modified_on`, `comments`) VALUES
(1, 'Shahid Handicrafts', 'Sahranpur UP', NULL, '2018-12-09 06:51:08', NULL),
(2, 'Otto International', 'Moradabad', NULL, '2018-12-15 06:08:21', NULL),
(3, 'Maximus International', 'Roorke', NULL, '2019-03-02 06:49:08', 'Ensure Chinese checkers is bubble wrapped. Yarn Bowls should be in individual boxes'),
(4, 'Krishna Handicrafts', 'Sahranpur UP', NULL, '2019-02-21 05:45:24', NULL),
(5, 'Shell Creative - Rinky', 'Sahranpur UP', NULL, '2019-02-24 08:41:13', NULL),
(6, 'Kochi', 'Kochi', NULL, '2019-02-24 07:47:34', NULL),
(7, 'Hozda Green Industries', 'Sahranpur UP', NULL, '2019-02-24 07:48:40', NULL),
(8, 'Shandong PT Intl Trade Co. Ltd', 'China', NULL, '2019-02-24 08:45:44', NULL),
(9, 'High Standard Products', 'Moradabad', NULL, '2019-02-24 08:51:44', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `admin` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `modified_by`, `modified_on`, `admin`) VALUES
(1, 'Jack Bauer', 0, NULL, 0),
(2, 'Chloe O''Brian', 0, NULL, 0),
(3, 'Boby Jacob', 0, NULL, 0),
(4, 'Boby Jacob', 0, NULL, 0),
(5, 'Abbie', 0, NULL, 0),
(6, 'Anjali', 0, NULL, 0),
(7, 'pete', 0, NULL, 0),
(8, 'sara', 0, NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amazon_fba_size_fees`
--
ALTER TABLE `amazon_fba_size_fees`
  ADD PRIMARY KEY (`amazon_fba_size_fees_id`);

--
-- Indexes for table `courier`
--
ALTER TABLE `courier`
  ADD PRIMARY KEY (`courier_id`),
  ADD KEY `courier_user_fk_idx` (`modified_by`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`),
  ADD KEY `supplier_fk_idx` (`supplier`),
  ADD KEY `invoice_user_fk_idx` (`modified_by`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `FKl2vupp7o1q5dmaf2ownok1ros` (`invoice`),
  ADD KEY `FKjx9qudi2iywftx6yyqyc0sxd4` (`shipment`),
  ADD KEY `FK6ob3kejx3r2yoionomqp7awm2` (`modified_by`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_user_fk_idx` (`modified_by`),
  ADD KEY `supplier_fk_idx` (`supplier`),
  ADD KEY `amazon_fba_size_fees_fk_idx` (`amazon_fba_size_fees`);

--
-- Indexes for table `shipment`
--
ALTER TABLE `shipment`
  ADD PRIMARY KEY (`shipment_id`),
  ADD KEY `courier_fk_idx` (`courier`),
  ADD KEY `invoice_fk_idx` (`invoice`),
  ADD KEY `shipment_user_fk_idx` (`modified_by`);

--
-- Indexes for table `shipment_product`
--
ALTER TABLE `shipment_product`
  ADD PRIMARY KEY (`shipment_product_id`),
  ADD KEY `shipment_fk_idx` (`shipment`),
  ADD KEY `product_fk_idx` (`product`),
  ADD KEY `shipment_product_user_fk_idx` (`modified_by`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`),
  ADD KEY `supplier_user_fk_idx` (`modified_by`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courier`
--
ALTER TABLE `courier`
  MODIFY `courier_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT for table `shipment`
--
ALTER TABLE `shipment`
  MODIFY `shipment_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `shipment_product`
--
ALTER TABLE `shipment_product`
  MODIFY `shipment_product_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `courier`
--
ALTER TABLE `courier`
  ADD CONSTRAINT `courier_user_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_user_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `supplier_fk` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `amazon_fba_size_fees_fk` FOREIGN KEY (`amazon_fba_size_fees`) REFERENCES `amazon_fba_size_fees` (`amazon_fba_size_fees_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_supplier_fk` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_user_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `shipment`
--
ALTER TABLE `shipment`
  ADD CONSTRAINT `courier_fk` FOREIGN KEY (`courier`) REFERENCES `courier` (`courier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `inv_ship_fk` FOREIGN KEY (`invoice`) REFERENCES `invoice` (`invoice_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `shipment_user_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `shipment_product`
--
ALTER TABLE `shipment_product`
  ADD CONSTRAINT `product_fk` FOREIGN KEY (`product`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `shipment_fk` FOREIGN KEY (`shipment`) REFERENCES `shipment` (`shipment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `shipment_product_user_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `supplier_user_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
