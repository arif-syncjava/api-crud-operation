CREATE SCHEMA IF NOT EXISTS devices;
SET search_path TO devices;

DROP TABLE IF EXISTS mobile_devices;
CREATE TABLE mobile_devices (
      imei SERIAL PRIMARY KEY,
      brand_name VARCHAR (100) NOT NULL,
      model_name VARCHAR (150) NOT NULL

);