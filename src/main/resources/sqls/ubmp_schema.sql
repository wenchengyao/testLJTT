SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bla_action_ref_device
-- ----------------------------
DROP TABLE IF EXISTS `bla_action_ref_device`;
CREATE TABLE `bla_action_ref_device` (
  `plan_action_id_` bigint(20) NOT NULL,
  `device_id_` varchar(255) NOT NULL,
  PRIMARY KEY (`plan_action_id_`,`device_id_`),
  KEY `FKrpvwkuda5r80lagdkei2q5cts` (`device_id_`),
  CONSTRAINT `FK4dq6r7352yi4psc24i3ohhx5f` FOREIGN KEY (`plan_action_id_`) REFERENCES `bla_plan_action` (`plan_action_id_`),
  CONSTRAINT `FKrpvwkuda5r80lagdkei2q5cts` FOREIGN KEY (`device_id_`) REFERENCES `bla_sensor` (`sensor_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_action_ref_group
-- ----------------------------
DROP TABLE IF EXISTS `bla_action_ref_group`;
CREATE TABLE `bla_action_ref_group` (
  `plan_action_id_` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`plan_action_id_`,`group_id`),
  KEY `FKru1n9lu66oyav4j2lk214046a` (`group_id`),
  CONSTRAINT `FK49xrxltn7omj1sydiiov4obgq` FOREIGN KEY (`plan_action_id_`) REFERENCES `bla_plan_action` (`plan_action_id_`),
  CONSTRAINT `FKru1n9lu66oyav4j2lk214046a` FOREIGN KEY (`group_id`) REFERENCES `sm_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_action_ref_lamppost
-- ----------------------------
DROP TABLE IF EXISTS `bla_action_ref_lamppost`;
CREATE TABLE `bla_action_ref_lamppost` (
  `plan_action_id_` bigint(20) NOT NULL,
  `id_` bigint(20) NOT NULL,
  PRIMARY KEY (`plan_action_id_`,`id_`),
  KEY `FKhe9fbm9mlq638ro0mspbpfsla` (`id_`),
  CONSTRAINT `FKhe9fbm9mlq638ro0mspbpfsla` FOREIGN KEY (`id_`) REFERENCES `sm_lamppost` (`id_`),
  CONSTRAINT `FKkln3ha5qlhl90sk7jwpvfp866` FOREIGN KEY (`plan_action_id_`) REFERENCES `bla_plan_action` (`plan_action_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_action_ref_playlist
-- ----------------------------
DROP TABLE IF EXISTS `bla_action_ref_playlist`;
CREATE TABLE `bla_action_ref_playlist` (
  `plan_action_id_` bigint(20) NOT NULL,
  `playlist_id_` bigint(20) NOT NULL,
  PRIMARY KEY (`plan_action_id_`,`playlist_id_`),
  KEY `FKracso4f7tgi3hff5onkp8noby` (`playlist_id_`),
  CONSTRAINT `FK6wcqvmxa4x7r4tyhsqop347c` FOREIGN KEY (`plan_action_id_`) REFERENCES `bla_plan_action` (`plan_action_id_`),
  CONSTRAINT `FKracso4f7tgi3hff5onkp8noby` FOREIGN KEY (`playlist_id_`) REFERENCES `sm_playlist` (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_alarm
-- ----------------------------
DROP TABLE IF EXISTS `bla_alarm`;
CREATE TABLE `bla_alarm` (
  `alarm_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `alarm_level_` int(11) DEFAULT NULL,
  `alarm_time_` datetime DEFAULT NULL,
  `category_` varchar(255) DEFAULT NULL,
  `device_id_` varchar(255) DEFAULT NULL,
  `monitor_value_` double DEFAULT NULL,
  `status_` int(11) DEFAULT NULL,
  `threshold_` double DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`alarm_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_alarm_category
-- ----------------------------
DROP TABLE IF EXISTS `bla_alarm_category`;
CREATE TABLE `bla_alarm_category` (
  `alarm_category_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `description_` varchar(32) DEFAULT NULL,
  `name_` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`alarm_category_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_camera
-- ----------------------------
DROP TABLE IF EXISTS `bla_camera`;
CREATE TABLE `bla_camera` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `HW_device_code_` varchar(255) DEFAULT NULL,
  `IMEI_` varchar(255) DEFAULT NULL,
  `vendor_type_` varchar(255) DEFAULT NULL,
  `camera_model_` varchar(255) DEFAULT NULL,
  `camera_name_` varchar(255) DEFAULT NULL,
  `camera_server_id_` bigint(20) DEFAULT NULL,
  `camera_type_` int(11) DEFAULT NULL,
  `create_date_` datetime DEFAULT NULL,
  `creator_` bigint(20) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `device_type_` int(11) DEFAULT NULL,
  `http_port_` int(11) DEFAULT NULL,
  `ip_address_` varchar(255) DEFAULT NULL,
  `is_delete_` varchar(255) DEFAULT NULL,
  `lamppost_id_` bigint(20) DEFAULT NULL,
  `latitude_` varchar(255) DEFAULT NULL,
  `longitude_` varchar(255) DEFAULT NULL,
  `modify_date_` datetime DEFAULT NULL,
  `password_` varchar(255) DEFAULT NULL,
  `protocolType` varchar(255) DEFAULT NULL,
  `rtsp_port_` int(11) DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `tasip_` varchar(255) DEFAULT NULL,
  `user_name_` varchar(255) DEFAULT NULL,
  `vender_port_` int(11) DEFAULT NULL,
  `protocol_type` varchar(255) DEFAULT NULL,
  `suffix_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_cameras_server
-- ----------------------------
DROP TABLE IF EXISTS `bla_cameras_server`;
CREATE TABLE `bla_cameras_server` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time_` datetime DEFAULT NULL,
  `creator_` bigint(20) DEFAULT NULL,
  `ip_` varchar(255) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `password_` varchar(255) DEFAULT NULL,
  `port_` varchar(255) DEFAULT NULL,
  `userName_` varchar(255) DEFAULT NULL,
  `user_name_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_camera_download
-- ----------------------------
DROP TABLE IF EXISTS `bla_camera_download`;
CREATE TABLE `bla_camera_download` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `HW_device_code_` varchar(255) DEFAULT NULL,
  `camera_name_` varchar(255) DEFAULT NULL,
  `download_url_` varchar(255) DEFAULT NULL,
  `end_time_` varchar(255) DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `start_time_` varchar(255) DEFAULT NULL,
  `status_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_collection
-- ----------------------------
DROP TABLE IF EXISTS `bla_collection`;
CREATE TABLE `bla_collection` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time_` datetime DEFAULT NULL,
  `creator_` bigint(20) DEFAULT NULL,
  `latitude_` decimal(19,2) DEFAULT NULL,
  `longitude_` decimal(19,2) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `zoom_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_envmonitor_data
-- ----------------------------
DROP TABLE IF EXISTS `bla_envmonitor_data`;
CREATE TABLE `bla_envmonitor_data` (
  `envmonitor_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `ambientNoise_` float DEFAULT NULL,
  `collect_time_` datetime DEFAULT NULL,
  `device_id_` varchar(255) DEFAULT NULL,
  `humidity_` float DEFAULT NULL,
  `pat_` float DEFAULT NULL,
  `pm_` float DEFAULT NULL,
  `pm1_` float DEFAULT NULL,
  `pm10_` float DEFAULT NULL,
  `temperature_` float DEFAULT NULL,
  `windSpeed_` float DEFAULT NULL,
  `ambient_noise_` float DEFAULT NULL,
  `wind_speed_` float DEFAULT NULL,
  PRIMARY KEY (`envmonitor_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_home_color
-- ----------------------------
DROP TABLE IF EXISTS `bla_home_color`;
CREATE TABLE `bla_home_color` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `color_` varchar(255) DEFAULT NULL,
  `index_` int(11) DEFAULT NULL,
  `model_` varchar(255) DEFAULT NULL,
  `user_id_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_loop_light_select
-- ----------------------------
DROP TABLE IF EXISTS `bla_loop_light_select`;
CREATE TABLE `bla_loop_light_select` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_id_` varchar(255) DEFAULT NULL,
  `light_select_` varchar(255) DEFAULT NULL,
  `loop_select_` varchar(255) DEFAULT NULL,
  `plan_action_id_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_`),
  KEY `FKnwfmyrwnafowoml9alp76a0v1` (`plan_action_id_`),
  CONSTRAINT `FKnwfmyrwnafowoml9alp76a0v1` FOREIGN KEY (`plan_action_id_`) REFERENCES `bla_plan_action` (`plan_action_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_plan
-- ----------------------------
DROP TABLE IF EXISTS `bla_plan`;
CREATE TABLE `bla_plan` (
  `plan_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time_` datetime DEFAULT NULL,
  `creater_` bigint(20) DEFAULT NULL,
  `end_time_` datetime DEFAULT NULL,
  `interval_` int(11) DEFAULT NULL,
  `interval_type_` int(11) DEFAULT NULL,
  `is_template_` int(11) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `plan_type_` int(11) DEFAULT NULL,
  `producer_` varchar(255) DEFAULT NULL,
  `send_obj_` int(11) DEFAULT NULL,
  `start_time_` datetime DEFAULT NULL,
  `status_` int(11) DEFAULT NULL,
  `time_type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`plan_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_plan_action
-- ----------------------------
DROP TABLE IF EXISTS `bla_plan_action`;
CREATE TABLE `bla_plan_action` (
  `plan_action_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `condition_` int(11) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `exec_time_` varchar(255) DEFAULT NULL,
  `index_` int(11) DEFAULT NULL,
  `item_value_` varchar(255) DEFAULT NULL,
  `operation_type_` int(11) DEFAULT NULL,
  `plan_id_` bigint(20) DEFAULT NULL,
  `retry_times_` int(11) DEFAULT NULL,
  `revised_flag_` int(11) DEFAULT NULL,
  `revised_time_` int(11) DEFAULT NULL,
  `task_obj_` int(11) DEFAULT NULL,
  PRIMARY KEY (`plan_action_id_`),
  KEY `FKk67ukyxf02pc97ujv0cot5j3l` (`plan_id_`),
  CONSTRAINT `FKk67ukyxf02pc97ujv0cot5j3l` FOREIGN KEY (`plan_id_`) REFERENCES `bla_plan` (`plan_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_plan_exec_status
-- ----------------------------
DROP TABLE IF EXISTS `bla_plan_exec_status`;
CREATE TABLE `bla_plan_exec_status` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `exec_time_` varchar(255) DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `task_id_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_plan_ref_device
-- ----------------------------
DROP TABLE IF EXISTS `bla_plan_ref_device`;
CREATE TABLE `bla_plan_ref_device` (
  `plan_id_` bigint(20) NOT NULL,
  `device_id_` varchar(255) NOT NULL,
  PRIMARY KEY (`plan_id_`,`device_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_plan_send_entity
-- ----------------------------
DROP TABLE IF EXISTS `bla_plan_send_entity`;
CREATE TABLE `bla_plan_send_entity` (
  `task_id_` bigint(20) NOT NULL,
  `action_id_` bigint(20) DEFAULT NULL,
  `end_time_` datetime DEFAULT NULL,
  `exec_time_` varchar(255) DEFAULT NULL,
  `gateway_id_` varchar(255) DEFAULT NULL,
  `interval_` varchar(255) DEFAULT NULL,
  `item_value_` varchar(255) DEFAULT NULL,
  `light_select_` varchar(255) DEFAULT NULL,
  `loop_select_` int(11) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `operation_type_` int(11) DEFAULT NULL,
  `plan_id_` bigint(20) DEFAULT NULL,
  `plan_type_` int(11) DEFAULT NULL,
  `retry_times_` int(11) DEFAULT NULL,
  `send_obj_` int(11) DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `start_time_` datetime DEFAULT NULL,
  `status_` int(11) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_plan_send_log
-- ----------------------------
DROP TABLE IF EXISTS `bla_plan_send_log`;
CREATE TABLE `bla_plan_send_log` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `plan_id_` bigint(20) DEFAULT NULL,
  `send_result_` varchar(255) DEFAULT NULL,
  `send_time_` datetime DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `task_id_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor`;
CREATE TABLE `bla_sensor` (
  `sensor_id_` varchar(255) NOT NULL,
  `arch_id_` bigint(20) DEFAULT NULL,
  `asset_num_` varchar(255) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `creater_` bigint(20) DEFAULT NULL,
  `del_flag_` int(11) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `device_model_id_` bigint(20) DEFAULT NULL,
  `device_type_id_` bigint(20) DEFAULT NULL,
  `gateway_id_` varchar(255) DEFAULT NULL,
  `install_location_` varchar(255) DEFAULT NULL,
  `ip_` varchar(255) DEFAULT NULL,
  `is_ctl_device_` int(11) DEFAULT NULL,
  `latitude_` decimal(19,2) DEFAULT NULL,
  `line_number_` varchar(255) DEFAULT NULL,
  `longitude_` decimal(19,2) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `oldsensor_id_` varchar(255) DEFAULT NULL,
  `online_status_` varchar(255) DEFAULT NULL,
  `port_` int(11) DEFAULT NULL,
  `power_` double DEFAULT NULL,
  `provider_` varchar(255) DEFAULT NULL,
  `sensor_use_` bigint(20) DEFAULT NULL,
  `signal_strength_` int(11) DEFAULT NULL,
  `lamppost_id_` bigint(20) DEFAULT NULL,
  `suffix_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sensor_id_`),
  KEY `FKajt9ve1u67381bk4uekc2q7fa` (`lamppost_id_`),
  CONSTRAINT `FKajt9ve1u67381bk4uekc2q7fa` FOREIGN KEY (`lamppost_id_`) REFERENCES `sm_lamppost` (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor_alarm_param
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor_alarm_param`;
CREATE TABLE `bla_sensor_alarm_param` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `type_` varchar(255) DEFAULT NULL,
  `value_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor_day_energy
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor_day_energy`;
CREATE TABLE `bla_sensor_day_energy` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `day_` int(11) DEFAULT NULL,
  `day_energy_` double DEFAULT NULL,
  `device_type_` bigint(20) DEFAULT NULL,
  `month_` int(11) DEFAULT NULL,
  `month_energy_` double DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `update_time_` datetime DEFAULT NULL,
  `year_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor_energy
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor_energy`;
CREATE TABLE `bla_sensor_energy` (
  `sensor_id_` varchar(255) NOT NULL,
  `current_` double DEFAULT NULL,
  `current_B_` double DEFAULT NULL,
  `electricity_` double DEFAULT NULL,
  `frequency_` double DEFAULT NULL,
  `power_` double DEFAULT NULL,
  `power_factor_` double DEFAULT NULL,
  `voltage_` double DEFAULT NULL,
  `voltage_B_` double DEFAULT NULL,
  PRIMARY KEY (`sensor_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor_month_energy
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor_month_energy`;
CREATE TABLE `bla_sensor_month_energy` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_type_` bigint(20) DEFAULT NULL,
  `month_` int(11) DEFAULT NULL,
  `month_energy_` double DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `update_time_` datetime DEFAULT NULL,
  `year_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor_property
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor_property`;
CREATE TABLE `bla_sensor_property` (
  `sensor_id_` varchar(255) NOT NULL,
  `brightness_` int(11) DEFAULT NULL,
  `camera_code_` varchar(255) DEFAULT NULL,
  `camera_type_` int(11) DEFAULT NULL,
  `gateway_loop_` varchar(255) DEFAULT NULL,
  `has_alarm_` int(11) DEFAULT NULL,
  `humidity_` double DEFAULT NULL,
  `sundown_offset_` int(11) DEFAULT NULL,
  `sunrise_offset_` int(11) DEFAULT NULL,
  `switch_flag_` int(11) DEFAULT NULL,
  `switch_status_` varchar(255) DEFAULT NULL,
  `temperature_` double DEFAULT NULL,
  `time_zone_` int(11) DEFAULT NULL,
  PRIMARY KEY (`sensor_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bla_sensor_switch_status
-- ----------------------------
DROP TABLE IF EXISTS `bla_sensor_switch_status`;
CREATE TABLE `bla_sensor_switch_status` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `dim_value_` int(11) DEFAULT NULL,
  `index_` int(11) DEFAULT NULL,
  `sensor_id_` varchar(255) DEFAULT NULL,
  `switch_status_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`),
  KEY `FK8mjntv2cbslcg3x9527xb481o` (`sensor_id_`),
  CONSTRAINT `FK8mjntv2cbslcg3x9527xb481o` FOREIGN KEY (`sensor_id_`) REFERENCES `bla_sensor` (`sensor_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_architecture
-- ----------------------------
DROP TABLE IF EXISTS `sm_architecture`;
CREATE TABLE `sm_architecture` (
  `arch_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id_` bigint(20) DEFAULT NULL,
  `parent_name_` varchar(255) DEFAULT NULL,
  `level_` int(11) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `number_` varchar(255) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `search_code_` varchar(255) DEFAULT NULL,
  `creator_id_` bigint(20) DEFAULT NULL,
  `has_child_` int(11) DEFAULT NULL,
  `longitude_` decimal(19,2) DEFAULT NULL,
  `latitude_` decimal(19,2) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `update_time_` datetime DEFAULT NULL,
  PRIMARY KEY (`arch_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_architecture_ref_user
-- ----------------------------
DROP TABLE IF EXISTS `sm_architecture_ref_user`;
CREATE TABLE `sm_architecture_ref_user` (
  `user_id_` bigint(20) NOT NULL,
  `arch_id_` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id_`,`arch_id_`),
  KEY `FKohct1oms0ibvicn8gwkbcdavi` (`arch_id_`),
  CONSTRAINT `FKlkh23meyheh3fxcqxtym8n3op` FOREIGN KEY (`user_id_`) REFERENCES `sm_user` (`user_id_`),
  CONSTRAINT `FKohct1oms0ibvicn8gwkbcdavi` FOREIGN KEY (`arch_id_`) REFERENCES `sm_architecture` (`arch_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_customer
-- ----------------------------
DROP TABLE IF EXISTS `sm_customer`;
CREATE TABLE `sm_customer` (
  `id_` bigint(20) NOT NULL,
  `address_` varchar(255) DEFAULT NULL,
  `contact_` varchar(255) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `email_` varchar(255) DEFAULT NULL,
  `name_` varchar(32) DEFAULT NULL,
  `phone_` varchar(255) DEFAULT NULL,
  `remark_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`),
  UNIQUE KEY `UK_m4938dd74i2y66fjbtwdli7t7` (`name_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_device_type
-- ----------------------------
DROP TABLE IF EXISTS `sm_device_type`;
CREATE TABLE `sm_device_type` (
  `device_type_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_` int(11) DEFAULT NULL,
  `type_name_` varchar(255) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `msg_defined_` varchar(255) DEFAULT NULL,
  `is_default_` int(11) DEFAULT NULL,
  `acronym_` varchar(255) DEFAULT NULL,
  `sub_type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`device_type_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sm_dictionary`;
CREATE TABLE `sm_dictionary` (
  `dict_id_` bigint(20) NOT NULL,
  `category_` varchar(255) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `code_` varchar(255) DEFAULT NULL,
  `sort_` int(11) DEFAULT NULL,
  `value_` int(11) DEFAULT NULL,
  PRIMARY KEY (`dict_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_email_contents
-- ----------------------------
DROP TABLE IF EXISTS `sm_email_contents`;
CREATE TABLE `sm_email_contents` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_` varchar(255) DEFAULT NULL,
  `title_` varchar(255) DEFAULT NULL,
  `content_` varchar(255) DEFAULT NULL,
  `message_content_` varchar(255) DEFAULT NULL,
  `telephone_` varchar(255) DEFAULT NULL,
  `message_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_group
-- ----------------------------
DROP TABLE IF EXISTS `sm_group`;
CREATE TABLE `sm_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `device_ids` mediumtext,
  `device_type_id` bigint(20) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `group_obj_` int(11) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `provider_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_i18n
-- ----------------------------
DROP TABLE IF EXISTS `sm_i18n`;
CREATE TABLE `sm_i18n` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `language_id_` bigint(20) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `object_id_` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`),
  KEY `FKoc3kva1f4b3lpph5wrph3lhts` (`language_id_`),
  CONSTRAINT `FKoc3kva1f4b3lpph5wrph3lhts` FOREIGN KEY (`language_id_`) REFERENCES `sm_language` (`language_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_iotdm
-- ----------------------------
DROP TABLE IF EXISTS `sm_iotdm`;
CREATE TABLE `sm_iotdm` (
  `iotdm_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `del_flag_` int(11) DEFAULT NULL,
  `ip_addr_` varchar(255) DEFAULT NULL,
  `is_https_` int(11) DEFAULT NULL,
  `keystore_password_` varchar(255) DEFAULT NULL,
  `keystore_path_` varchar(255) DEFAULT NULL,
  `port_` int(11) DEFAULT NULL,
  `status_` int(11) DEFAULT NULL,
  PRIMARY KEY (`iotdm_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_lamppost
-- ----------------------------
DROP TABLE IF EXISTS `sm_lamppost`;
CREATE TABLE `sm_lamppost` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `arch_id_` bigint(20) DEFAULT NULL,
  `arch_name_` varchar(255) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `deviceTypeId` bigint(20) DEFAULT NULL,
  `excelRow_` int(11) DEFAULT NULL,
  `lamppost_num_` varchar(255) DEFAULT NULL,
  `latitude_` decimal(19,2) DEFAULT NULL,
  `longitude_` decimal(19,2) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `onlineStatus` varchar(255) DEFAULT NULL,
  `sensorId` varchar(255) DEFAULT NULL,
  `showLamp` int(11) DEFAULT NULL,
  `device_type_id` bigint(20) DEFAULT NULL,
  `excel_row_` int(11) DEFAULT NULL,
  `online_status` varchar(255) DEFAULT NULL,
  `sensor_id` varchar(255) DEFAULT NULL,
  `show_lamp` int(11) DEFAULT NULL,
  `device_type_id_` bigint(20) DEFAULT NULL,
  `online_status_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_language
-- ----------------------------
DROP TABLE IF EXISTS `sm_language`;
CREATE TABLE `sm_language` (
  `language_id_` bigint(20) NOT NULL,
  `code_` varchar(255) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`language_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_log_operation
-- ----------------------------
DROP TABLE IF EXISTS `sm_log_operation`;
CREATE TABLE `sm_log_operation` (
  `log_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id_` bigint(20) DEFAULT NULL,
  `account_` varchar(255) DEFAULT NULL,
  `module_id_` varchar(255) DEFAULT NULL,
  `content_` varchar(255) DEFAULT NULL,
  `status_` int(11) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_playlist
-- ----------------------------
DROP TABLE IF EXISTS `sm_playlist`;
CREATE TABLE `sm_playlist` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `audition_status` int(11) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `creator_` bigint(20) DEFAULT NULL,
  `del_flag_` int(11) DEFAULT NULL,
  `file_name_` varchar(255) DEFAULT NULL,
  `file_url_` longtext,
  `role_id_` bigint(20) DEFAULT NULL,
  `role_name_` varchar(255) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `update_time_` datetime DEFAULT NULL,
  `user_name_` varchar(255) DEFAULT NULL,
  `xml_file_url_` longtext,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sm_privilege`;
CREATE TABLE `sm_privilege` (
  `privilege_id_` bigint(20) NOT NULL,
  `parent_id_` bigint(20) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `url_` varchar(255) DEFAULT NULL,
  `seq_` int(11) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `privilege_code_` varchar(255) DEFAULT NULL,
  `level_` int(11) DEFAULT NULL,
  `is_log_` int(11) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `privilege_code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`privilege_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_role
-- ----------------------------
DROP TABLE IF EXISTS `sm_role`;
CREATE TABLE `sm_role` (
  `role_id_` bigint(20) NOT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `creator_` bigint(20) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `customer_id_` bigint(20) DEFAULT NULL,
  `customer_name_` varchar(255) DEFAULT NULL,
  `manage_account_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_role_ref_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sm_role_ref_privilege`;
CREATE TABLE `sm_role_ref_privilege` (
  `role_id_` bigint(20) NOT NULL,
  `privilege_id_` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id_`,`privilege_id_`),
  KEY `FK3ovdi9kqpo8ejlj8sit0wa6am` (`privilege_id_`),
  CONSTRAINT `FK3ovdi9kqpo8ejlj8sit0wa6am` FOREIGN KEY (`privilege_id_`) REFERENCES `sm_privilege` (`privilege_id_`),
  CONSTRAINT `FKh2pkhi7aebvexwe05b9f8hejy` FOREIGN KEY (`role_id_`) REFERENCES `sm_role` (`role_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_system_config
-- ----------------------------
DROP TABLE IF EXISTS `sm_system_config`;
CREATE TABLE `sm_system_config` (
  `sys_key_` varchar(255) NOT NULL,
  `sys_value_` varchar(255) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sys_key_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user
-- ----------------------------
DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user` (
  `user_id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_` varchar(255) DEFAULT NULL,
  `name_` varchar(255) DEFAULT NULL,
  `password_` varchar(255) DEFAULT NULL,
  `image_data_` varchar(255) DEFAULT NULL,
  `telephone_` varchar(255) DEFAULT NULL,
  `fax_` varchar(255) DEFAULT NULL,
  `email_` varchar(255) DEFAULT NULL,
  `address_` varchar(255) DEFAULT NULL,
  `description_` varchar(255) DEFAULT NULL,
  `department_id_` varchar(255) DEFAULT NULL,
  `employee_code_` varchar(255) DEFAULT NULL,
  `create_time_` datetime DEFAULT NULL,
  `creator_` bigint(20) DEFAULT NULL,
  `account_type_` int(11) DEFAULT NULL,
  `reset_pwd_` int(11) DEFAULT NULL,
  `locked_` int(11) DEFAULT NULL,
  `del_flag_` int(11) DEFAULT NULL,
  `register_id_` varchar(255) DEFAULT NULL,
  `customer_id_` varchar(255) DEFAULT NULL,
  `sex_` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_history_p
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_history_p`;
CREATE TABLE `sm_user_history_p` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id_` bigint(20) DEFAULT NULL,
  `password_` varchar(255) DEFAULT NULL,
  `modify_time_` datetime DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_login_info
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_login_info`;
CREATE TABLE `sm_user_login_info` (
  `user_id_` bigint(20) NOT NULL,
  `fst_err_time_` datetime DEFAULT NULL,
  `fst_suc_time_` datetime DEFAULT NULL,
  `error_count_` int(11) DEFAULT NULL,
  `lock_time_` datetime DEFAULT NULL,
  `lock_eff_time_` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_ref_alarmcategory
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_ref_alarmcategory`;
CREATE TABLE `sm_user_ref_alarmcategory` (
  `user_id_` bigint(20) NOT NULL,
  `alarm_category_id_` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id_`,`alarm_category_id_`),
  KEY `FKhidtqkqem499qkpe59umacg58` (`alarm_category_id_`) USING BTREE,
  CONSTRAINT `sm_user_ref_alarmcategory_ibfk_1` FOREIGN KEY (`alarm_category_id_`) REFERENCES `bla_alarm_category` (`alarm_category_id_`),
  CONSTRAINT `sm_user_ref_alarmcategory_ibfk_2` FOREIGN KEY (`user_id_`) REFERENCES `sm_user` (`user_id_`),
  CONSTRAINT `sm_user_ref_alarmcategory_ibfk_3` FOREIGN KEY (`user_id_`) REFERENCES `sm_user` (`user_id_`),
  CONSTRAINT `sm_user_ref_alarmcategory_ibfk_4` FOREIGN KEY (`alarm_category_id_`) REFERENCES `bla_alarm_category` (`alarm_category_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_ref_devicetype
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_ref_devicetype`;
CREATE TABLE `sm_user_ref_devicetype` (
  `user_id_` bigint(20) NOT NULL,
  `device_type_id_` bigint(20) NOT NULL,
  `control_type_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id_`,`device_type_id_`),
  KEY `FK6j8q9r9ftkkyloxl1lp7m721e` (`device_type_id_`),
  CONSTRAINT `FK6j8q9r9ftkkyloxl1lp7m721e` FOREIGN KEY (`device_type_id_`) REFERENCES `sm_device_type` (`device_type_id_`),
  CONSTRAINT `FKd0o6fjgn9qa2ah84rpfchuhh1` FOREIGN KEY (`user_id_`) REFERENCES `sm_user` (`user_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_ref_lamppost
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_ref_lamppost`;
CREATE TABLE `sm_user_ref_lamppost` (
  `user_id_` bigint(20) NOT NULL,
  `clear_` varchar(255) DEFAULT NULL,
  `lamppost_id_` mediumtext,
  PRIMARY KEY (`user_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_ref_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_ref_privilege`;
CREATE TABLE `sm_user_ref_privilege` (
  `user_id_` bigint(20) NOT NULL,
  `privilege_id_` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id_`,`privilege_id_`),
  KEY `FKocekvt4dj0rtihjc70xt71wx0` (`privilege_id_`),
  CONSTRAINT `FK2fxfiu31dpue270n4p13b7qyg` FOREIGN KEY (`user_id_`) REFERENCES `sm_user` (`user_id_`),
  CONSTRAINT `FKocekvt4dj0rtihjc70xt71wx0` FOREIGN KEY (`privilege_id_`) REFERENCES `sm_privilege` (`privilege_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_ref_role
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_ref_role`;
CREATE TABLE `sm_user_ref_role` (
  `user_id_` bigint(20) NOT NULL,
  `role_id_` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id_`,`role_id_`),
  KEY `FKm3a4v0oqcedin8bt6v5do6x9` (`role_id_`),
  CONSTRAINT `FKi3xr1w9uagtpkfxrix0laqj9a` FOREIGN KEY (`user_id_`) REFERENCES `sm_user` (`user_id_`),
  CONSTRAINT `FKm3a4v0oqcedin8bt6v5do6x9` FOREIGN KEY (`role_id_`) REFERENCES `sm_role` (`role_id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
