CREATE TABLE `USER` (
  `id` varchar(40) NOT NULL,
  `email` varchar(100) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `external_id` varchar(40) DEFAULT NULL,
  `id_provider` varchar(20) DEFAULT NULL,
  `properties` varchar(256) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modified_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ;

CREATE TABLE `EVENT` (
  `id` varchar(40) NOT NULL,
  `host_id` varchar(40) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text,
  `event_date_time` timestamp DEFAULT NULL,
  `address1` varchar(250) DEFAULT NULL,
  `address2` varchar(250) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `meeting_instructions` varchar(100) DEFAULT NULL,
  `skills` varchar(100) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modified_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `host_id_fk` FOREIGN KEY (`host_id`) REFERENCES `USER` (`id`)
);

CREATE TABLE `EVENT_VOLUNTEERS` (
  `event_id` varchar(40) NOT NULL,
  `user_id` varchar(40) NOT NULL,
  KEY `event_vol_id_fk` (`event_id`),
  KEY `user_vol_id_fk` (`user_id`),
  CONSTRAINT `event_vol_id_fk` FOREIGN KEY (`event_id`) REFERENCES `EVENT` (`id`),
  CONSTRAINT `user_vol_id_fk` FOREIGN KEY (`user_id`) REFERENCES `USER` (`id`)
);