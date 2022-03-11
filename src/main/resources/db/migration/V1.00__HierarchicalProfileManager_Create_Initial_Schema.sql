CREATE TABLE `admin_master` (
  `admin_id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `admin_name` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `partner_master` (
  `partner_id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `partner_name` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`partner_id`),
  CONSTRAINT `partner_master_FK` FOREIGN KEY (`partner_id`) REFERENCES `admin_master` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `client_master` (
  `client_id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `client_name` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `email_id` varchar(100) NOT NULL,
  `role` text,
  `phone_no` varchar(100) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `client_master_UN` (`client_name`),
  CONSTRAINT `client_master_FK` FOREIGN KEY (`client_id`) REFERENCES `admin_master` (`admin_id`),
  CONSTRAINT `client_master_FK_1` FOREIGN KEY (`client_id`) REFERENCES `partner_master` (`partner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `agent_master` (
  `agent_id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `agent_name` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`agent_id`),
  CONSTRAINT `agent_master_FK` FOREIGN KEY (`agent_id`) REFERENCES `client_master` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;