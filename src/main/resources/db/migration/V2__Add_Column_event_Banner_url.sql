ALTER TABLE `EVENT`
ADD `banner_url` VARCHAR(100) DEFAULT NULL AFTER `meeting_instructions`;

ALTER TABLE `EVENT`
ADD `event_url` VARCHAR(100) DEFAULT NULL AFTER `banner_url`;

